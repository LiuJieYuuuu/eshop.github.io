package com.yimai.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderID {
	public static String getOrderIdByUUId() {
		 	Date date=new Date();
	        DateFormat format = new SimpleDateFormat("yyMMdd");
	        String time = format.format(date);
	        int hashCodeV = UUID.randomUUID().toString().hashCode();
	        if (hashCodeV < 0) {//有可能是负数
	            hashCodeV = -hashCodeV;
	        }
	        // 0 代表前面补充0
	        // 4 代表长度为4
	        // d 代表参数为正数型
	        return time + String.format("%011d", hashCodeV);
	}
	
	public static String getOrderDetailIdByUUId() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return String.format("%011d", hashCodeV);
	}
}
