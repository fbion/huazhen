#encoding:utf-8
#!/usr/bin/python

import mysql
import my_logger
import db_config
import mysql_conn
import time
import datetime
import xlwt
import re
import logging
import string
def __main():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)

        sql_delete_transaction = '''
            delete from employee_transaction
        '''
        cursor_employee.execute(sql_delete_transaction)
        #入职
        sql_select_employee = '''
            select e.name,e.sex,e.dept_no,e.position_no,d.start_time,d.IDCard,d.bank_account,bank_address 
            from employee e LEFT OUTER JOIN employee_detail d on e.id = d.emp_no
            WHERE  PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( d.start_time, '%Y%m' ) ) =1
        '''
        cursor_employee.execute(sql_select_employee)
        emps = cursor_employee.fetchall()
        for emp in emps:
            print emp['name']
            sql_insert_transaction = '''
                insert into employee_transaction(transaction_type,name,sex,after_dept,after_position,start_time,
                transaction_time,id_card,card_number,account_line)
                values(1,%s,%s,%s,%s,%s,%s,%s,%s,%s)
            '''
            cursor_employee.execute(sql_insert_transaction,(emp['name'],emp['sex'],emp['dept_no'],emp['position_no'],\
                        emp['start_time'],emp['start_time'],emp['IDCard'],emp['bank_account'],emp['bank_address']))
        #离职
        sql_select_lizhi = '''
            select e.`name`,e.sex,r.dept_no,r.position_no,r.hire_time,r.leave_time,d.IDCard,
            d.bank_account,d.bank_address
            from resign_application r LEFT OUTER JOIN
            (employee e LEFT OUTER JOIN employee_detail d on e.id  = d.emp_no) 
            on r.emp_no = e.id
        '''
        cursor_employee.execute(sql_select_lizhi)
        lizhis = cursor_employee.fetchall()
        for lizhi in lizhis:
            sql_insert_transaction = '''
                insert into employee_transaction(transaction_type,name,sex,before_dept,before_position,start_time,
                transaction_time,end_time,id_card,card_number,account_line)
                values(2,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
            '''
            cursor_employee.execute(sql_insert_transaction,(lizhi['name'],lizhi['sex'],lizhi['dept_no'],lizhi['position_no'],\
                lizhi['hire_time'],lizhi['leave_time'],lizhi['leave_time'],lizhi['IDCard'],lizhi['bank_account'],lizhi['bank_address']))
        #转正
        sql_select_zhuanzheng = '''
            select e.name,e.sex,e.dept_no,e.position_no,d.start_time,d.IDCard,d.bank_account,bank_address,d.official_time
            from employee e LEFT OUTER JOIN employee_detail d on e.id = d.emp_no
            WHERE  PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( d.official_time, '%Y%m' ) ) =1
        '''
        cursor_employee.execute(sql_select_zhuanzheng)
        zhuanzhengs = cursor_employee.fetchall()
        for zhuanzheng in zhuanzhengs:
            sql_insert_transaction = '''
                insert into employee_transaction(transaction_type,name,sex,before_dept,before_position,start_time,transaction_time,
                id_card,card_number,account_line)
                values(3,%s,%s,%s,%s,%s,%s,%s,%s,%s)
            '''
            cursor_employee.execute(sql_insert_transaction,(zhuanzheng['name'],zhuanzheng['sex'],zhuanzheng['dept_no'],zhuanzheng['position_no'],\
                zhuanzheng['start_time'],zhuanzheng['official_time'],zhuanzheng['IDCard'],zhuanzheng['bank_account'],zhuanzheng['bank_address']))
        #人事变动
        sql_select_change = '''
            select c.property,e.name,c.dept_no,c.position_no,c.force_time,
            e.sex,d.start_time,d.IDCard,d.bank_account,d.bank_address
            from personal_change c LEFT OUTER JOIN (employee e
            LEFT OUTER JOIN employee_detail d on e.id = d.emp_no)
            on c.emp_no = e.id 
        '''
        cursor_employee.execute(sql_select_change)
        changes = cursor_employee.fetchall()
        for change in changes:
            sql_insert_transaction = '''
                insert into employee_transaction(transaction_type,name,sex,before_dept,before_position,start_time,transaction_time,
                id_card,card_number,account_line)
                values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
            '''
            cursor_employee.execute(sql_insert_transaction,(change['property'],change['name'],change['sex'],change['dept_no'],change['position_no'],\
                change['start_time'],change['force_time'],change['IDCard'],change['bank_account'],change['bank_address']))

    except Exception, e:
        print (e)
        return False
        
    finally:
        cursor_employee.close()
        cnn_employee.close()

