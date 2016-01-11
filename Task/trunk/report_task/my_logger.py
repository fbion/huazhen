#encoding: utf-8
#!/usr/bin/python

import time
import logging
import os
import sys
from enum import enum

__LOG_TYPE = enum(INFO='Info', WARN='Warning', ERR='Error')

def __write_log(content,log_type, module,func):
    cur_time = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
    template="""
=========================================
%s %s:%s--%s
%s
=========================================

"""
    logger=logging.getLogger()  
    filename = time.strftime('%Y-%m-%d',time.localtime(time.time()))  
    
    abs_path=os.path.abspath(sys.argv[0])

    abs_path=os.path.dirname(abs_path)

    handler=logging.FileHandler("%s/log/%s_%s_%s.log"%(abs_path,module,filename,log_type))  
    logger.addHandler(handler)  
    logger.setLevel(logging.NOTSET)  
    logger.info(template%(cur_time,log_type,module,func,content))  
    print(template%(cur_time,log_type,module,func,content))

def write_err(content,module,func):
    __write_log(content,__LOG_TYPE.ERR,module,func)

def write_info(content,module,func):
    __write_log(content,__LOG_TYPE.INFO,module,func)

def write_warn(content,module,func):
    __write_log(content,__LOG_TYPE.WARN,module,func)
