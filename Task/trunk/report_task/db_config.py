#encoding: utf-8
#!/usr/bin/python

#######DB Config start#########################
__db_host='192.168.1.233'
#__db_user='root'
#__db_password='huazhen@123'
__db_port=3306
config_sales={'host':__db_host,
	'user':'writeSales',
	'password':'writeSales',
	'port':__db_port ,
	'database':'sales',
	'charset':'utf8'
	}
config_employee={'host':__db_host,
        'user':'writeEmployee',
        'password':'writeEmployee',
        'port':__db_port ,
        'database':'employee',
        'charset':'utf8'
        }
config_customer={'host':__db_host,
        'user':'writeCustomer',
        'password':'writeCustomer',
        'port':__db_port ,
        'database':'customer',
        'charset':'utf8'
        }
config_report={'host':__db_host,
        'user':'writeReport',
        'password':'writeReport',
        'port':__db_port ,
        'database':'report',
        'charset':'utf8'
        }
config_product={'host':__db_host,
        'user':'readerProduct',
        'password':'readerProduct',
        'port':__db_port ,
        'database':'product',
        'charset':'utf8'
        }
config_base_info={'host':__db_host,
        'user':'writeBase',
        'password':'writeBase',
        'port':__db_port ,
        'database':'base_info',
        'charset':'utf8'
        }
config_work_flow={'host':__db_host,
        'user':'root',
        'password':'hz@123',
        'port':__db_port ,
        'database':'work_flow',
        'charset':'utf8'
        }
config_payment={'host':__db_host,
        'user':'writePayment',
        'password':'writePayment',
        'port':__db_port ,
        'database':'payment',
        'charset':'utf8'
        }
#######DB Config end###########################