def __select_transaction():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_transaction = '''
            select id,transaction_type,name,before_dept,before_position,sex,after_dept,after_position,start_time,
            try_wage,meal_subsidy,telephone_subsidy,tratfic_subsidy,transaction_time,before_wage,after_wage,end_time,
            id_card,card_number,account_line,departture_debie,comment from employee_transaction
        '''
        cursor_employee.execute(sql_select_transaction)
        transactions = cursor_employee.fetchall()
        wbk = xlwt.Workbook()
        sheet2  = wbk.add_sheet(u'人事异动表')
        sheet1  = wbk.add_sheet(u'人事统计报表')
        
        createXLSTitle(sheet1) 
        createXLSTitle1(sheet2)
        __data(sheet1)
        __None(sheet1)
        for i, transaction in enumerate(transactions): 
            createXLS(sheet2,transaction,i)
        year = str(time.strftime("%Y"))
        month = str(int(time.strftime("%m")) - 1)
        print year + "mmmmmmmmmmmm"
        print month
        wbk.save("/usr/local/apache-tomcat-8.0.11/webapps/upload/files/"+year+"/"+month+"/"+ unicode("人事报表")+".xls")
    except Exception, e:
        print (e)
        return False
        
    finally:
        cursor_employee.close()
        cnn_employee.close()
def createXLS(sheet,body,int):
    style_border = xlwt.easyxf("""
        align: 
            wrap on, 
            vert center, 
            horiz center;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """) 
    a = int + 5
    
    before_dept = ""
    if body['before_dept'] != None:
        before_dept = __getDeptNameByDeptNo(body['before_dept'])
    before_position = ""
    if body['before_position'] != None:
        before_position = __getPositionByPositionNo(body['before_position'])
        after_dept = ""
    if body['after_dept'] != None:
        after_dept = __getDeptNameByDeptNo(body['after_dept'])
    after_position = ""
    if body['after_position'] != None:
        after_position = __getPositionByPositionNo(body['after_position'])
    end_time = ""
    if body['end_time'] != None:
        end_time = body['end_time']
    card_number = ""
    if body['card_number'] != None:
        card_number = body['card_number']
    id_card = ""
    if body['id_card'] != None:
        id_card = body['id_card']
    account_line = ""
    if body['account_line'] != None:
        account_line = body['account_line']
    sex = ""
    if body['sex'] == 1:
        sex = "男"
    if body['sex'] == 2:
        sex = "女"
    sheet.write_merge(a,a,0,0,unicode(body['transaction_type']),style_border)
    sheet.write_merge(a,a,1,1,unicode(body['name']),style_border)
    sheet.write_merge(a,a,2,2,unicode(before_dept),style_border)
    sheet.write_merge(a,a,3,3,unicode(before_position),style_border)
    sheet.write_merge(a,a,4,4,unicode(sex),style_border)
    sheet.write_merge(a,a,5,5,unicode(after_dept),style_border)
    sheet.write_merge(a,a,6,6,unicode(after_position),style_border)
    sheet.write_merge(a,a,7,7,unicode(body['start_time']),style_border)
    sheet.write_merge(a,a,8,8,u"",style_border)
    sheet.write_merge(a,a,9,9,u"",style_border)
    sheet.write_merge(a,a,10,10,u"",style_border)
    sheet.write_merge(a,a,11,11,u"",style_border)
    sheet.write_merge(a,a,12,12,unicode(body['transaction_time']),style_border)
    sheet.write_merge(a,a,13,13,u"",style_border)
    sheet.write_merge(a,a,14,14,u"",style_border)
    sheet.write_merge(a,a,15,15,unicode(end_time),style_border)
    sheet.write_merge(a,a,16,16,unicode(id_card),style_border)
    sheet.write_merge(a,a,17,17,unicode(card_number),style_border)
    sheet.write_merge(a,a,18,18,unicode(account_line),style_border)
    sheet.write_merge(a,a,19,19,u"",style_border)
    sheet.write_merge(a,a,20,20,u"",style_border)
def __getDeptNameByDeptNo(dept_no):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)

        sql_select_dept = '''
            select name from department where id  = %s
        '''%dept_no
        cursor_employee.execute(sql_select_dept)
        depts = cursor_employee.fetchall()
        for dept in depts:
            return dept['name']
    except Exception, e:
        print (e)
        return False
    
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getPositionByPositionNo(position_no):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)

        sql_select_dept = '''
            select name from position where id  = %s
        '''%position_no
        cursor_employee.execute(sql_select_dept)
        positions = cursor_employee.fetchall()
        for position in positions:
            return position['name']
    except Exception, e:
        print (e)
        return False
    
    finally:
        cursor_employee.close()
        cnn_employee.close()
