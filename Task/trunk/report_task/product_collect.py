#encoding:utf-8
#!/usr/bin/python

import mysql
import mail_sender
import my_logger
import db_config
import mysql_conn

def __write_info(content,func):
	my_logger.write_info(content,"product_collect",func)
def __write_err(content,func):
	my_logger.write_err(content,"product_collect",func)
def __write_warn(content,func):
	my_logger.write_warn(content,"product_collect",func)

def __dept(deptNo):
	try:
		cnn_report = mysql_conn.get_conn(db_config.config_report)
		if cnn_report == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_report = cnn_report.cursor(dictionary=True)
		sql_one = ''' SELECT
			product_name,
			SUM(money_total) as money,
			dept_name
			FROM dept_sales_daily
			WHERE TO_DAYS( NOW( ) ) - TO_DAYS( clac_time) = 1 %s
			GROUP BY dept_name,product_name;
			'''%deptNo
		print sql_one
		cursor_report.execute(sql_one)
		mails = cursor_report.fetchall()
		if len(mails)==0:
			content = "null"
		else:
			content = ""
			for mail in mails:
				content = content + "<tbody><tr><td>" + str(mail["dept_name"])+"</td><td>"+str(mail["product_name"])+"</td><td>"+str(mail["money"])+"万元</td></tr>"
	except Exception,e:
		print(e);
		return False
	finally:
		cursor_report.close()
		cnn_report.close()
	return content
def __emp(deptNo):
	try:
		cnn_report = mysql_conn.get_conn(db_config.config_report)
		if cnn_report == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_report = cnn_report.cursor(dictionary=True)
		sql_emp = '''SELECT 
		product_name,emp_name,SUM(money_total) as money
		from emp_sales_daily
		where emp_no in(
		select user_no 
		from employee.employee 
		where TO_DAYS( NOW( ) ) - TO_DAYS( clac_time) = 1 %s
		)GROUP BY product_name,emp_name; 
		'''%deptNo
		print(sql_emp)
		cursor_report.execute(sql_emp)
		mails = cursor_report.fetchall()
		if len(mails)==0:
			content = "null"
		else:
			content = ""
			for mail in mails:
				content = content +  "<tbody><tr><td>" + str(mail["product_name"])+"</td><td>"+str(mail["emp_name"])+"</td><td>"+str(mail["money"])+"万元</td></tr>"
	except Exception,e:
		print(e)
		return False
	finally:
		cursor_report.close()
		cnn_report.close()
	return content
def __emp_mails():
	try:
		before = "<br /><table border=1 cellpadding=0 cellspacing=0 width=500px><thead bgcolor='#aaaaaa'><tr><th>产品</th><th>人员</th><th>昨日打款金额</th></tr></thead>"
		after =  "</table> <br /><hr />IT部<br /> 华镇金控集团"
		content =  __emp("and dept_no = 10");
		if content == "null":
			return
		content = before +content + after
		to= ["hexin997@163.com"]
		sub= "渠道总监"
		mail_sender.send_mail(to,sub,content)


	except Exception,e:
		print(e)
		return False
def __dept_mails():
	try:
		before = "<br /><table border=1 cellpadding=0 cellspacing=0 width=500px><thead bgcolor='#aaaaaa'><tr><th>部门</th><th>产品</th><th>昨日打款金额</th></tr></thead>"
		after =  "</table> <br /><hr />IT部<br /> 华镇金控集团"
		content = __dept("and dept_no>11")
		if content == "null":
			return
		content = before +content + after
		to = ["hexin997@163.com"]
		sub = "副总"
		mail_sender.send_mail(to,sub,content)

	except Exception,e:
		print(e)
		return False
if __name__ == '__main__':
	__emp_mails()
	__dept_mails()
