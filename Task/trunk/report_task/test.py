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
		cnn_payment = mysql_conn.get_conn(db_config.config_payment)
		if cnn_payment == None:
			__write_warn("Can't get connection of notify","__process_mails")
			return
		cursor_payment = cnn_payment.cursor(dictionary=True)

		sql_select_paymentRefund = '''
			SELECT p2p_product_no,actual_pay_time,pay_money,times 
			FROM payment_refund 
			WHERE date_add(actual_pay_time, INTERVAL 3 day) < now()
		'''

		【华镇金控】尊敬的客户您好！
		您购买的${PRODUCT_NAME}产品${TIME}第${NUMBER}次付息${MONEY}，
		请注意查收，如有疑问请联系您的理财经理办理！
		客服电话：${PHONE_NUMBER}
	except Exception, e:
		print (e)
		return False

	finally:
		cursor_payment.close();
		cnn_payment.close();