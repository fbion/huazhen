#encoding: utf-8
#!/usr/bin/python


import smtplib  
from email.mime.text import MIMEText
from email.header import Header
from email import Encoders
import my_logger
import sys
from email.mime.application import MIMEApplication  
from email.MIMEMultipart import MIMEMultipart  
import urllib
import base64 


default_encoding = 'utf-8'
if sys.getdefaultencoding() != default_encoding:
    reload(sys)
    sys.setdefaultencoding(default_encoding)

#######Define private method start#####################
def __write_info(content,func='send_mail'):
    my_logger.write_info(content,"mail_sender",func)

def __write_err(content,func='send_mail'):
    my_logger.write_err(content,"mail_sender",func)
    
def __write_warn(content,func='send_mail'):
    my_logger.write_warn(content,"mail_sender",func)
#######Define private method end#######################

__mail_host="mail.bestinvestor.com.cn"
__mail_user="administrator"
__mail_pass="huazhen@123"
__mail_postfix="bestinvestor.com.cn"
__mail_sender_name="系统管理员"

  
def send_mail(to_list,sub,content,appendixList=[],sender_name=__mail_sender_name,host=__mail_host,user=__mail_user,pwd=__mail_pass,postfix=__mail_postfix,from_user=__mail_user):
    msg = MIMEMultipart() 
    body = MIMEText(content,_subtype='html',_charset='utf-8')    #new a instance，html mail
    msg.attach(body)
    msg["Accept-Language"]="zh-CN"
    msg["Accept-Charset"]="ISO-8859-1,utf-8"
    if not isinstance(sub,unicode):
        sub=unicode(sub)
    #sender_name = '=?utf-8?b?' + base64.b64encode(sender_name.encode('UTF-8')) + '?='
    print from_user
    if str(from_user) == "None":
        print "a"
        me = ("%s<"+ user +"@"+ postfix) % (Header(sender_name,'utf-8'),)
    else:
        print "b"
        me = from_user+"@"+postfix

    print me 
    msg['Subject'] = sub    #subject
    msg['From'] = me
    msg['To'] = ";".join(to_list) 
    for filelist in appendixList:
        print filelist
        part = MIMEApplication('application', 'octet-stream') 
        part.set_payload(open("/home/shell/file/" + filelist,'rb').read()) 
        Encoders.encode_base64(part)
        namelist = filelist.split("_")
        name=str(namelist[1])
        part.add_header('Content-Disposition', 'attachment', filename= '=?utf-8?b?' + base64.b64encode(name.encode('UTF-8')) + '?=') 
        msg.attach(part)
    try:  
        s = smtplib.SMTP()  
        s.connect(host)  #connect smtp server
        s.login(user,pwd)  #login server
        s.sendmail(me, to_list, msg.as_string())  #send mail
        __write_info('send mail <%s> to %s'%(sub,','.join(to_list)))
        s.close()  
        return True  
    except Exception, e:  
        __write_err(str(e))  
        return False
def send_alerting(content):
    send_mail(["guozy@bestinvestor.com.cn"],"exception",content)