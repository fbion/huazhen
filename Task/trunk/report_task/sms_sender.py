#encoding: utf-8
#!/usr/bin/python

import my_logger
import urllib2
import urllib
import sys
import time
import mysql_conn
import db_config

default_encoding = 'utf-8'
if sys.getdefaultencoding() != default_encoding:
    reload(sys)
    sys.setdefaultencoding(default_encoding)
    
#######Define private variable start###################
__user_code='huazhen'
__password='oeotc3'
__mobile_info='13716498307'
__addi=''
__content='【一心公益】您的登录密码是 0604'
#######Define private variable end#####################

#######Define private method start#####################
def __write_info(content,func='send_sms'):
    my_logger.write_info(content,"sms_sender",func)

def __write_err(content,func='send_sms'):
    my_logger.write_err(content,"sms_sender",func)
    
def __write_warn(content,func='send_sms'):
    my_logger.write_warn(content,"sms_sender",func)
#######Define private method end#######################

def send_sms(mobile_info,content,user_code = __user_code,password = __password,addi = __addi):
    #
    timestamp = "%s%s"%(time.strftime('%Y%m%d%H%M%S',time.localtime(time.time())),'0001')
    data = {}
    data['action']='1003'
    data['usercode']= "huazhen"
    data['password']=__md5("%s%s%s"%(user_code,password,timestamp))
    data['mobileInfo']=mobile_info
    print mobile_info
    data['addi']=addi
    data['timestamp']=timestamp
    #print urllib.quote(str(content))
    #content ="【华镇金控】您的验证码是123456，本验证码有效期为10分钟，过期无效"
    #print urllib.quote(content)
    
    try:
        data['content']=urllib.quote(str(content))
    except Exception, e:
        print e
    url='http://%s:16012/smshttp'%(__get_ip("smsicloud.com"),)
    #print url
    #print data
    try:
        #print url
        __do_get(url,data)
        return True
    except Exception, e:
        print (e)
        return False

def __do_post(url,data): 
    #post_data = 'action=%s&usercode=%s&password=%s&mobileInfo=%s&addi=%s&timestamp=%s&content=%s'%(data['action'],data['usercode'],data['password'],data['mobileInfo'],data['addi'],data['timestamp'],data['content'])
    #params = {'action':data["action"],'usercode':data["usercode"],'password':data["password"],'mobileInfo':data["mobileInfo"],'addi':data["addi"],'timestamp':data["timestamp"],'content':data["content"]}
    #print params
    post_data = urllib.urlencode(data)
    #print type(post_data)
    print post_data
    #req = urllib2.Request(url)
    resp = urllib2.urlopen(url, post_data)
    result = resp.read()
    print result
    
def __do_get(url, data):
    url = url + '?action=%s&usercode=%s&password=%s&mobileInfo=%s&addi=%s&timestamp=%s&content=%s'%(data['action'],data['usercode'],data['password'],data['mobileInfo'],data['addi'],data['timestamp'],data['content'])
    print url
    req = urllib2.Request(url)
    resp = urllib2.urlopen(req)
    result = resp.read()
    print result
    
def __md5(str):
    import hashlib
    import types
    if type(str) is types.StringType:
        m = hashlib.md5()   
        m.update(str)
        return m.hexdigest()
    else:
        return ''

def __get_ip(domain):
    import socket
    myaddr = socket.getaddrinfo(domain,'http')[0][4][0]
    return myaddr
    
def __main():
    try:
        cnn_base_info=mysql_conn.get_conn(db_config.config_base_info)
        if cnn_base_info == None:
            __write_warn("can't get connection of notify","__process_mails")
            return
        cursor_base_info=cnn_base_info.cursor(dictionary=True)
        sql_select_sms = '''
            select sysno,cellnumber,smscontent,retrycount from sms where status = 1;
        '''
        cursor_base_info.execute(sql_select_sms)
        smsList = cursor_base_info.fetchall()
        for sms in smsList:
            sql_update_statu = '''
                update sms set status = 2 where sysno = %s
            '''%sms["sysno"]
            cursor_base_info.execute(sql_update_statu)
            if(send_sms(sms["cellnumber"],sms["smscontent"])):
                sql_update_status = '''
                    update sms set status = 3 where sysno = %s
                '''%sms["sysno"]
                cursor_base_info.execute(sql_update_status)
            else:
                cursor_base_info.execute(sql_update_retrycount,(sms["retrycount"]+1,sms["sysno"]))
    except Exception, e:
        print (e)
        return False
    finally:
        cnn_base_info.close()
        cursor_base_info.close()

if __name__ == '__main__':  
    __main()

    