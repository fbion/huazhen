#encoding:utf-8
#!/usr/bin/python

import mysql
import my_logger
import db_config
import mysql_conn
import time
import datetime

def __write_info(content,func):
	my_logger.write_info(content,"performance",func)
def __write_err(content,func):
	my_logger.write_err(content,"performance",func)
def __write_warn(content,func):
	my_logger.write_warn(content,"performance",func)

def __channel():
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)

		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)


		sql_select_employee = '''
			select id,name,user_no,dept_no,position_no from employee where dept_no = 10 and is_test = 0
		'''
		cursor_employee.execute(sql_select_employee)
		employees  = cursor_employee.fetchall()
		for employee in employees:
			sql_select_sales = '''
				select id,emp_no,sum(money) money,purchase_date,product_no from sales
				WHERE product_type not in (%s) and emp_no = %s
				and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(purchase_date, '%Y%m' ) ) = 1
				group by emp_no
			'''
			cursor_sales.execute(sql_select_sales,(3,employee['user_no']))
			sales = cursor_sales.fetchall()
			for sale in sales:
				if sale['money'] >= 1500000:
					commission_scale = 0.0006
				if sale['money'] < 1500000:
					commission_scale = 0.0004
				p_type = '其他产品'

				a = str(sale["purchase_date"]) #获得时间
				timeArray = time.strptime(a, "%Y-%m-%d")
				year = time.strftime("%Y", timeArray)
				month = time.strftime("%m",timeArray)

				establish_money = __getEstablishMoney(sale['emp_no'])#本月成立金额
				if establish_money == None:
					establish_money = 0
				commission_money = int(establish_money) * commission_scale

				sql_insert_commission_wealthCenter = '''
					insert into commission_wealthCenter(emp_no,emp_name,dept_no,position_no,sales_money,
					commission_scale,establish_money,commission_money,is_examine,year,month,product_no,type)
					values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
				'''
				cursor_employee.execute(sql_insert_commission_wealthCenter,(sale['emp_no'],employee['name'],employee['dept_no'],\
					employee['position_no'],sale['money'],commission_scale,establish_money,commission_money,1,year,month,sale['product_no'],p_type))
	except Exception, e:
		print(e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()
		cursor_sales.close()
		cnn_sales.close()
def __channelSpecial():#渠道特殊产品
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)

		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)


		sql_select_employee = '''
			select id,name,user_no,dept_no,position_no from employee where dept_no = 10 and is_test = 0
		'''
		cursor_employee.execute(sql_select_employee)
		employees  = cursor_employee.fetchall()
		for employee in employees:
			sql_select_sales = '''
				select id,emp_no,sum(money) money,purchase_date,product_no from sales
				WHERE product_type in (%s) and emp_no = %s
				and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(purchase_date, '%Y%m' ) ) = 1
				group by emp_no
			'''
			cursor_sales.execute(sql_select_sales,(3,employee['user_no']))
			sales = cursor_sales.fetchall()

			for sale in sales:
				if sale['money'] >= 1500000:
					commission_scale = 0.006
				if sale['money'] < 1500000:
					commission_scale = 0.004
				p_type = '契约型基金'

				a = str(sale["purchase_date"]) #获得时间
				timeArray = time.strptime(a, "%Y-%m-%d")
				year = time.strftime("%Y", timeArray)
				month = time.strftime("%m",timeArray)

				establish_money = __getEstablishMoneySpecial(sale['emp_no'])#本月成立金额
				commission_money = int(establish_money) * commission_scale

				sql_insert_commission_wealthCenter = '''
					insert into commission_wealthCenter(emp_no,emp_name,dept_no,position_no,sales_money,
					commission_scale,establish_money,commission_money,is_examine,year,month,product_no,type)
					values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
				'''
				cursor_employee.execute(sql_insert_commission_wealthCenter,(sale['emp_no'],employee['name'],employee['dept_no'],\
					employee['position_no'],sale['money'],commission_scale,establish_money,commission_money,1,year,month,sale['product_no'],p_type))
	except Exception, e:
		print(e)
		return False
	finally:
		cursor_employee.close()
		cnn_employee.close()

def __getProductTypeByProductNo(productNo):
	try:
		cnn_product = mysql_conn.get_conn(db_config.config_product)
		if cnn_product == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_product = cnn_product.cursor(dictionary=True)

		sql_select_productType = '''
			select type from product where id = %s
		'''%productNo

		cursor_product.execute(sql_select_productType)
		product_types = cursor_product.fetchall()
		
		for product_type in product_types:
			result = product_type['type']
		print result
		return result

	except Exception, e:
		print(e)
		return False
	finally:
		cursor_product.close()
		cnn_product.close()

