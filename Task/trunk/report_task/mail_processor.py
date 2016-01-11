#encoding: utf-8
#!/usr/bin/python

import mysql
import mail_sender
import my_logger
import db_config
import mysql_conn
import sys,os  
import urllib
import time

def __write_info(content,func):
    my_logger.write_info(content,"mail_processor",func)

def __write_err(content,func):
    my_logger.write_err(content,"mail_processor",func)
    
def __write_warn(content,func):
    my_logger.write_warn(content,"mail_processor",func)

def __process_mails():
    try:
        cnn_base_info=mysql_conn.get_conn(db_config.config_base_info)
        if cnn_base_info == None:
            __write_warn("can't get connection of notify","__process_mails")
            return
        cursor_base_info=cnn_base_info.cursor(dictionary=True)
        sql_top_10_mail="""SELECT
            `email`.`id`,
            `email`.`to`,
            `email`.`cc`,
            `email`.`subject`,
            `email`.`host`,
            `email`.`user`,
            `email`.`password`,
            `email`.`suffix`,
            `email`.`sender_name`,
            `email`.`body`,
            `email`.`from_name`
            FROM
            `email`
            WHERE
            `email`.`status` = 0
            ORDER BY id ASC
            LIMIT 5;"""
        cursor_base_info.execute(sql_top_10_mail)    
        dict_mail_list = cursor_base_info.fetchall()
        for mail in dict_mail_list:
            print mail["id"]
            sql_select_email_files = '''
                select email_no,file_url,file_name from email_files where email_no = %s
            '''%mail["id"]
            cursor_base_info.execute(sql_select_email_files)    
            email_files = cursor_base_info.fetchall()
            namelist = []
            for email_file in email_files:
                url = "http://192.168.1.236/upload/files"+str(email_file["file_url"])
                name = download(sys.argv[1:],url)
                namelist.append(name)
            if mail_sender.send_mail([str(mail["to"])],str(mail["subject"]),str(mail["body"]),namelist,str(mail["sender_name"]),str(mail["host"]),str(mail["user"]),str(mail["password"]),str(mail["suffix"]),str(mail["from_name"])):  
                sql_update_mail_status ="""
                    UPDATE `email` SET `status`=1 WHERE id = %s
                    """%mail["id"]
                cursor_base_info.execute(sql_update_mail_status)
                __write_info("send success","__process_mails")         
            else:  
                __write_info("send failed","__process_mails")
    except mysql.connector.Error as e:
        __write_err('raise exception when sending mail!{}'.format(e))
    finally:
        cursor_base_info.close()
        cnn_base_info.close()
def download(argv,url):
    type = sys.getfilesystemencoding()
    namelist = url.split("_")
    name = str(time.time())+"_"+namelist[1].decode('utf-8').encode(type)
    urllib.urlretrieve(url,"/home/shell/file/ " + name)
    return name  
if __name__ == '__main__':  
    __process_mails()

