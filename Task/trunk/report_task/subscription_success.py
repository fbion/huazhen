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
		cnn_sales = mysql_conn.get_conn(db_config.config_sales)
		if cnn_sales == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_sales = cnn_sales.cursor(dictionary=True)

		cnn_base_info = mysql_conn.get_conn(db_config.config_base_info)
		if cnn_base_info == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_base_info = cnn_base_info.cursor(dictionary=True)

		sql_select_sales = '''
			select id,customer_no,money,product_no from sales where `status` = 3 and is_send_sms = 0
			'''
		cursor_sales.execute(sql_select_sales);
		sales = cursor_sales.fetchall();
		for sale in sales:
			sql_insert_sms = '''
				insert into sms(cellnumber,smscontent,status) value(%s,%s,%s);
			'''
			customers = __getCustoemrByCustoemrNo(sale['customer_no'])
			for customer in customers:
				customerName = customer['name'];
			templetes =  __getSmsTempleteByKey(3);
			for templete in templetes:
				content = templete['content']
			products = __getProductByNo(sale['product_no'])
			for product in products:
				productName = product['name']

			content = content.replace('${USER_NAME}',customerName)
			content = content.replace('${AMOUNT}',str(sale['money']))
			content = content.replace('${PRODUCT_NAME}',"'"+productName+"'")
			cursor_base_info.execute(sql_insert_sms,(customer['cellphone1'],content,1))

			sql_update_sales = '''
				update sales set is_send_sms = 1 where id = %s
			'''%sale['id']
			cursor_sales.execute(sql_update_sales);
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_base_info.close()
		cnn_base_info.close()
		cursor_sales.close()
		cnn_sales.close()
def __getProductByNo(productNo):
	try:
		cnn_product = mysql_conn.get_conn(db_config.config_product)
		if cnn_product == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_product = cnn_product.cursor(dictionary=True)
		sql_select_product = '''
			select id,name from product where id = %s
		'''%productNo
		cursor_product.execute(sql_select_product);
		products = cursor_product.fetchall()
		return products
	except Exception, e:
		raise
	else:
		pass
	finally:
		pass

def __getSmsTempleteByKey(key):
	try:
		cnn_base_info = mysql_conn.get_conn(db_config.config_base_info)
		if cnn_base_info == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_base_info = cnn_base_info.cursor(dictionary=True)
		sql_select_templete = '''
			select content,subject from smstemplete where sysno = %s
		'''%key
		cursor_base_info.execute(sql_select_templete);
		templetes = cursor_base_info.fetchall();
		return templetes
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_base_info.close()
		cnn_base_info.close()

def __getCustoemrByCustoemrNo(customerNo):
	try:
		cnn_customer = mysql_conn.get_conn(db_config.config_customer)
		if cnn_customer == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_customer= cnn_customer.cursor(dictionary=True)
		sql_select_customer = '''
			select id,name,cellphone1 from customer_personal where id = %s
		'''%customerNo
		cursor_customer.execute(sql_select_customer);
		customers = cursor_customer.fetchall();
		return customers
	except Exception, e:
		print (e)
		return False
	finally:
		cursor_customer.close()
		cnn_customer.close()

	
if __name__ == '__main__':
	__main()		