def __getEstablishMoneySpecial(emp_no):
	try:
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)
		print emp_no
		sql_select_establish_money = '''
			select sum(money) money from sales 
			where product_type in (%s) and emp_no = %s
			and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(`establish_date`, '%Y%m' ) ) = 1 
		'''
		cursor_sales.execute(sql_select_establish_money,(3,emp_no))
		establish_moneys = cursor_sales.fetchall()
		for establish_money in establish_moneys:
			result = establish_money['money']
		return result
	except Exception, e:
		print(e)
		return False
	finally:
		cursor_sales.close()
		cnn_sales.close()
def __getEstablishMoney(emp_no):
	try:
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)
		print emp_no
		sql_select_establish_money = '''
			select sum(money) money from sales 
			where product_type not in (%s) and emp_no = %s
			and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(`establish_date`, '%Y%m' ) ) = 1 
		'''
		cursor_sales.execute(sql_select_establish_money,(3,emp_no))
		establish_moneys = cursor_sales.fetchall()
		for establish_money in establish_moneys:
			result = establish_money['money']
		return result
	except Exception, e:
		print(e)
		return False
	finally:
		cursor_sales.close()
		cnn_sales.close()



def __main():#普通理财经理计算绩效和津贴
	try:
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)
		cursor_employee = cnn_employee.cursor(dictionary=True)

		sql_select_employee='''
			select id,name,user_no,dept_no,position_no,status from employee where position_no in(13,17) and is_test = 0
		'''
		cursor_employee.execute(sql_select_employee)
		employees = cursor_employee.fetchall()
		for employee in employees:
			sql_sales_money='''
				select id,emp_no,dept_no,datediff(repayment_date,purchase_date)+1 day,
				sum((datediff(repayment_date,purchase_date)+%s)/base_number*money) sale_money,
				money,purchase_date from sales s where emp_no = %s and is_test = 0 and status = 3
				and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( purchase_date, '%Y%m' ) ) = 1;
			''';

			#and status = 3
			cursor_sales.execute(sql_sales_money,(1,employee['user_no']))
			sales_money = cursor_sales.fetchall();
		
			for sale_money in sales_money:
				if sale_money["purchase_date"] == None:
					continue
				if sale_money["sale_money"] == None:
					continue
				print sale_money["emp_no"]
				a = str(sale_money["purchase_date"]) #获得时间
				timeArray = time.strptime(a, "%Y-%m-%d")
				year = time.strftime("%Y", timeArray)
				month = time.strftime("%m",timeArray)

				#print sale_money["sale_money"]
				sales_total = int(sale_money["sale_money"]);#销售总额（一个月）
				standard = 0;#标准业绩
				if employee["position_no"] == 13:#理财经理
					standard = 30
				elif employee["position_no"] == 17:#高级理财经理
					standard = 50
				else:
					continue

				finish_scale = int(sale_money["sale_money"])/standard/100;#完成比例
				finish_level = __getLevelByScale(finish_scale);#完成级别
				
				results = __getCommissionScale(finish_level);#查询提成比例
				for result in results:
					commission_scale = result["cs"];#提成比例
					print employee['status']
					if employee['status'] == 5:
						commission_scale = 1
					commission = sales_total * commission_scale/100;#提成
				
				sql_delete_achievement_commission = '''
					delete from achievement_commission where year = %s and month = %s and emp_no = %s
				'''
				cursor_employee.execute(sql_delete_achievement_commission,(year,month,sale_money['id']));

				#绩效
				sql_insert_achievement_commission= '''
					insert into achievement_commission(emp_no,emp_name,standard,sales_money,
					finish_scale,commission_scale,commission_money,dept_no,position_no,year,month)
					VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);
				''';
				cursor_employee.execute(sql_insert_achievement_commission,(employee['user_no'],\
									employee['name'],standard,sales_total,finish_scale,\
									commission_scale,commission,employee["dept_no"],\
									employee["position_no"],year,month));
				#津贴

				subsidy_scale = 0.2;
				subsidy = sales_total * subsidy_scale /100;
				achieve_time =  datetime.datetime.strptime(time.strftime("%Y-%m", timeArray), "%Y-%m").date() 
				sql_insert_subsidy_total = '''
					insert into subsidy_total(emp_no,emp_name,dept_no,position_no,
					subsidy_scale,sales_money,subsidy,achieve_time,in_time,is_examine)
					values(%s,%s,%s,%s,%s,%s,%s,%s,now(),1)
				''';
				cursor_employee.execute(sql_insert_subsidy_total,(employee['user_no'],employee["name"],\
									employee["dept_no"],employee["position_no"],0.2,sales_total,\
									subsidy,achieve_time,));
	except Exception, e:
		print(e);
		return False
	finally:
		cursor_sales.close()
		cnn_sales.close()
		cursor_employee.close()
		cnn_employee.close() 
