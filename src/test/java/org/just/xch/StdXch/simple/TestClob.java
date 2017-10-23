package org.just.xch.stdxch.simple;

import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.Near;
import org.springframework.util.StringUtils;

public class TestClob {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		
//		String  teString="许1";
//		System.out.println(teString.getBytes("GBK").length);
//		System.out.println(false||false&&true);
//		System.out.println(false||false&&false);
//		System.out.println(false||true&&true);
//		System.out.println(false||true&&true);
//		
//		System.out.println(false||(false&&true));
//		System.out.println(false||(false&&false));
//		System.out.println(false||(true&&true));
//		System.out.println(false||(true&&false));
//		
//		
//		System.out.println("abc12i3o4".compareTo("abc"));
		
		
		List<String> sortFields =new ArrayList();
		sortFields.add("a");
		sortFields.add("b");
		sortFields.add("c");
		sortFields.add("d");
		
		Map<String, String> o1 =new HashMap<String, String>(10);
		o1.put("a", "ab");
		o1.put("b", "ab");
		o1.put("c", "ab");
		o1.put("d", "ab");
		
		Map<String, String> o2=new HashMap<String, String>(10);
		
		o2.put("a", "ab");
		//o2.put("b", "ab");
		o2.put("c", "ab");
		o2.put("d", "ab");
		
		System.out.println(strCompare(sortFields,o1,o2));
		
	}
	
	
	
	private static int strCompare(List<String> sortFields, Map<String, String> o1,Map<String, String> o2){
		for (String field : sortFields) {
			if (StringUtils.isEmpty(o1.get(field)) || StringUtils.isEmpty(o2.get(field))) {
				if (StringUtils.isEmpty(o1.get(field)) && StringUtils.isEmpty(o2.get(field))) {
					if (sortFields.size() == 1) {
	    				return 0;
	    			}
	    			sortFields.remove(field);
	    			return strCompare(sortFields, o1, o2);
				}
				if (StringUtils.isEmpty(o1.get(field)) && !StringUtils.isEmpty(o2.get(field))) {
					return -1;
				}
				if (StringUtils.isEmpty(o2.get(field)) && !StringUtils.isEmpty(o1.get(field))) {
					return 1;
				}
			} else {
	    		if (o1.get(field).compareTo(o2.get(field)) > 0) {
	    			return 1;
	    		}
	    		if (o1.get(field).compareTo(o2.get(field)) < 0) {
	    			return -1;
	    		}
	    		if (o1.get(field).compareTo(o2.get(field)) == 0) {
	    			if (sortFields.size() == 1) {
	    				return 0;
	    			}
	    			sortFields.remove(field);
	    			return strCompare(sortFields, o1, o2);
	    		}
			}
    	}
		return 0;
	}

	
	
   


}
