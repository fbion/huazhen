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
    my_logger.write_info(content,"product_status_changer",func)

def __write_err(content,func='main'):
    my_logger.write_err(content,"product_status_changer",func)
    mail_sender.send_alerting('''module:%s function:%s
                              content:%s'''
                              %('product_status_changer',func,content))
    
def __write_warn(content,func='main'):
    my_logger.write_warn(content,"product_status_changer",func)
        
#######Define private method end#######################
def __main():
    """need run after report_generator.py"""
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
    #### automatic change product status from on_sales(30) to duration(40)
        sql_product_sales_to_duration="""SELECT
            p.id
            FROM
            product p
            WHERE
            p.`start` <= now()
            AND p.`status` = 30;"""
        cursor_product.execute(sql_product_sales_to_duration)
        sales_to_duration_products = cursor_product.fetchall()
        
        for sales_to_duration_product in sales_to_duration_products:
            sql_product_update_to_duration="UPDATE product p SET p.`status`= 40, \
                                           edit_user_no = 0,edit_time=current_timestamp(),edit_comment =edit_comment+'  update status from 30 to 40'\
                                           WHERE p.id = %s;"
            
            cursor_product.execute(sql_product_update_to_duration,(sales_to_duration_product['id'],))
            
            __write_info("update product:%s status to 40"%(sales_to_duration_product['id'],))
                
            sql_sales_update_to_success ="UPDATE sales s SET s.`status` = 3,\
                                         edit_user_no = 0,edit_time=current_timestamp(),edit_comment =edit_comment+'  update status from 2 to 3' \
                                         WHERE s.`status` = 2 and s.product_no = %s;"
            
            cursor_sales.execute(sql_sales_update_to_success,(sales_to_duration_product['id'],))
            __write_info("update product:%s sale status to 3"%(sales_to_duration_product['id'],))
            
            
        #### automatic change product status from duration(40) to finish(50)
        sql_product_sales_to_finish="""SELECT
            p.id
            FROM
            product p
            WHERE
            p.`end` <= now()
            AND p.`status` = 40;"""
        cursor_product.execute(sql_product_sales_to_finish)
        sales_to_finish_products = cursor_product.fetchall()
        
        sql_product_update_to_finish="UPDATE product p SET p.`status`= 50, \
                                     edit_user_no = 0,edit_time=current_timestamp(),edit_comment =edit_comment+'  update status from 40 to 50' \
                                     WHERE p.`end` <= now() AND p.`status` = 40;"
        cursor_product.execute(sql_product_update_to_finish)
        
        __write_info("update product:%s status to 50"%(str(sales_to_finish_products)))
    
    except mysql.connector.Error as e:
        __write_err('update product status error!{}'.format(e))
    finally:
        cursor_product.close()
        cursor_sales.close()
        cnn_product.close()
        cnn_sales.close()

if __name__ =="__main__":  
    __main()  