def createXLSTitle1(sheet):
    style_gray = xlwt.easyxf("""
        pattern: 
            pattern solid,
            fore_color 22;
        font: 
            name Arial, 
            colour_index 0,
            bold on;
        align: 
            wrap on, 
            vert center, 
            horiz center;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """) 
    style_head = xlwt.easyxf("""
        font: 
            name Arial, 
            colour_index 0,
            bold on;
        align: 
            wrap on, 
            vert center, 
            horiz center;
        """) 

    sheet.write_merge(0,2,0,20,u"人事异动表",style_head)
    sheet.write_merge(3,4,0,0,u"异动类型",style_gray)
    sheet.write_merge(3,4,1,1,u"姓名",style_gray)
    sheet.write_merge(3,4,2,2,u"异动前部门",style_gray)
    sheet.write_merge(3,4,3,3,u"异动前职务",style_gray)
    sheet.write_merge(3,4,4,4,u"性别",style_gray)
    sheet.write_merge(3,4,5,5,u"异动后部门",style_gray)
    sheet.write_merge(3,4,6,6,u"异动后职务",style_gray)
    sheet.write_merge(3,4,7,7,u"入职日期",style_gray)
    sheet.write_merge(3,4,8,8,u"试用工资",style_gray)
    sheet.write_merge(3,4,9,9,u"餐补",style_gray)
    sheet.write_merge(3,4,10,10,u"通讯补",style_gray)
    sheet.write_merge(3,4,11,11,u"交通补",style_gray)
    sheet.write_merge(3,4,12,12,u"异动时间",style_gray)
    sheet.write_merge(3,4,13,13,u"异动前工资",style_gray)
    sheet.write_merge(3,4,14,14,u"异动后工资",style_gray)
    sheet.write_merge(3,4,15,15,u"离职日期",style_gray)
    sheet.write_merge(3,4,16,16,u"身份证号",style_gray)
    sheet.write_merge(3,4,17,17,u"银行卡号",style_gray)
    sheet.write_merge(3,4,18,18,u"开户行",style_gray)
    sheet.write_merge(3,4,19,19,u"离职扣款",style_gray)
    sheet.write_merge(3,4,20,20,u"备注",style_gray)   
def __None(sheet):
    style_boeder = xlwt.easyxf("""
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """)
    for i in range(11):
        i = i + 5
        for j in range(10):
            j = j + 5
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    for j in range(11):
            j = j + 5
            sheet.write_merge(j, j, 2, 2, u"",style_boeder)
    
    for i in range(2):
        i = i + 19
        for j in range(6):
            j = j + 2
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    
    for j in range(3):
        j = j + 13
        sheet.write_merge(31, 31, j, j, u"",style_boeder)

    for i in range(4):
        i = i + 23
        sheet.write_merge(i, i, 2, 3, u"",style_boeder)

    for i in range(4):
        i = i + 23
        for j in range(2):
            j = j + 4
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    for i in range(4):
        i = i + 23
        sheet.write_merge(i, i, 6, 9, u"",style_boeder)
    for i in range(4):
        i = i + 23
        sheet.write_merge(i, i, 10, 15, u"",style_boeder)

    sheet.write_merge(31, 31, 2, 3, u"",style_boeder)

    for i in range(6):
        i = i + 2
        sheet.write_merge(40, 40, i, i, u"",style_boeder)

    for i in range(2):
        i = i + 35
        for j in range(6):
            j = j + 2
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    sheet.write_merge(35, 35, 15, 15, u"",style_boeder)

    for i in range(6):
        i = i + 10
        sheet.write_merge(36, 36, i, i, u"",style_boeder)

    for i in range(6):
        i = i + 10
        sheet.write_merge(20, 20, i, i, u"",style_boeder)
    sheet.write_merge(19, 19, 15, 15, u"",style_boeder)

    for i in range(3):
        i = i + 13
        sheet.write_merge(39, 39, i, i, u"",style_boeder)

    for i in range(6):
        i = i + 10
        sheet.write_merge(40, 40, i, i, u"",style_boeder)

    for i in range(3):
        i = i + 13
        sheet.write_merge(44, 44, i, i, u"",style_boeder)

    for i in range(13):
        i = i + 48
        for j in range(10):
            j = j + 3
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    for i in range(13):
        i = i + 48
        for j in range(2):
            j = j + 14
            sheet.write_merge(i, i, j, j, u"",style_boeder)

    for i in range(15):
        i = i + 1
        sheet.write_merge(65, 65, i, i, u"",style_boeder)

    sheet.write_merge(66, 66, 2, 3, u"",style_boeder)
    sheet.write_merge(66, 66, 5, 6, u"",style_boeder)
    sheet.write_merge(66, 66, 9, 10, u"",style_boeder)

    for i in range(5):
        i = i + 11
        sheet.write_merge(66, 66, i, i, u"",style_boeder)


def __data(sheet):
    style_right = xlwt.easyxf("""
        align: 
            wrap on, 
            vert center, 
            horiz right;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """)
    statistical_time = time.strftime("%Y-%m-%d")
    sheet.write_merge(1, 1, 0, 15, unicode("统计时间："+statistical_time),style_right)
    
    
def __getNowNumber():

    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_zong = '''
            select count(*) count from employee where status in(1,4,5)
        '''
        cursor_employee.execute(sql_select_zong)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getLizhiNumberPutong():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_putong = '''
            select count(*) count from resign_application 
            where emp_no not in (select parent_no from employee)
        '''
        cursor_employee.execute(sql_select_putong)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getLizhiNumberGuanLi():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_putong = '''
            select count(*) count from resign_application 
            where emp_no in (select parent_no from employee)
        '''
        cursor_employee.execute(sql_select_putong)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getNowNumberPuTong():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_guanli = '''
            select count(*) count from employee where `status` in(1,4,5) 
            and id not in(select parent_no from employee)
        '''
        cursor_employee.execute(sql_select_guanli)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getNowNumberByAge(age):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        year = time.strftime("%Y");
        sql_select = '''
            select count(*) count from employee_information where %s
        '''%age
        cursor_employee.execute(sql_select)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()

