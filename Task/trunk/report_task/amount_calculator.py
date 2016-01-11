#encoding: utf-8
#!/usr/bin/python

import mysql
import my_logger
import db_config
import mysql_conn
import mail_sender

#######Define private method start#####################

__DATE_FORMAT = '%Y-%m-%d'

def __write_info(content,func='main'):
    my_logger.write_info(content,"amount_calculator",func)

def __write_err(content,func='main'):
    my_logger.write_err(content,"amount_calculator",func)
    mail_sender.send_alerting('''module:%s function:%s
                              content:%s'''
                              %('amount_calculator',func,content))
    
def __write_warn(content,func='main'):
    my_logger.write_warn(content,"amount_calculator",func)
    
    
#######Define private method end#######################
def __main():
    """need run after product_status_changer.py"""
    cnn_product=mysql_conn.get_conn(db_config.config_product)
    if not cnn_product:
        __write_warn("can't get connection of product")
        return
    cursor_product=cnn_product.cursor(dictionary=True)
    
    cnn_sales=mysql_conn.get_conn(db_config.config_sales)
    if not cnn_sales:
        __write_warn("can't get connection of sales")
        return
    cursor_sales=cnn_sales.cursor(dictionary=True)
    
    try:
    #### automatic calculate net income 
        sql_all_sales_arrived="""SELECT
        id,
        product_no,
        customer_type,
        customer_no,
        money,
        people_type,
        people_no,
        CASE WHEN income_rate_real <> 0 THEN income_rate_real ELSE income_rate END income_rate,
        CASE WHEN agent_rate_real <> 0 THEN agent_rate_real ELSE agent_rate END agent_rate
        FROM
        sales
        WHERE
        `status` = 3
        AND income_money = 0
        AND (income_rate > 0 OR income_rate_real > 0)
        AND (agent_rate > 0 OR agent_rate_real > 0)"""
        cursor_sales.execute(sql_all_sales_arrived)
        all_sales_arrived = cursor_sales.fetchall()
        
        for sales_arrived in all_sales_arrived:
            print(sales_arrived)
            
            ####update sales' income
            income = sales_arrived["money"] * (sales_arrived["income_rate"] - sales_arrived["agent_rate"]) *100
            sql_update_sales_income="UPDATE sales s SET s.`income_money`= %s, \
                                    edit_user_no = 0,edit_time=current_timestamp(),edit_comment =edit_comment+'  update income to %s'\
                                    WHERE s.id = %s;"
            
            cursor_sales.execute(sql_update_sales_income,(income,income,sales_arrived['id']))
            
            __write_info("update sales:%s income to %s"%(sales_arrived['id'],income))
            
            ####insert income
            income = sales_arrived["money"] * sales_arrived["income_rate"] *100
            sql_insert_income ="""insert into income
            (name,customer_type, customer_no,sales_no,income_first,partner_no,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
            values (%s, %s, %s, %s, %s, %s, %s, current_timestamp(), %s,current_timestamp(),%s);"""

            sql_product_partner_no="SELECT issuer_no FROM product WHERE id=%s"%sales_arrived["product_no"]
            cursor_product.execute(sql_product_partner_no)
            partner_no = cursor_product.fetchone()
            cursor_sales.execute(sql_insert_income,("",sales_arrived["customer_type"],sales_arrived["customer_no"],sales_arrived["id"],income,partner_no["issuer_no"],0,0,"new"))
            __write_info("insert income: sales:%s income:%s"%(sales_arrived['id'],income))         
            
            ####insert expend
            expend = sales_arrived["money"] * sales_arrived["agent_rate"] *100
            sql_insert_expend ="""insert into agent_expense
            (name,customer_type, customer_no,sales_no,pay_first,agent_type,agent_no,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
            values (%s, %s, %s, %s, %s, %s, %s, %s, current_timestamp(), %s,current_timestamp(),%s);"""

            cursor_sales.execute(sql_insert_expend,("",sales_arrived["customer_type"],sales_arrived["customer_no"],sales_arrived["id"],expend,sales_arrived["people_type"],sales_arrived["people_no"],0,0,"new"))
            __write_info("insert expend: sales:%s expend:%s"%(sales_arrived['id'],expend))     
    
    except mysql.connector.Error as e:
        __write_err('update income error!{}'.format(e))
    finally:
        cursor_product.close()
        cursor_sales.close()
        cnn_product.close()
        cnn_sales.close()

if __name__ =="__main__":  
    __main()  