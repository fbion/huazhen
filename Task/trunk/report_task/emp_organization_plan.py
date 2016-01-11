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
		
		sql_select_dept_year_need = '''
			select n.id,n.company_no,n.dept_no,t.in_time,t.activiti_no from year_need_total t LEFT OUTER JOIN year_need n
			on t.id = n.year_need_total_no
			where PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( t.in_time, '%Y%m' ) ) = 0
		'''
		cursor_employee.execute(sql_select_dept_year_need);
		depts = cursor_employee.fetchall();
		year = time.strftime('%Y')
		month = time.strftime('%m') 
		for dept in depts:
			dept_no = dept["dept_no"]
			company_no = dept["company_no"]
			plan_time = dept["in_time"]
			
			result = __getResultByActivitiNo(dept['activiti_no'])
			print result
			if(result==0):
				 continue
			sql_select_dept_year_need_detail = '''
				select position_no,add_emp from year_need_detail where year_need_no = %s
			'''%dept["id"]
			cursor_employee.execute(sql_select_dept_year_need_detail);
			need_emp_nos = cursor_employee.fetchall();
			for need_emp_no in need_emp_nos:
				position_no = need_emp_no["position_no"]
				all_emp_name = __getEmpNameByDeptAndPosition(dept_no,position_no)
				numbers = __getEmpNumberByDeptAndPosition(dept_no,position_no)
				for number in numbers :
					real_emp_number = number["count"]
				due_emp_number = real_emp_number + need_emp_no["add_emp"]
				lack_emp_number = need_emp_no["add_emp"]
				sql_insert_emp_compile_plan = '''
					insert into emp_compile_plan(company_no,dept_no,position_no,due_emp_number,
					real_emp_number,all_emp_name,lack_emp_number,plan_time,year,month) 
					values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
				'''
				cursor_employee.execute(sql_insert_emp_compile_plan,(company_no,dept_no,position_no,due_emp_number,\
										real_emp_number,all_emp_name,lack_emp_number,plan_time,year,month));

		sql_select_temp_recruit_need = '''
			select id,company_no,activiti_no from temp_recruit_need
			where PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(in_time, '%Y%m' ) ) = 0
		'''
		cursor_employee.execute(sql_select_temp_recruit_need);
		companys = cursor_employee.fetchall();
		for company in companys:
			company_no = company["company_no"];
			result = __getResultByActivitiNo(company['activiti_no'])
			if(result==0):
				continue 
			sql_select_temp_recruit_detail = '''
				select dept_no,position_no,add_people,work_date,in_time from temp_recruit_detail where temp_recruit_need_no = %s
				'''%company["id"]
			cursor_employee.execute(sql_select_temp_recruit_detail);
			needs = cursor_employee.fetchall();
			for need in needs:
				dept_no = need["dept_no"]
				position_no = need["position_no"]
				all_emp_name = __getEmpNameByDeptAndPosition(dept_no,position_no)
				empNumbers = __getEmpNumberByDeptAndPosition(dept_no,position_no)
				for empNumber in empNumbers:
					real_emp_number = empNumber["count"]
				due_emp_number = real_emp_number + need["add_people"]
				lack_emp_number = need["add_people"]
				
				sql_insert_emp_compile_plan = '''
					insert into emp_compile_plan(company_no,dept_no,position_no,due_emp_number,
					real_emp_number,all_emp_name,lack_emp_number,plan_time,year,month) 
					values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
				'''
				cursor_employee.execute(sql_insert_emp_compile_plan,(company_no,dept_no,position_no,due_emp_number,\
										real_emp_number,all_emp_name,lack_emp_number,need["work_date"],year,month));
		sql_delete_emp_compile_plan = '''
			delete from emp_compile_plan where lack_emp_number = 0;
		'''
		cursor_employee.execute(sql_delete_emp_compile_plan);

	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __getEmpNameByDeptAndPosition(dept_no,position_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_employee = '''
			select name from employee where dept_no = %s and position_no = %s
		'''
		cursor_employee.execute(sql_select_employee,(dept_no,position_no));
		emps = cursor_employee.fetchall();
		all_emp_name = ""
		for emp in emps:
			all_emp_name = all_emp_name + emp["name"] + ";"
		return all_emp_name
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __getEmpNumberByDeptAndPosition(dept_no,position_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_employee = '''
			select count(*) count  from employee where dept_no = %s and position_no = %s
		'''
		cursor_employee.execute(sql_select_employee,(dept_no,position_no));
		empNumbers = cursor_employee.fetchall();
		return empNumbers
	except Exception, e:
		print(e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
		
def __getResultByActivitiNo(activiti_no):
	try:
		cnn_work_flow = mysql_conn.get_conn(db_config.config_work_flow)
		if cnn_work_flow == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_work_flow = cnn_work_flow.cursor(dictionary=True)

		sql_select_result = '''
			SELECT count(*) count FROM `ACT_HI_PROCINST` WHERE END_ACT_ID_ IS NOT NULL AND PROC_INST_ID_= %s ;
		'''%activiti_no
		cursor_work_flow.execute(sql_select_result);
		results = cursor_work_flow.fetchall()
		for result in results:
			res = result['count']
		return res
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_work_flow.close()
		cnn_work_flow.close()
	
if __name__ == '__main__':
	__main()
		
