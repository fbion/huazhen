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
		cnn_report = mysql_conn.get_conn(db_config.config_report)
		if cnn_report == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_report = cnn_report.cursor(dictionary=True)
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)

		sql_select_employee = '''
			select id,name,user_no,dept_no,company_no,status
			from employee where dept_no in (10,11,5,13,14,15,16,17,18,19)
		'''
		cursor_employee.execute(sql_select_employee);
		employees = cursor_employee.fetchall();
		for employee in employees:
			dept_no = employee['dept_no']
			company_no = employee['company_no']
			emp_name = employee['name']
			emp_status = employee['status']
			year = time.strftime('%Y')
			month = time.strftime('%m') 
			day = int(time.strftime('%d'))-1
			add_a = __getAddCountByLevelAndAgentNo(4,employee['user_no'])
			add_b = __getAddCountByLevelAndAgentNo(3,employee['user_no'])
			add_c = __getAddCountByLevelAndAgentNo(2,employee['user_no'])
			add_d = __getAddCountByLevelAndAgentNo(1,employee['user_no'])
			customer_count = __getCustomerCountByAgentNo(employee['user_no'])
			add_employee_count = add_a + add_b + add_c + add_d
			report_type = 3
			sql_insert_add_employee_report = '''
			insert into add_customer_report(emp_no,dept_no,company_no,add_a,
			add_b,add_c,add_d,add_employee_count,employee_count,type,emp_name,emp_status,year,month,day)
			values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
			'''
			cursor_report.execute(sql_insert_add_employee_report,(employee['user_no'],dept_no,company_no,\
				add_a,add_b,add_c,add_d,add_employee_count,customer_count,report_type,emp_name,emp_status,year,month,day));

	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
		cursor_report.close()
		cnn_report.close()

def __getAddCountByLevelAndAgentNo(level,agent_no):
	try:
		cnn_customer = mysql_conn.get_conn(db_config.config_customer)
		if cnn_customer == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_customer = cnn_customer.cursor(dictionary=True)
		sql_select_add_count = '''
			select count(*) count from customer_personal where relation_level = %s and agent_no = %s and
			TO_DAYS( NOW( ) ) - TO_DAYS( in_time) <= 1
		'''
		cursor_customer.execute(sql_select_add_count,(level,agent_no));
		add_counts = cursor_customer.fetchall();
		for add_count in add_counts:
			count = add_count['count']
		return count
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_customer.close()
		cnn_customer.close()
def __getCustomerCountByAgentNo(agent_no):
	try:
		cnn_customer = mysql_conn.get_conn(db_config.config_customer)
		if cnn_customer == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_customer = cnn_customer.cursor(dictionary=True)
		sql_select_customer_count = '''
			select agent_no,count(*) count from  customer_personal 
			where agent_no = %s
		'''%agent_no
		cursor_customer.execute(sql_select_customer_count)
		counts = cursor_customer.fetchall()
		for count in counts:
			customer_count = count['count']
		print customer_count
		return customer_count
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_customer.close()
		cnn_customer.close()
if __name__ == '__main__':
	#__getAddCountByLevelAndAgentNo(1,88)
	__main()