def __getNowNumberGuanLi():

    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_guanli = '''
            select count(*) count from employee where `status` in(1,4,5) 
            and id in(select parent_no from employee)
        '''
        cursor_employee.execute(sql_select_guanli)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getNowNumberByDepts(dept_nos):

    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_dept = '''
            select count(*) count from employee where status in(1,4,5) and dept_no in (%s)
        '''%dept_nos
        cursor_employee.execute(sql_select_dept)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getLiZhiNumberByDepts(dept_nos):

    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_dept = '''
            select count(*) count from resign_application where dept_no in (%s)
        '''%dept_nos
        cursor_employee.execute(sql_select_dept)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getNowNumberBySex(sex):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_sex = '''
            select count(*) count from employee e
            where e.status in(1,4,5) and e.sex = %s
        '''%sex
        cursor_employee.execute(sql_select_sex)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()

def __getLizhiNumberByXueLi(degree):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select = '''
            select count(*) count from resign_application r LEFT OUTER JOIN (employee e LEFT OUTER JOIN
            employee_detail d on e.id = d.emp_no) on r.emp_no = e.id
            where d.highest_degree = %s
        '''%degree
        cursor_employee.execute(sql_select)
        nums = cursor_employee.fetchall()
        for num in nums:
            number =  num['count']
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getNowNumberByXueLi(degree):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_xueli = '''
            select count(*) count from employee e LEFT OUTER JOIN employee_detail d
            on e.id = d.emp_no
            where e.status in(1,4,5) and d.highest_degree = %s
        '''%degree
        cursor_employee.execute(sql_select_xueli)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        
        return number
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getRuZhiNumberByDeptNo(dept_no):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select = '''
            select count(*) count from employee e LEFT OUTER JOIN employee_detail d 
            on e.id = d.emp_no where e.`status` = 1
            and e.dept_no in (%s)
            and  DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= date(d.start_time)
        '''%dept_no
        cursor_employee.execute(sql_select)
        employees = cursor_employee.fetchall();
        for employee in employees:
            count = employee['count']
        return count
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
def __getLizhiNumberByDeptNo(dept_no):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select = '''
            select count(*) count from resign_application 
            where  DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= date(leave_time)
            and dept_no in (%s) 
        '''%dept_no
        cursor_employee.execute(sql_select)
        employees = cursor_employee.fetchall();
        for employee in employees:
            count = employee['count']
        return count
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()

def __getAvgAge():
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_age = '''
            select avg(birthday_year) age from employee_information 
        '''
        cursor_employee.execute(sql_select_age)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['age']
        
        return number 
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
        
def __getNowNumberByDeptNo(dept_no):
    try:
        cnn_employee = mysql_conn.get_conn(db_config.config_employee)
        if cnn_employee == None:
            __write_warn("Can't get connection of notify","__process_mails")
            return
        cursor_employee = cnn_employee.cursor(dictionary=True)
        sql_select_zaizhi = '''
            select count(*) count from employee where status in (1,4,5) and dept_no = %s
        '''%dept_no
        cursor_employee.execute(sql_select_zaizhi)
        nums = cursor_employee.fetchall()
        for num in nums:
            number = num['count']
        
        return number 
    except Exception, e:
        print (e)
        return False
    finally:
        cursor_employee.close()
        cnn_employee.close()
        
