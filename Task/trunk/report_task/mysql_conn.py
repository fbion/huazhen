#encoding: utf-8
#!/usr/bin/python

import mysql.connector
import my_logger
import mail_sender

def get_conn(config):
    conn=None
    try:
        conn=mysql.connector.connect(**config)
    except mysql.connector.Error as e:
        my_logger.write_err('connect fails!{}'.format(e),"mysql_conn","get_conn")
        mail_sender.send_alerting('''module:%s function:%s
                                  content:%s'''
                                  %('mysql_conn',"get_conn",'connect fails!{}'.format(e)))
        conn=None
    return conn

