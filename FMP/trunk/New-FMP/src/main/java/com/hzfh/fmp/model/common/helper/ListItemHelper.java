package com.hzfh.fmp.model.common.helper;

import com.hzfh.fmp.model.common.view.ListItem;
import com.hzframework.contract.BaseEntity;
import com.hzframework.helper.StringHelper;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListItemHelper {
	/**
	 * 格式化TtemList方法
	 * 
	 * */
	 public static  <T extends BaseEntity> List<ListItem> getListItemList(String textName, String valueName, List<T> tList) {
	        List<ListItem> itemList = new ArrayList<ListItem>();
	        try {
	            if (tList != null && tList.size() > 0) {
	                for (T t : tList) {
	                    Object[] objects = new Object[]{};
	                    String text = String.valueOf(t.getClass().getMethod("get" + StringHelper.initialToUpperName(textName)).invoke(t, objects));
	                    String value = String.valueOf(t.getClass().getMethod("get" + StringHelper.initialToUpperName(valueName)).invoke(t, objects));
	                    itemList.add(new ListItem(text, value));
	                }
	            }
	        } catch (NoSuchMethodException e) {
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } 
	        return itemList;
	    }

    public static  <T extends BaseEntity> List<ListItem> getListItemListA(String textName1,String textName2,String textName3, String valueName, List<T> tList) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        try {
            if (tList != null && tList.size() > 0) {
                for (T t : tList) {
                    Object[] objects = new Object[]{};
                    String text1 = String.valueOf(t.getClass(). getMethod("get" + StringHelper.initialToUpperName(textName1)).invoke(t, objects));
                    String text2 = String.valueOf(t.getClass(). getMethod("get" + StringHelper.initialToUpperName(textName2)).invoke(t, objects));
                    String text3 = String.valueOf(t.getClass(). getMethod("get" + StringHelper.initialToUpperName(textName3)).invoke(t, objects));
                    String value = String.valueOf(t.getClass().getMethod("get" + StringHelper.initialToUpperName(valueName)).invoke(t, objects));
                    itemList.add(new ListItem(text1+text2+"(余"+text3+"元)", value));
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return itemList;
    }
    public static  <T extends BaseEntity> List<ListItem> getListItemListP2pProduct(String textName1,String textName2, String valueName, List<T> tList) throws Exception{
        List<ListItem> itemList = new ArrayList<ListItem>();
        try {
            if (tList != null && tList.size() > 0) {
                for (T t : tList) {
                    Object[] objects = new Object[]{};
                    String text1 = String.valueOf(t.getClass(). getMethod("get" + StringHelper.initialToUpperName(textName1)).invoke(t, objects));
                    String text2 = String.valueOf(t.getClass(). getMethod("get" + StringHelper.initialToUpperName(textName2)).invoke(t, objects));
                    SimpleDateFormat sfStart = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",java.util.Locale.ENGLISH) ;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String value = String.valueOf(t.getClass().getMethod("get" + StringHelper.initialToUpperName(valueName)).invoke(t, objects));
                    if(text2=="null"||text2==""||text2==null){
                        itemList.add(new ListItem(text1, value));
                    }else{
                        itemList.add(new ListItem(text1+"——到期日期："+sdf.format(sfStart.parse(text2))+"", value));
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return itemList;
    }
	 public static <T extends BaseEntity> List<ListItem> getListItemListForTree(
				String idt, String pidt, String namet,String parentNot,String typet, List<T> tList) {
			List<ListItem> itemList = new ArrayList<ListItem>();
			try {
				if (tList != null && tList.size() > 0) {
					for (T t : tList) {
						Object[] objects = new Object[] {};
						String id = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(idt)).invoke(t, objects));
						String pid = "0";
						if (!StringHelper.isNullOrEmpty(pidt)) {
							pid = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(pidt)).invoke(t, objects));
						}
						String name = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(namet)).invoke(t, objects));
						if(StringHelper.isNullOrEmpty(parentNot)){
							if(StringHelper.isNullOrEmpty(typet))
								itemList.add(new ListItem(id, pid, name));
							else{
								String type = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(typet)).invoke(t, objects));
								itemList.add(new ListItem(id, pid, name,null,type));
							}
						}
						else{
							String parentNo = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(parentNot)).invoke(t, objects));
							if(StringHelper.isNullOrEmpty(typet))
								itemList.add(new ListItem(id, pid, name,parentNo,null));
							else{
								String type = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(typet)).invoke(t, objects));
								itemList.add(new ListItem(id, pid, name,parentNo,type));
							}
							
						}
					}
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return itemList;
		}
	 
	 
	 
	 
}
