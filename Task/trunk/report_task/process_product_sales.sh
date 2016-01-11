#!/bin/sh
############################
# @file process_product_sales.sh
# @generate report
# @change product status
# @calculate amount
# @author Guo Zhen Yu
# @version 1.0
# @date 2015-2-28
echo ""
############################
echo "####################################"
echo "####generate report####"
echo `date '+%Y-%m-%d %H:%M:%S'`"---start"
python /home/shell/report_generator.py 
echo `date '+%Y-%m-%d %H:%M:%S'`"---end"
echo "####################################"
echo " "
echo "####################################"
echo "####change product status####"
echo `date '+%Y-%m-%d %H:%M:%S'`"---start"
python /home/shell/product_status_changer.py 
echo `date '+%Y-%m-%d %H:%M:%S'`"---end"
echo "####################################"
echo "####################################"
echo "####calculate amount####"
echo `date '+%Y-%m-%d %H:%M:%S'`"---start"
python /home/shell/amount_calculator.py 
echo `date '+%Y-%m-%d %H:%M:%S'`"---end"
echo "####################################"
echo "####################################"
echo "####calculate amount####"
echo `date '+%Y-%m-%d %H:%M:%S'`"---start"
python /home/shell/insert_subsidy.py
echo `date '+%Y-%m-%d %H:%M:%S'`"---end"
echo "####################################"
exit 0;