def __store_managerSS():
	try:
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)
		cursor_employee = cnn_employee.cursor(dictionary=True)

		sql_select_employee='''
			select id,name,user_no,dept_no,position_no from employee where position_no in(14)
		'''
		cursor_employee.execute(sql_select_employee)
		employees = cursor_employee.fetchall()
		for employee in employees:
			sql_sales_money='''
				select id,emp_no,dept_no,datediff(repayment_date,establish_date)+1 day,
				sum((datediff(repayment_date,establish_date)+%s)/base_number*money) sale_money,
				money,purchase_date from sales s where emp_no = %s and status = 3
				and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( purchase_date, '%Y%m' ) ) = 1;
			''';
			#
			cursor_sales.execute(sql_sales_money,(1,employee['user_no']))
			sales_money = cursor_sales.fetchall();
		
			for sale_money in sales_money:
				if sale_money["purchase_date"] == None:
					continue
				if sale_money["sale_money"] == None:
					continue
				a = str(sale_money["purchase_date"]) #获得时间
				timeArray = time.strptime(a, "%Y-%m-%d")
				year = time.strftime("%Y", timeArray)
				month = time.strftime("%m",timeArray)

				commission_scale = 1.3
				sales_total = int(sale_money["sale_money"]);#销售总额（一个月）
				commission = sales_total * commission_scale / 100;#提成

				sql_delete_achievement_commission = '''
					delete from achievement_commission where year = %s and month = %s and emp_no = %s
				'''
				cursor_employee.execute(sql_delete_achievement_commission,(year,month,sale_money['id']));

				#绩效
				sql_insert_achievement_commission= '''
					insert into achievement_commission(emp_no,emp_name,sales_money,
					commission_money,dept_no,position_no,year,month,commission_scale)
					VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s);
				''';
				cursor_employee.execute(sql_insert_achievement_commission,(employee['user_no'],\
									employee['name'],sales_total,commission,employee["dept_no"],\
									employee["position_no"],year,month,commission_scale));
				#津贴

				subsidy_scale = 0.2;
				subsidy = sales_total * subsidy_scale / 100;
				achieve_time =  datetime.datetime.strptime(time.strftime("%Y-%m", timeArray), "%Y-%m").date() 
				sql_insert_subsidy_total = '''
					insert into subsidy_total(emp_no,emp_name,dept_no,position_no,
					subsidy_scale,sales_money,subsidy,achieve_time,in_time,is_examine)
					values(%s,%s,%s,%s,%s,%s,%s,%s,now(),1)
				''';
				cursor_employee.execute(sql_insert_subsidy_total,(employee['user_no'],employee["name"],\
									employee["dept_no"],employee["position_no"],0.2,sales_total,\
									subsidy,achieve_time,));
	except Exception, e:
		print(e);
		return False
	finally:
		cursor_sales.close()
		cnn_sales.close()
		cursor_employee.close()
		cnn_employee.close() 
def __getStatusByEmpNo(empNo):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_employee = '''
			select name,status from employee 
			where user_no = %s 
			'''%empNo
		cursor_employee.execute(sql_select_employee);
		results = cursor_employee.fetchall();
		return results
	except Exception, e:
		print (e)
		return False
	finally:
		pass
		cursor_employee.close()
		cnn_employee.close()