def createXLSTitle(sheet):
    style_yellow = xlwt.easyxf("""
            pattern: 
                pattern solid, 
                fore_color 13;
            font: 
                name Arial, 
                colour_index 0,
                bold on;
            borders:
                left 1,
                right 1,
                top 1,
                bottom 1,
                bottom_colour 0x3A;
            """) 
    style_gray = xlwt.easyxf("""
        pattern: 
            pattern solid, 
            fore_color 22;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """) 
    style_heading = xlwt.easyxf("""
        font: 
            name Arial, 
            colour_index 0,
            bold on;
        align: 
            wrap on, 
            vert center, 
            horiz center;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """)
    style_center = xlwt.easyxf("""
        align: 
            wrap on, 
            vert center, 
            horiz center;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """)
    
    style_font_color = xlwt.easyxf("""
        font: 
            name Arial, 
            colour_index 12;
        borders:
            left 1,
            right 1,
            top 1,
            bottom 1,
            bottom_colour 0x3A;
        """)

    sheet.write_merge(0, 0, 0, 15, u"2015年3月人力资源统计月报表",style_heading)
    sheet.write_merge(2, 2, 0, 15, u"人力资源异动",style_yellow)
    sheet.write_merge(3, 16, 0, 0, u"人力资源异动分析",style_center)
    sheet.write_merge(3, 4, 1, 1,u"部门",style_center)
    sheet.write_merge(3, 4, 2, 2,u"编制人数",style_center)
    sheet.write_merge(3, 4, 3, 3,u"月初人数",style_center)
    sheet.write_merge(3, 4, 4, 4,u"入职人数",style_center)
    
    sheet.write_merge(3, 3, 11, 14,u"本月异动",style_center)
    sheet.write_merge(4, 4, 5, 5,u"辞职",style_center)
    sheet.write_merge(4, 4, 6, 6,u"辞退",style_center)
    sheet.write_merge(4, 4, 7, 7,u"自离",style_center)
    sheet.write_merge(4, 4, 8, 8,u"开除",style_center)
    sheet.write_merge(4, 4, 9, 9,u"其他",style_center)
    sheet.write_merge(4, 4, 10, 10,u"离职率",style_center)
    sheet.write_merge(4, 4, 11, 11,u"调入",style_center)
    sheet.write_merge(4, 4, 12, 12,u"调出",style_center)
    sheet.write_merge(4, 4, 13, 13,u"晋升",style_center)
    sheet.write_merge(4, 4, 14, 14,u"换岗",style_center)
    sheet.write_merge(3, 4, 15, 15,u"月末人数",style_center)
    sheet.write_merge(5, 5, 1, 1,u"人事行政部",style_center)
    sheet.write_merge(6, 6, 1, 1,u"财富管理中心",style_center)
    sheet.write_merge(7, 7, 1, 1,u"产品部",style_center)
    sheet.write_merge(8, 8, 1, 1,u"运营管理部",style_center)
    sheet.write_merge(9, 9, 1, 1,u"风控法务部",style_center)
    sheet.write_merge(10, 10, 1, 1,u"IT网络部",style_center)
    sheet.write_merge(11, 11, 1, 1,u"财务部",style_center)
    sheet.write_merge(12, 12, 1, 1,u"新金融事业部",style_center)
    sheet.write_merge(13, 13, 1, 1,u"公募基金事业部",style_center)
    sheet.write_merge(14, 14, 1, 1,u"市场部",style_center)
    allNow = 0
    allRuzhi = 0
    allLizhi = 0
    allEnd = 0
    for i in range(10):
        a = int(i+5)
        if a == 5:
            dept_no = 2
        if a == 6:
            dept_no = "5,10,11"
        if a == 7:
            dept_no = 6
        if a == 8:
            dept_no = 4
        if a == 9:
            dept_no = 9
        if a == 10:
            dept_no = 8
        if a == 11:
            dept_no = 3
        if a == 12:
            dept_no = "13,14,15,16,17,18,19"
        if a == 13:
            dept_no = 30
        if a == 14:
            dept_no = 7
        nowNumber = int(__getNowNumberByDeptNo(dept_no))
        lizhiNumber = int(__getLizhiNumberByDeptNo(dept_no))
        ruzhiNumber = int(__getRuZhiNumberByDeptNo(dept_no))

        number = nowNumber+lizhiNumber-ruzhiNumber
        allNow = allNow + number
        allRuzhi = allRuzhi + ruzhiNumber
        allEnd = allEnd + nowNumber
        allLizhi = allLizhi + lizhiNumber
        sheet.write_merge(a, a, 3, 3,unicode(number),style_center)
        sheet.write_merge(a, a, 4, 4,unicode(ruzhiNumber),style_center)
        sheet.write_merge(a, a, 15, 15,unicode(nowNumber),style_center)

    sheet.write_merge(3, 3, 5, 10,unicode("本月离职"+str(allLizhi)+"人") ,style_center)
    sheet.write_merge(15, 15, 3, 3,unicode(allNow),style_center)
    sheet.write_merge(15, 15, 4, 4,unicode(allRuzhi),style_center)
    sheet.write_merge(15, 15, 15, 15,unicode(allEnd),style_center)
    sheet.write_merge(15, 15, 1, 1,u"合计",style_center)

    sheet.write_merge(16, 16, 1, 15,u"公式：离职率 = 当月离职人数/当月平均人数*100%   \
        月末人数 = 月初人数+入职人数-离职人数+调入人数-调出人数",style_font_color)
    #13
    sheet.write_merge(17, 17, 0, 15,u"离职人员",style_yellow)
    sheet.write_merge(18, 32, 0, 0,u"离职人员分析",style_center)
    sheet.write_merge(18, 20, 1, 1,u"工龄分析",style_center)
    sheet.write_merge(18, 18, 2, 2,u"1-3月",style_center)
    sheet.write_merge(18, 18, 3, 3,u"3-6月",style_center)
    sheet.write_merge(18, 18, 4, 4,u"6-12月",style_center)
    sheet.write_merge(18, 18, 5, 5,u"1-2年",style_center)
    sheet.write_merge(18, 18, 6, 6,u"2-3年",style_center)
    sheet.write_merge(18, 18, 7, 7,u"3年以上",style_center)

    sheet.write_merge(18, 20, 8, 9,u"受教育结构分析",style_center)
    sheet.write_merge(18, 18, 10, 10,u"初中及以下",style_center)
    sheet.write_merge(18, 18, 11, 11,u"高中/中专",style_center)
    sheet.write_merge(18, 18, 12, 12,u"大专",style_center)
    sheet.write_merge(18, 18, 13, 13,u"本科",style_center)
    sheet.write_merge(18, 18, 14, 14,u"硕士",style_center)
    sheet.write_merge(18, 18, 15, 15,u"...",style_center)
    sheet.write_merge(21, 21, 1, 15,u"",style_gray)

    for i in range(4):
        a = int(i+1)
        sheet.write_merge(19, 19, 11+i, 11+i,unicode(__getLizhiNumberByXueLi(a)),style_center)


    #17
    sheet.write_merge(22, 27, 1, 1,u"重点岗位离职分析",style_center)
    sheet.write_merge(22, 22, 2, 3,u"岗位",style_center)
    sheet.write_merge(22, 22, 4, 4,u"离职人数",style_center)
    sheet.write_merge(22, 22, 5, 5,u"所占比率",style_center)
    sheet.write_merge(22, 22, 6, 9,u"离职原因分析",style_center)
    sheet.write_merge(22, 22, 10, 15,u"主要改善措施",style_center)
    sheet.write_merge(27, 27, 2, 15,u"公式：岗位离职人员所占比率 = 该岗位离职人数/当月离职总人数*100%",style_font_color)
    #24
    sheet.write_merge(28, 28, 1, 15,u"",style_gray)
    sheet.write_merge(29, 32, 1, 1,u"离职人员属性分析",style_center)
    sheet.write_merge(29, 30, 2, 3,u"总离职人数",style_center)
    sheet.write_merge(29, 29, 4, 5,u"前台",style_center)
    sheet.write_merge(29, 29, 6, 7,u"中台",style_center)
    sheet.write_merge(29, 29, 8, 9,u"后台",style_center)
    sheet.write_merge(29, 29, 10, 11,u"管理人员",style_center)
    sheet.write_merge(29, 29, 12, 13,u"普通员工",style_center)
    sheet.write_merge(29, 29, 14, 14,u"...",style_center)
    sheet.write_merge(29, 29, 15, 15,u"...",style_center)

    sheet.write_merge(30, 30, 4, 4,u"离职人数",style_center)
    sheet.write_merge(31, 31, 4, 4,unicode(__getLiZhiNumberByDepts(str("1,5,13,10,11,14,15,16,17,18,19,20"))),style_center)
    sheet.write_merge(30, 30, 5, 5,u"占离职人数比",style_center)
    sheet.write_merge(30, 30, 6, 6,u"离职人数",style_center)
    sheet.write_merge(31, 31, 6, 6,unicode(__getLiZhiNumberByDepts(str("4,6,7"))),style_center)
    sheet.write_merge(30, 30, 7, 7,u"占离职人数比",style_center)
    sheet.write_merge(30, 30, 8, 8,u"离职人数",style_center)
    sheet.write_merge(31, 31, 8, 8,unicode(__getLiZhiNumberByDepts(str("2,3,8,9"))),style_center)
    sheet.write_merge(30, 30, 9, 9,u"占离职人数比",style_center)
    sheet.write_merge(30, 30, 10, 10,u"离职人数",style_center)
    
    sheet.write_merge(31, 31, 10, 10,unicode(__getLizhiNumberGuanLi()),style_center)
   
    sheet.write_merge(30, 30, 11, 11,u"占离职人数比",style_center)
    sheet.write_merge(30, 30, 12, 12,u"离职人数",style_center)
    sheet.write_merge(31, 31, 12, 12,unicode(__getLizhiNumberPutong()),style_center)
    sheet.write_merge(30, 30, 13, 13,u"占离职人数比",style_center)
    sheet.write_merge(30, 30, 14, 14,u"...",style_center)
    sheet.write_merge(30, 30, 15, 15,u"...",style_center)
    sheet.write_merge(32, 32, 2, 15,u"前台：销售及销售管理人员   中台：产品，市场，运营   后台：行政，人事，财务，技术，法务\
        管理类：所有主管级及以上人员（含基层管理）  普通员工：非管理岗位员工",style_font_color)
    
    sheet.write_merge(33, 33, 0, 15,u"在职人员分析",style_yellow)
    sheet.write_merge(34, 45, 0, 0,u"在职人员分析",style_center)
    sheet.write_merge(34, 36, 1, 1,u"工龄分析",style_center)
    sheet.write_merge(34, 34, 2, 2,u"1-3月",style_center)
    sheet.write_merge(34, 34, 3, 3,u"3-6月",style_center)
    sheet.write_merge(34, 34, 4, 4,u"6-12月",style_center)
    sheet.write_merge(34, 34, 5, 5,u"1-2年",style_center)
    sheet.write_merge(34, 34, 6, 6,u"2-3年",style_center)
    sheet.write_merge(34, 34, 7, 7,u"3年以上",style_center)

    sheet.write_merge(34, 36, 8, 9,u"受教育结构分析",style_center)
    sheet.write_merge(34, 34, 10, 10,u"初中及以下",style_center)
    sheet.write_merge(34, 34, 11, 11,u"高中/中专",style_center)
    sheet.write_merge(34, 34, 12, 12,u"大专",style_center)
    sheet.write_merge(34, 34, 13, 13,u"本科",style_center)
    sheet.write_merge(34, 34, 14, 14,u"硕士",style_center)
    sheet.write_merge(34, 34, 15, 15,u"...",style_center)
    for i in range(4):
        a = int(i+1)
        sheet.write_merge(35, 35, 11+i, 11+i,unicode(__getNowNumberByXueLi(a)),style_center)

    sheet.write_merge(37, 37, 1, 15,u"",style_gray)
    sheet.write_merge(38, 40, 1, 1,u"年龄结构分析",style_center)
    sheet.write_merge(38, 38, 2, 2,u"20岁以下",style_center)
    year = str(time.strftime("%Y"))
    sheet.write_merge(39, 39, 2, 2,unicode(__getNowNumberByAge("("+year +"- birthday_year) < 20")),style_center)

    sheet.write_merge(38, 38, 3, 3,u"20-30",style_center)
    sheet.write_merge(39, 39, 3, 3,unicode(__getNowNumberByAge("("+year +"- birthday_year) >= 20 and ("+year +"- birthday_year) < 30")),style_center)
    sheet.write_merge(38, 38, 4, 4,u"30-40",style_center)
    sheet.write_merge(39, 39, 4, 4,unicode(__getNowNumberByAge("("+year +"- birthday_year) >= 30 and ("+year +"- birthday_year) < 40")),style_center)
    sheet.write_merge(38, 38, 5, 5,u"40-50",style_center)
    sheet.write_merge(39, 39, 5, 5,unicode(__getNowNumberByAge("("+year +"- birthday_year) >= 40 and ("+year +"- birthday_year) < 50")),style_center)
    sheet.write_merge(38, 38, 6, 6,u"50岁以上",style_center)
    sheet.write_merge(39, 39, 6, 6,unicode(__getNowNumberByAge("("+year +"- birthday_year) >= 50")),style_center)
    sheet.write_merge(38, 38, 7, 7,u"平均年龄",style_center)
    sheet.write_merge(39, 39, 7, 7,unicode(__getAvgAge()),style_center)

    sheet.write_merge(38, 40, 8, 9,u"性别分析",style_center)
    sheet.write_merge(38, 38, 10, 10,u"总人数",style_center)
    sheet.write_merge(38, 38, 11, 11,u"男",style_center)
    sheet.write_merge(38, 38, 12, 12,u"女",style_center)
    sheet.write_merge(38, 38, 13, 13,u"...",style_center)
    sheet.write_merge(38, 38, 14, 14,u"...",style_center)
    sheet.write_merge(38, 38, 15, 15,u"...",style_center)
    
    for i in range(2):
        a = int(i+1)
        sheet.write_merge(39, 39, 11+i, 11+i,unicode(__getNowNumberBySex(a)),style_center)

    zong = __getNowNumber()
    sheet.write_merge(39, 39, 10, 10,unicode(zong),style_center)
    sheet.write_merge(41, 41, 1, 15,u"",style_center)
    sheet.write_merge(42, 45, 1, 1,u"在职人员属性分析",style_center)
    sheet.write_merge(42, 43, 2, 3,u"月末人数",style_center)

    sheet.write_merge(44, 44, 2, 3,unicode(zong),style_center)
    sheet.write_merge(42, 42, 4, 5,u"前台",style_center)
    sheet.write_merge(42, 42, 6, 7,u"中台",style_center)
    sheet.write_merge(42, 42, 8, 9,u"后台",style_center)
    sheet.write_merge(42, 42, 10, 11,u"管理人员",style_center)
    sheet.write_merge(42, 42, 12, 13,u"普通员工",style_center)
    sheet.write_merge(42, 42, 14, 14,u"...",style_center)
    sheet.write_merge(42, 42, 15, 15,u"...",style_center)

    sheet.write_merge(43, 43, 4, 4,u"在职人数",style_center)
    sheet.write_merge(44, 44, 4, 4,unicode(__getNowNumberByDepts(str("1,5,13,10,11,14,15,16,17,18,19,20"))),style_center)
    sheet.write_merge(43, 43, 5, 5,u"占在职人数比",style_center)
    sheet.write_merge(43, 43, 6, 6,u"在职人数",style_center)
    sheet.write_merge(44, 44, 6, 6,unicode(__getNowNumberByDepts(str("4,6,7"))),style_center)
    sheet.write_merge(43, 43, 7, 7,u"占在职人数比",style_center)
    sheet.write_merge(43, 43, 8, 8,u"在职人数",style_center)
    sheet.write_merge(44, 44, 8, 8,unicode(__getNowNumberByDepts(str("2,3,8,9"))),style_center)
    sheet.write_merge(43, 43, 9, 9,u"占在职人数比",style_center)
    sheet.write_merge(43, 43, 10, 10,u"在职人数",style_center)
    guanli = __getNowNumberGuanLi()
    sheet.write_merge(44, 44, 10, 10,unicode(guanli),style_center)
    sheet.write_merge(43, 43, 11, 11,u"占在职人数比",style_center)
    sheet.write_merge(43, 43, 12, 12,u"在职人数",style_center)
    putong = __getNowNumberPuTong()
    sheet.write_merge(44, 44, 12, 12,unicode(putong),style_center)
    sheet.write_merge(43, 43, 13, 13,u"占在职人数比",style_center)
    sheet.write_merge(43, 43, 14, 14,u"...",style_center)
    sheet.write_merge(43, 43, 15, 15,u"...",style_center)
    sheet.write_merge(45, 45, 2, 15,u"前台：销售及销售管理人员   中台：产品，市场，运营   后台：行政，人事，财务，技术，法务\
        管理类：所有主管级及以上人员（含基层管理）  普通员工：非管理岗位员工",style_font_color)

    sheet.write_merge(46, 46, 0, 15,u"招聘分析（常招/急招岗位）",style_yellow)
    sheet.write_merge(47, 61, 0, 0,u"招聘分析（常招/急招岗位）",style_center)
    sheet.write_merge(47, 47, 1, 1,u"部门",style_center)
    sheet.write_merge(47, 47, 2, 2,u"职位",style_center)
    sheet.write_merge(47, 47, 3, 3,u"缺编人数",style_center)
    sheet.write_merge(47, 47, 4, 4,u"月初人数",style_center)
    sheet.write_merge(47, 47, 5, 5,u"本月计划人数",style_center)
    sheet.write_merge(47, 47, 6, 6,u"合格简历数",style_center)
    sheet.write_merge(47, 47, 7, 7,u"通知人数",style_center)
    sheet.write_merge(47, 47, 8, 8,u"出席人数",style_center)
    sheet.write_merge(47, 47, 9, 9,u"初试合格人数",style_center)
    sheet.write_merge(47, 47, 10, 10,u"offer人数",style_center)
    sheet.write_merge(47, 47, 11, 11,u"入职人数",style_center)
    sheet.write_merge(47, 47, 12, 12,u"月末人数",style_center)
    sheet.write_merge(47, 60, 13, 13,u"招聘效果分析",style_center)
    sheet.write_merge(47, 47, 14, 14,u"招聘有效率",style_center)
    sheet.write_merge(47, 47, 15, 15,u"招聘达成率",style_center)

    sheet.write_merge(48, 50, 1, 1,u"人事行政部",style_center)
    sheet.write_merge(51, 52, 1, 1,u"财富管理中心-直销部",style_center)
    sheet.write_merge(53, 53, 1, 1,u"财富管理中心-机构业务部",style_center)
    sheet.write_merge(54, 55, 1, 1,u"新金融事业部",style_center)
    sheet.write_merge(56, 57, 1, 1,u"产品部",style_center)
    sheet.write_merge(58, 60, 1, 1,u"IT网络部",style_center)

    sheet.write_merge(48, 48, 2, 2,u"招聘专员/主管",style_center)
    sheet.write_merge(49, 49, 2, 2,u"人事专员",style_center)
    sheet.write_merge(50, 50, 2, 2,u"培训经理",style_center)
    sheet.write_merge(51, 51, 2, 2,u"业务总监/理财总监/理财经理",style_center)
    sheet.write_merge(52, 52, 2, 2,u"部门总经理",style_center)
    sheet.write_merge(53, 53, 2, 2,u"渠道经理",style_center)
    sheet.write_merge(54, 54, 2, 2,u"客户经理/理财经理",style_center)
    sheet.write_merge(55, 55, 2, 2,u"店长",style_center)
    sheet.write_merge(56, 56, 2, 2,u"产品总监",style_center)
    sheet.write_merge(57, 57, 2, 2,u"产品经理",style_center)
    sheet.write_merge(58, 58, 2, 2,u"java开发工程师",style_center)
    sheet.write_merge(59, 59, 2, 2,u"互联网产品经理",style_center)
    sheet.write_merge(60, 60, 2, 2,u"运维工程师",style_center)
    sheet.write_merge(61, 61, 1, 15,u"公式：招聘有效率 = offer人数/通知人数*100%   招聘达成率 = 入职人数/本月计划人数*100%",style_font_color)

    sheet.write_merge(62, 62, 0, 15,u"人力资源成本分析",style_yellow)
    sheet.write_merge(63, 66, 0, 0,u"人力资源成本分析",style_center)

    sheet.write_merge(63, 63, 1, 4,u"工资支出",style_center)
    sheet.write_merge(63, 63, 5, 8,u"奖金福利支出",style_center)
    sheet.write_merge(63, 63, 9, 12,u"培训支出",style_center)
    sheet.write_merge(63, 63, 13, 15,u"招聘支出",style_center)

    sheet.write_merge(64, 64, 1, 1,u"总额（应发）",style_center)
    sheet.write_merge(64, 64, 2, 2,u"人数",style_center)
    sheet.write_merge(64, 64, 3, 3,u"人均月工资",style_center)
    sheet.write_merge(64, 64, 4, 4,u"与上月相比（增减金额）",style_center)
    sheet.write_merge(64, 64, 5, 5,u"总额",style_center)
    sheet.write_merge(64, 64, 6, 6,u"人数",style_center)
    sheet.write_merge(64, 64, 7, 7,u"人均成本",style_center)
    sheet.write_merge(64, 64, 8, 8,u"与上月相比（增减金额）",style_center)
    sheet.write_merge(64, 64, 9, 9,u"总额",style_center)
    sheet.write_merge(64, 64, 10, 10,u"人数",style_center)
    sheet.write_merge(64, 64, 11, 11,u"人均成本",style_center)
    sheet.write_merge(64, 64, 12, 12,u"与上月相比（增减金额）",style_center)
    sheet.write_merge(64, 64, 13, 13,u"总额",style_center)
    sheet.write_merge(64, 64, 14, 14,u"人数",style_center)
    sheet.write_merge(64, 64, 15, 15,u"人均成本",style_center)

    sheet.write_merge(66, 66, 1, 1,u"总支出",style_center)
    sheet.write_merge(66, 66, 4, 4,u"人数",style_center)
    sheet.write_merge(66, 66, 7, 8,u"人均成本",style_center)


if __name__ == '__main__':
    __main()
    __select_transaction()
    
    



