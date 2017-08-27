package org.just.xch.StdXch.simple;

import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClob {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		
		String  teString="许1";
		System.out.println(teString.getBytes("GBK").length);
		System.out.println(false||false&&true);
		System.out.println(false||false&&false);
		System.out.println(false||true&&true);
		System.out.println(false||true&&true);
		
		System.out.println(false||(false&&true));
		System.out.println(false||(false&&false));
		System.out.println(false||(true&&true));
		System.out.println(false||(true&&false));
	}

}
