#encoding:utf-8
#!/usr/bin/python

import mysql
import my_logger
import db_config
import mysql_conn
import time
import datetime

def __main():
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return

		cnn_base_info=mysql_conn.get_conn(db_config.config_base_info)	
		if not cnn_base_info:
			__write_warn("can't get connection of base_info")
			return

		cursor_employee = cnn_employee.cursor(dictionary=True)
		cursor_base_info=cnn_base_info.cursor(dictionary=True)

		sql_select_emp = '''
			SELECT e.id,e.name,e.status,d.start_time
			FROM employee e LEFT OUTER JOIN employee_detail d 
			ON e.id = d.emp_no WHERE e.`status` = 5 and
			TO_DAYS(NOW()) - TO_DAYS(d.start_time) >= 60  and
			TO_DAYS(NOW()) - TO_DAYS(d.start_time) <= 90
		'''
		cursor_employee.execute(sql_select_emp);
		emps = cursor_employee.fetchall();
		print emps
		for emp in emps:
			a = str(emp["start_time"]) #获得时间
			timeArray = time.strptime(a, "%Y-%m-%d")
			year = time.strftime("%Y", timeArray)
			month = time.strftime("%m",timeArray)
			day = time.strftime("%d",timeArray)
			
			to = "hexin997@163.com"
			subject = "员工试用到期提醒"
			endmonth = int(month)+3
			starttime = str(year)+"年"+str(month)+"月"+str(day)+"日"
			endtime = str(year)+"年"+str(endmonth)+"月"+str(day)+"日"

			content = str(emp["name"])+starttime+"开始试用，试用期三个月，"+endtime+"试用结束,请及时沟通，确认是否到期转正"
			print content
			sql_insert_email = '''
				insert into email
				(`to`,subject,host,`user`,password,suffix,sender_name,body,status,in_user_no)
				values(%s,%s,'mail.bestinvestor.com.cn','administrator','huazhen@123',
				'bestinvestor.com.cn','系统管理员',%s,0,176)
				'''
			cursor_base_info.execute(sql_insert_email,(to,subject,content))

	except Exception, e:
		print (e)
		return False
	finally:
		cursor_base_info.close()
		cursor_employee.close()
		cnn_base_info.close()
		cnn_employee.close()
if __name__ == '__main__':
	__main()
		