def __store_manager():#店长绩效计算
	try:
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_select_employee = '''
			select user_no,dept_no from employee where position_no in(14,59) 
		'''
		#and status in (1,4,5)
		cursor_employee.execute(sql_select_employee)
		employees = cursor_employee.fetchall()
		
		emp_nos = ''
		for employee in employees:
			emp_nos = str(employee["user_no"])+","+ emp_nos
			
		sql_sales_money='''
			select id,dept_no,sum((datediff(repayment_date,establish_date)+1)/base_number*money)
			money,purchase_date from sales where emp_no not in ('''+emp_nos[0:-1]+''') and  people_type = 4
			and PERIOD_DIFF(date_format( now( ) , '%Y%m' ) , date_format(purchase_date, '%Y%m' ) ) = 1
			and status = 3 group by dept_no
		''';
			#
		
		cursor_sales.execute(sql_sales_money)
		sales_money = cursor_sales.fetchall();
		for sale_money in sales_money:
			if sale_money["money"] == None:
				continue
			print sale_money['dept_no']
			a = str(sale_money["purchase_date"])
			timeArray = time.strptime(a, "%Y-%m-%d")
			year = time.strftime("%Y", timeArray)
			month = time.strftime("%m",timeArray);

			sales_total = int(sale_money["money"]);#销售总额（一个月）
			standard = 400;
			finish_scale = int(sale_money["money"])/standard/100;#完成比例
			finish_level = __getLevelByScaleManager(finish_scale);#完成级别
			results = __getCommissionScale(finish_level);#查询提成比例
			
			for result in results:
				commission_scale = result["cs"];#提成比例
				
			storeManagers = __getStoreManagerByDeptNo(sale_money["dept_no"])
			for storeManager in storeManagers:
				empNo = storeManager["user_no"]
				emp_name = storeManager["name"]
			status = __getStatusByEmpNo(empNo);
			for statu in status:
				if statu['status'] == 5:
					commission_scale = 0.2
			commission = sales_total * commission_scale/100;#提成
			sql_delete_achievement_commission = '''
				delete from achievement_commission where year = %s and month = %s and emp_no = %s
			'''
			cursor_employee.execute(sql_delete_achievement_commission,(year,month,empNo));
			#绩效
			sql_insert_achievement_commission= '''
				insert into achievement_commission(emp_no,emp_name,standard,sales_money,
				finish_scale,commission_scale,commission_money,dept_no,position_no,year,month)
				values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'''
			cursor_employee.execute(sql_insert_achievement_commission,(empNo,emp_name,standard,\
							sales_total,finish_scale,commission_scale,commission,\
							sale_money["dept_no"],14,year,month));
				#津贴
			subsidy_scale = 0.05;
			subsidy = sales_total * subsidy_scale /100 ;
			achieve_time =  datetime.datetime.strptime(time.strftime("%Y-%m", timeArray), "%Y-%m").date() 
			sql_insert_subsidy_total = '''
				insert into subsidy_total(emp_no,emp_name,dept_no,position_no,subsidy_scale,
				sales_money,subsidy,achieve_time,in_time,is_examine)
				values(%s,%s,%s,%s,%s,%s,%s,%s,now(),1);
				''';
			cursor_employee.execute(sql_insert_subsidy_total,(empNo,emp_name,sale_money["dept_no"],\
									14,subsidy_scale,sales_total,subsidy,achieve_time));
			
	except Exception, e:
		print(e);
		return False
	finally:
		cursor_sales.close()
		cnn_sales.close()
		cursor_employee.close()
		cnn_employee.close()

def __getCommissionScale(finish_level):#根据完成比例和职级查询提成比例
	try:
		cnn_report = mysql_conn.get_conn(db_config.config_report)
		if cnn_report == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_report = cnn_report.cursor(dictionary=True)
		sql_jiben = '''
				select id,commission_scale cs
				from commission_rule 
				where finish_level = %s;
			'''%finish_level
		cursor_report.execute(sql_jiben);
		result = cursor_report.fetchall();
		return result;

	except Exception, e:
		print (e)
		return False
	finally:
		cursor_report.close()
		cnn_report.close()

def __getStoreManagerByDeptNo(dept_no):
	try:
		cnn_employee = mysql_conn.get_conn(db_config.config_employee)
		if cnn_employee == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_employee = cnn_employee.cursor(dictionary=True)
		sql_store_manager = '''
			select name,user_no from employee 
			where dept_no = %s and position_no = 14;
			'''%dept_no
		cursor_employee.execute(sql_store_manager);
		results = cursor_employee.fetchall();
		return results
	except Exception, e:
		print (e)
		return False
	finally:
		pass
		cursor_employee.close()
		cnn_employee.close()
def __getLevelByScaleManager(finish_scale):
	finish_level = 0;
	if finish_scale < 30:
		finish_level = 8
	if 30 <= finish_scale < 50:
		finish_level = 9
	if 50 <= finish_scale < 80:
		finish_level = 10
	if finish_scale >= 80:
		finish_level = 11
	return finish_level

def __getLevelByScale(finish_scale):#转化完成比例
	finish_level = 0;
	if finish_scale < 50:
		finish_level = 1
	if 50 <= finish_scale < 100:
		finish_level = 2
	if 100 <= finish_scale < 200:
		finish_level = 3
	if 200 <= finish_scale < 400:
		finish_level = 4
	if 400 <= finish_scale < 800:
		finish_level = 5
	if 800 <= finish_scale < 1600:
		finish_level = 6
	if finish_scale >= 1600:
		finish_level = 7
	return finish_level

if __name__ == '__main__':
	# __channelSpecial()
	# __channel()
	__main()
	__store_manager()
	__store_managerSS()
	#__getStoreManagerByDeptNo(15)


	
