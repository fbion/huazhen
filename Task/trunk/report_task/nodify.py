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
    my_logger.write_info(content,"notify",func)

def __write_err(content,func='main'):
    my_logger.write_err(content,"notify",func)
    mail_sender.send_alerting('''module:%s function:%s
                              content:%s'''
                              %('notify',func,content))
    
def __write_warn(content,func='main'):
    my_logger.write_warn(content,"notify",func)
        
#######Define private method end#######################
def __main():
    """need run after product_status_changer.py"""
    
    cnn_product=mysql_conn.get_conn(db_config.config_product)
    if not cnn_product:
        __write_warn("can't get connection of product")
        return
    cursor_product=cnn_product.cursor(dictionary=True)
    
    try:
        sql_approaching_end_product = """
        SELECT
        `name`,
        `end`
        FROM
        product
        WHERE
        `end` > ADDDATE(NOW(), 9)
        AND `end` < ADDDATE(NOW(), 10);"""
        
        cursor_product.execute(sql_approaching_end_product)
        products_approaching_end = cursor_product.fetchall()
        
        subject="产品到期提醒"
        to_list=["guozy@bestinvestor.com.cn","wangqk@bestinvestor.com.cn"]
        content="产品%s即将于 %s 到期"
        
        for product_approaching_end in products_approaching_end:
            mail_sender.send_mail(to_list,subject,content%(product_approaching_end["name"],product_approaching_end["end"]))
        
        
    except mysql.connector.Error as e:
        __write_err('send reminder mail error!{}'.format(e))        
    finally:
        cursor_product.close()
        #cursor_notify.close()
        cnn_product.close()
        #cnn_notify.close()

if __name__ =="__main__":  
    __main()  
    
    
