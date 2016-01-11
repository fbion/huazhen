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
		sql_select_emp = '''
			select e.id,e.code,e.name,e.address,e.dept_no,e.position_no,e.sex,e.marry,e.status,d.official_time,
			d.contract_start_time,d.contract_end_time,d.birthday,d.IDCard,d.permanent_place,d.birth_place,
			d.political_status,d.end_time,d.start_time,d.nation,d.children_situation,d.protocol_start_time,
			d.protocol_end_time
			from employee e left outer join employee_detail d on e.id = d.emp_no
		'''
		cursor_employee.execute(sql_select_emp);
		emps = cursor_employee.fetchall();

		sql_delete_emp_info = '''
			delete from employee_information
		'''
		cursor_employee.execute(sql_delete_emp_info);
		for emp in emps:
			sql_insert_emp_info = '''
				insert into employee_information(id,name,dept_no,emp_no,dept_name,position_no,sex,nation,marry, 
				children_sitiatio,protocol_start_time,protocol_end_time,offical_time,contract_start_time,
				contract_end_time,birthday,birthday_year,id_card,home_address,permanent_place,birth_place,
				political_status,start_time,end_time,status,certificate1,certificate2,degree1,graduation_school1,
				major1,degree2,graduation_school2,major2,certificate_date1,certificate_date2)
				values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,
						%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
			'''
			
			dept_name = __getDeptNameByDeptNo(emp["dept_no"])
			a = str(emp["birthday"])
			if a == "None" :
				birthday_year = ""
			else:
				timeArray = time.strptime(a, "%Y-%m-%d")
				birthday_year = time.strftime("%Y", timeArray)

			#证书
			certificates = __getCertificateByEmpNo(emp["id"])
			certificate1 = ""
			certificate_date1 = ""
			certificate2 = ""
			certificate_date2 = ""
			i = 0
			for i, certificate in enumerate(certificates): 
				if i == 0:
					certificate1 = certificate["credential"]
					certificate_date1 = certificate["credential_date"]
				if i == 1:
					certificate2 = certificate["credential"]
					certificate_date2 = certificate["credential_date"]

			#学历
			degrees = __getDegreeByEmpNo(emp["id"])
			degree1 = ""
			degree2 = ""
			graduation_school1 = ""
			graduation_school2 = ""
			major1 = ""
			major2 = ""
			i = 0
			for i, degree in enumerate(degrees): 
				if i == 0:
					degree1 = degree["education"]
					graduation_school1 = degree["graduation_school"]
					major1 = degree["major"]
    			if i == 1:
    				degree2 = degree["education"]
    				graduation_school2 = degree["graduation_school"]
    				major1 = degree["major"]

			cursor_employee.execute(sql_insert_emp_info,(emp["id"],emp["name"],emp["dept_no"],emp["id"],dept_name,\
									emp["position_no"],emp["sex"],emp["nation"],emp["marry"],emp["children_situation"],\
									emp["protocol_start_time"],emp["protocol_end_time"],emp["official_time"],\
									emp["contract_start_time"],emp["contract_end_time"],emp["birthday"],birthday_year,
									emp["IDCard"],emp["address"],emp["permanent_place"],emp["birth_place"],\
									emp["political_status"],emp["start_time"],emp["end_time"],emp["status"],\
									certificate1,certificate2,degree1,graduation_school1,major1,degree2,graduation_school2,major2,\
									certificate_date1,certificate_date2));

		sql_update_date1 = '''
			update employee_information set  certificate_date1 = NULL where certificate_date1 = '0000-00-00'
		'''
		cursor_employee.execute(sql_update_date1)
		sql_update_date2 = '''
			update employee_information set  certificate_date2 = NULL where certificate_date2 = '0000-00-00'
		'''
		cursor_employee.execute(sql_update_date2)
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __getDeptNameByDeptNo(dept_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_dept_name  = '''
			select name from department where id = %s
		'''%dept_no

		cursor_employee.execute(sql_select_dept_name);
		dept_names = cursor_employee.fetchall();
		for dept_name in dept_names:
			name = dept_name["name"]
		return name
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __getDegreeByEmpNo(emp_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_degree = '''
			select education,graduation_school,major from employee_education where emp_no = %s
		'''%emp_no
		cursor_employee.execute(sql_select_degree);
		degrees = cursor_employee.fetchall();
		return degrees
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
def __getCertificateByEmpNo(emp_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_certificate = '''
			select credential,credential_date from employee_credential where emp_no = %s
		'''%emp_no
		cursor_employee.execute(sql_select_certificate)
		certificates= cursor_employee.fetchall()
		return certificates
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
if __name__ == '__main__':
	__main()

