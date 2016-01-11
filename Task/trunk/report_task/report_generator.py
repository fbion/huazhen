#encoding: utf-8
#!/usr/bin/python

import mysql
import my_logger
import db_config
import mysql_conn
import mail_sender

#######Define private method start#####################

__DATE_FORMAT = '%Y-%m-%d'

def __write_info(content,func='main'):
	my_logger.write_info(content,"report_generator",func)
	
def __write_err(content,func='main'):
	my_logger.write_err(content,"report_generator",func)
	mail_sender.send_alerting('''module:%s function:%s
		      content:%s'''
		      %('report_generator',func,content))
	
def __write_warn(content,func='main'):
	my_logger.write_warn(content,"report_generator",func)
	

#######Define private method end#######################
def main():

	cnn_employee=mysql_conn.get_conn(db_config.config_employee)
	#获取连接
	if not cnn_employee:
		#提示信息
		__write_warn("can't get connection of employee")
		return
		
	cnn_report=mysql_conn.get_conn(db_config.config_report)
	if not cnn_report:
		__write_warn("can't get connection of report")
		return	

	cnn_product=mysql_conn.get_conn(db_config.config_product)
	if not cnn_product:
		__write_warn("can't get connection of product")
		return
		
	cnn_base_info=mysql_conn.get_conn(db_config.config_base_info)	
	if not cnn_base_info:
		__write_warn("can't get connection of base_info")
		return

	#
	cursor_employee=cnn_employee.cursor(dictionary=True)
	cursor_report=cnn_report.cursor(dictionary=True)
	cursor_product=cnn_product.cursor(dictionary=True)
	cursor_base_info=cnn_base_info.cursor(dictionary=True)
	
	#dict_employee_list=None
	
	####create employee department company start
	try:	
		#employee
		sql_employee = '''
		SELECT
		e.id,
		e.name,
		e.parent_no,
		e.user_no,
		e.dept_no,
		e.company_no,
		e.position_no,
		d.dept_type
		FROM
		employee  e LEFT JOIN  department d
		on e.dept_no = d.id

		'''
		#执行SQL 查询
		cursor_employee.execute(sql_employee)
		#返回数据存放在 dict——employee_list
		dict_employee_list = cursor_employee.fetchall()


		#执行SQL  删除
		sql_delete='delete from report_employee'
		cursor_report.execute(sql_delete)
		#提示信息
		__write_info('delete report_employee')
		
		#执行sql 插入
		sql_insert_employee="insert into report_employee (id, name,parent_no,user_no,dept_no,company_no,dept_type,position_no) \
		      values (%(id)s, %(name)s, %(parent_no)s, %(user_no)s, %(dept_no)s, %(company_no)s,%(dept_type)s,%(position_no)s)"
		cursor_report.executemany(sql_insert_employee,dict_employee_list)
		__write_info('insert %d employees'%len(dict_employee_list))
		
		#department
		sql_department = '''
		SELECT
		id,
		`name`,
		parent_no,
		emp_no,
		dept_type,
		company_no
		FROM
		department'''
		cursor_employee.execute(sql_department)
		dict_department_list = cursor_employee.fetchall()
		
		sql_delete='delete from report_department'
		cursor_report.execute(sql_delete)
		__write_info('delete report_department')
		
		sql_insert_department="insert into report_department (id, name,parent_no,emp_no,dept_type,company_no) \
			values (%(id)s, %(name)s, %(parent_no)s, %(emp_no)s, %(dept_type)s, %(company_no)s)"
		cursor_report.executemany(sql_insert_department,dict_department_list)
		__write_info('insert %d departments'%len(dict_department_list))
		
		#company
		sql_company = '''
		SELECT
		id,
		`name`
		FROM
		company'''
		cursor_employee.execute(sql_company)
		dict_company_list = cursor_employee.fetchall()
		
		sql_delete='delete from report_company'
		cursor_report.execute(sql_delete)
		__write_info('delete report_company')
		
		sql_insert_company="insert into report_company (id, name) values (%(id)s, %(name)s)"
		cursor_report.executemany(sql_insert_company,dict_company_list)
		__write_info('insert %d companies'%len(dict_company_list))
	except mysql.connector.Error as e:
		__write_err('create employee,department,company error!{}'.format(e))
	finally:
		cursor_employee.close()
		cnn_employee.close()
	####create employee department company end
	#online_products=None
	####update product start
	try:		
		sql_product = '''
		SELECT
		id,
		`name`,
		type,
		`status`
		FROM
		product'''
		cursor_product.execute(sql_product)
		dict_product_list = cursor_product.fetchall()
		
		online_products = ','.join([str(x["id"]) for x in dict_product_list if x["status"] == 30])
		
		sql_delete='delete from report_product'
		cursor_report.execute(sql_delete)
		__write_info('delete report_product')
		
		sql_insert_product="insert into report_product (id,type, name,status) values (%(id)s, %(type)s,%(name)s,%(status)s)"
		cursor_report.executemany(sql_insert_product,dict_product_list)
		__write_info('insert %d products'%len(dict_product_list))
	except mysql.connector.Error as e:
		__write_err('update product error!{}'.format(e))
	finally:
		cursor_product.close()
		cnn_product.close()
	####update product end
	
	####create dic start
	try:
		#product
		sql_base_info = '''
		SELECT
		id,
		code,
		dic_type_no,
		value
		FROM
		dic_data'''
		cursor_base_info.execute(sql_base_info)
		dict_dic_data_list = cursor_base_info.fetchall()
		
		sql_delete='delete from report_dic_data'
		cursor_report.execute(sql_delete)
		__write_info('delete report_dic_data')
		
		sql_insert_dic_data="insert into report_dic_data (id,code, dic_type_no,value) values (%(id)s, %(code)s,%(dic_type_no)s,%(value)s)"
		cursor_report.executemany(sql_insert_dic_data,dict_dic_data_list)
		__write_info('insert %d dics'%len(dict_dic_data_list))
	except mysql.connector.Error as e:
		__write_err('update dic data error!{}'.format(e))
	finally:
		cursor_base_info.close()
		cnn_base_info.close()
	####create dic end	
	
	if online_products.strip():
		cnn_sales=mysql_conn.get_conn(db_config.config_sales)
		
		if not cnn_sales:
			__write_warn("can't get connection of sales")
			return
		cursor_sales=cnn_sales.cursor(dictionary=True)
		
		####generate report
		try:
			###update emp daily
			sql_delete='delete from emp_sales_daily'
			
			sql_emp_sales_query ='''SELECT
			product_no,
			emp_no,
			product_type,
			SUM(money) AS amount,
			count(*) AS count, 
			purchase_date
			FROM
			sales
			WHERE
			(`status` = 2 OR `status` =3)
			AND product_no in (%s)
			GROUP BY
			product_no,
			emp_no,
			purchase_date;'''%online_products
			cursor_sales.execute(sql_emp_sales_query)			
			
			sql_delete='delete from emp_sales_daily WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete employee daily sales data of online products')
			
			for emp_daily_sales in cursor_sales:				
				#sql_emp_sales_daily_exist="""SELECT
				#id
				#FROM
				#emp_sales_daily
				#WHERE
				#product_no = %s
				#AND emp_no = %s
				#AND clac_time = str_to_date(%s, %s)"""		
				#cursor_report.execute(sql_emp_sales_daily_exist,(emp_daily_sales['product_no'],emp_daily_sales['emp_no'],emp_daily_sales['purchase_date'].strftime(__DATE_FORMAT),__DATE_FORMAT))
				#emp_sales_daily_id =cursor_report.fetchone()				
				#if emp_sales_daily_id is None:
				sql_insert_emp_sales_daily="""insert into emp_sales_daily
				(product_no,product_name, emp_no,emp_name,money_total,count,clac_time,in_user_no,in_time,edit_user_no,edit_time,edit_comment,product_type)
				values (%s, %s, %s, %s, %s,%s,str_to_date(%s, %s), %s,current_timestamp(), %s,current_timestamp(),%s,%s);"""
				emp_names = [x["name"] for x in dict_employee_list if x["user_no"] == emp_daily_sales['emp_no']]
				emp_name = emp_names[0] if emp_names else ""
				product_names = [x["name"]  for x in dict_product_list if x["id"] == emp_daily_sales['product_no']]
				product_name = product_names[0]if product_names else ""	
				cursor_report.execute(sql_insert_emp_sales_daily,(emp_daily_sales['product_no'],product_name,\
										emp_daily_sales['emp_no'],emp_name,emp_daily_sales['amount'],emp_daily_sales['count'],\
										emp_daily_sales['purchase_date'].strftime(__DATE_FORMAT),__DATE_FORMAT,0,0,"",emp_daily_sales['product_type']))
				__write_info("emp_sales_daily -- insert emp:%s product:%s date:%s amount:%f"%(emp_name,product_name,\
													emp_daily_sales['purchase_date'].strftime(__DATE_FORMAT),\
													emp_daily_sales['amount']))
					
				#else:
				#	sql_update_emp_daily_sales="update emp_sales_daily set money_total=%s WHERE id = %s"					
				#	cursor_report.execute(sql_update_emp_daily_sales,(emp_daily_sales['amount'],emp_sales_daily_id['id']))
				#	__write_info("emp_sales_daily -- update emp daily record%d  amount:%f"%(emp_sales_daily_id['id'],emp_daily_sales['amount']))
				#	
			
			###update emp total
			sql_delete='delete from emp_sales_total WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete employee total sales data of online products')
			
			sql_emp_sales_daily_sum_query='''SELECT
			product_no,
			product_name,
			emp_no,
			emp_name,
			SUM(money_total) amount,
			count(*) as count
			FROM emp_sales_daily
			WHERE
			product_no in (%s)
			GROUP BY
			product_no,
			product_name,
			emp_no,
			emp_name;'''%online_products
			
			cursor_report.execute(sql_emp_sales_daily_sum_query)
			emp_daily_sales_sums = cursor_report.fetchall()
			for emp_daily_sales_sum in emp_daily_sales_sums:		
				#sql_emp_sales_total_exist="SELECT id FROM emp_sales_total WHERE product_no=%s AND emp_no=%s"%(emp_daily_sales_sum['product_no'],emp_daily_sales_sum['emp_no'])
				#
				#cursor_report.execute(sql_emp_sales_total_exist)
				#
				#emp_sales_total_id=cursor_report.fetchone()
				#
				#
				#if emp_sales_total_id is None:				
				sql_insert_emp_sales_total="""insert into emp_sales_total
				(product_no,product_name, emp_no,emp_name,money_total,in_user_no,count,in_time,edit_user_no,edit_time,edit_comment)
				values (%s, %s, %s, %s, %s, %s,%s,current_timestamp(), %s,current_timestamp(),%s);"""				
				cursor_report.execute(sql_insert_emp_sales_total,(emp_daily_sales_sum['product_no'],emp_daily_sales_sum['product_name'],\
										emp_daily_sales_sum['emp_no'],emp_daily_sales_sum['emp_name'],\
										emp_daily_sales_sum['amount'],0,emp_daily_sales_sum['count'],0,"new"))
		
				__write_info("emp_sales_total -- insert emp:%s product:%s amount:%f"%(emp_daily_sales_sum['emp_name'],\
												      emp_daily_sales_sum['product_name'],emp_daily_sales_sum['amount']))
				#else:
				#	sql_update_emp_sales_total="update emp_sales_total set money_total=%s WHERE id = %s"
				#	cursor_report.execute(sql_update_emp_sales_total,(emp_daily_sales_sum['amount'],emp_sales_total_id['id']))
				#	__write_info("emp_sales_total -- update emp daily record%d  amount:%f"%(emp_sales_total_id['id'],emp_daily_sales_sum['amount']))
			
			###update dept daily
			sql_delete='delete from dept_sales_daily WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete department daily sales data of online products')
			
			sql_dept_sales_query='''SELECT
			s.product_no,
			s.product_name,
			e.dept_no,
			SUM(s.money_total) money_total,
			count(*) as count,
			s.clac_time,
			e.dept_type
			FROM
			emp_sales_daily s
			LEFT JOIN report_employee e ON s.emp_no = e.user_no
			WHERE
			product_no IN (%s)
			GROUP BY
			e.dept_no,
			s.product_no,
			s.product_name,
			s.clac_time'''%online_products
	
			cursor_report.execute(sql_dept_sales_query)
			detp_daily_sales_list =cursor_report.fetchall()
			for detp_daily_sales in detp_daily_sales_list:				
				#sql_detp_sales_daily_exist="""SELECT
				#id
				#FROM
				#dept_sales_daily
				#WHERE
				#product_no = %s
				#AND dept_no = %s
				#AND clac_time = str_to_date(%s, %s)"""		
				#cursor_report.execute(sql_detp_sales_daily_exist,(detp_daily_sales['product_no'],detp_daily_sales['dept_no'],detp_daily_sales['purchase_date'].strftime(__DATE_FORMAT),__DATE_FORMAT))
				#dept_sales_daily_id =cursor_report.fetchone()				
				#if dept_sales_daily_id is None:
			
				sql_insert_dept_sales_daily="""insert into dept_sales_daily
				(product_no,product_name, dept_no,dept_name,dept_type,money_total,count,clac_time,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
				values (%s, %s, %s,%s, %s, %s, %s,str_to_date(%s, %s), %s,current_timestamp(), %s,current_timestamp(),%s);"""
				dept_names = [x["name"] for x in dict_department_list if x["id"] == detp_daily_sales['dept_no']]
				dept_name = dept_names[0] if dept_names else ""	
				cursor_report.execute(sql_insert_dept_sales_daily,(detp_daily_sales['product_no'],detp_daily_sales['product_name'],\
										detp_daily_sales['dept_no'],dept_name,detp_daily_sales['dept_type'],detp_daily_sales['money_total'],detp_daily_sales['count'],\
										detp_daily_sales['clac_time'].strftime(__DATE_FORMAT),__DATE_FORMAT,0,0,""))
				__write_info("dept_sales_daily -- insert dept:%s product:%s date:%s amount:%f"%(dept_name,detp_daily_sales['product_name'],\
														detp_daily_sales['clac_time'].strftime(__DATE_FORMAT),\
														detp_daily_sales['money_total']))
		
				#else:					
				#	sql_update_dept_daily_sales="update dept_sales_daily set money_total=%s WHERE id = %s"					
				#	cursor_report.execute(sql_update_dept_daily_sales,(detp_daily_sales['amount'],dept_sales_daily_id['id']))
				#	__write_info("dept_sales_daily -- update dept daily record%d  amount:%f"%(dept_sales_daily_id['id'],detp_daily_sales['amount']))
				
			#update dept total
			sql_delete='delete from dept_sales_total WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete department total sales data of online products')
			
			sql_dept_sales_daily_sum_query='''SELECT
			product_no,
			product_name,
			dept_no,
			dept_name,
			dept_type,
			SUM(money_total) as amount,
			count(*) as count
			FROM dept_sales_daily
			WHERE
			product_no in (%s)
			GROUP BY
			product_no,
			product_name,
			dept_no,
			dept_name;'''%online_products
			
			cursor_report.execute(sql_dept_sales_daily_sum_query)
			dept_daily_sales_sums = cursor_report.fetchall();
			for dept_daily_sales_sum in dept_daily_sales_sums:			
				sql_insert_dept_sales_total="""insert into dept_sales_total
				(product_no,product_name, dept_no,dept_name,dept_type,money_total,count,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
				values (%s, %s, %s, %s, %s,%s, %s,%s,current_timestamp(), %s,current_timestamp(),%s);"""
				
				cursor_report.execute(sql_insert_dept_sales_total,(dept_daily_sales_sum['product_no'],dept_daily_sales_sum['product_name'],\
										dept_daily_sales_sum['dept_no'],dept_daily_sales_sum['dept_name'],dept_daily_sales_sum['dept_type'],\
										dept_daily_sales_sum['amount'],dept_daily_sales_sum['count'],0,0,"new"))
		
				__write_info("dept_sales_total -- insert dept:%s product:%s amount:%f"%(dept_daily_sales_sum['dept_name'],\
													dept_daily_sales_sum['product_name'],dept_daily_sales_sum['amount']))
			
			###update company daily
			sql_delete='delete from company_sales_daily WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete company daily sales data of online products')
			
			sql_company_sales_query='''SELECT
			s.product_no,
			s.product_name,
			d.company_no,
			SUM(s.money_total) money_total,
			s.clac_time
			FROM
			dept_sales_daily s
			LEFT JOIN report_department d ON s.dept_no = d.id
			WHERE
			product_no IN (%s)
			GROUP BY
			d.company_no,
			s.product_no,
			s.product_name,
			s.clac_time'''%online_products
	
			cursor_report.execute(sql_company_sales_query)
			company_daily_sales_list =cursor_report.fetchall()
			for company_daily_sales in company_daily_sales_list:				
				
			
				sql_insert_company_sales_daily="""insert into company_sales_daily
				(product_no,product_name, company_no,company_name,money_total,clac_time,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
				values (%s, %s, %s, %s, %s, str_to_date(%s, %s), %s,current_timestamp(), %s,current_timestamp(),%s);"""
				company_names = [x["name"] for x in dict_company_list if x["id"] == company_daily_sales['company_no']]
				company_name = company_names[0] if company_names else ""	
				cursor_report.execute(sql_insert_company_sales_daily,(company_daily_sales['product_no'],company_daily_sales['product_name'],\
										company_daily_sales['company_no'],company_name,company_daily_sales['money_total'],\
										company_daily_sales['clac_time'].strftime(__DATE_FORMAT),__DATE_FORMAT,0,0,""))
				__write_info("company_sales_daily -- insert company:%s product:%s date:%s amount:%f"%\
					     (company_name,company_daily_sales['product_name'],\
					      company_daily_sales['clac_time'].strftime(__DATE_FORMAT),company_daily_sales['money_total']))
			
			
			#update company total
			sql_delete='delete from company_sales_total WHERE product_no in (%s)'%online_products
			cursor_report.execute(sql_delete)
			__write_info('delete company total sales data of online products')
			
			sql_company_sales_daily_sum_query='''SELECT
			product_no,
			product_name,
			company_no,
			company_name,
			SUM(money_total) amount
			FROM company_sales_daily
			WHERE
			product_no in (%s)
			GROUP BY
			product_no,
			product_name,
			company_no,
			company_name;'''%online_products
			
			cursor_report.execute(sql_company_sales_daily_sum_query)
			company_daily_sales_sums = cursor_report.fetchall();
			
			for company_daily_sales_sum in company_daily_sales_sums:
				sql_insert_company_sales_total="""insert into company_sales_total
				(product_no,product_name, company_no,company_name,money_total,in_user_no,in_time,edit_user_no,edit_time,edit_comment)
				values (%s, %s, %s, %s, %s, %s,current_timestamp(), %s,current_timestamp(),%s);"""
			
				cursor_report.execute(sql_insert_company_sales_total,(company_daily_sales_sum['product_no'],company_daily_sales_sum['product_name'],\
											company_daily_sales_sum['company_no'],company_daily_sales_sum['company_name'],\
											company_daily_sales_sum['amount'],0,0,"new"))
	
				__write_info("company_sales_total -- insert company:%s product:%s amount:%f"%\
					     (company_daily_sales_sum['company_name'],company_daily_sales_sum['product_name'],company_daily_sales_sum['amount']))
				
		except mysql.connector.Error as e:
			__write_err('update sales reports error!{}'.format(e))
		finally:
			cursor_report.close()
			cursor_sales.close()
			cnn_report.close()
			cnn_sales.close()
if __name__ =="__main__":  
	main()  