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
		cursor_employee = cnn_employee.cursor(dictionary=True)

		sql_select_subsidy_total = '''
			select id,emp_no,emp_name,dept_no,position_no,
			subsidy_scale,sales_money,subsidy,achieve_time,is_examine
			from subsidy_total
		'''	
		cursor_employee.execute(sql_select_subsidy_total)
		subsidy_totals = cursor_employee.fetchall();

		for subsidy_total in subsidy_totals:
			if subsidy_total['is_examine'] != 2:#状态为审核的插入到subsidy
				continue
			else:
				money = subsidy_total['subsidy'] / 6.0
				for i in range(1,7):
					sql_send_time = '''select DATE_ADD(%s,INTERVAL %s MONTH) send_time'''
					cursor_employee.execute(sql_send_time,(subsidy_total['achieve_time'],i))
					send_times = cursor_employee.fetchall();
					for send_time in send_times:
						timeArray = time.strptime(send_time['send_time'], "%Y-%m-%d")
						
					send_time = datetime.datetime.strptime(time.strftime("%Y-%m", timeArray), "%Y-%m").date() 
					sql_insert_subsidy = '''
						insert into subsidy(emp_no,emp_name,dept_no,
						position_no,money,source,send_time,in_time)
						values(%s,%s,%s,%s,round(%s,2),%s,%s,now())'''
					cursor_employee.execute(sql_insert_subsidy,(subsidy_total['emp_no'],subsidy_total['emp_name'],\
											subsidy_total['dept_no'],14,money,subsidy_total['id'],send_time))

					__updateIsExamineById(subsidy_total['id']);#插入成功后状态更改为3(完成)
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __updateIsExamineById(id):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)

		sql_update_examine = '''
			update subsidy_total set is_examine = 3 where id = %s
		'''%id
		cursor_employee.execute(sql_update_examine)	

	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
if __name__ == '__main__':
	__main()