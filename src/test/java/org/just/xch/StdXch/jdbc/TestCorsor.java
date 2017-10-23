package org.just.xch.stdxch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestCorsor {

	public static void main(String[] args) {
		
//		BlockingQueue<Map<String,Object>> queue=new LinkedBlockingQueue<Map<String,Object>> ();
//		ClinicalDataFactory factory=new ClinicalDataFactory(queue);
//		ClinicalDataGetFact getfactory=new ClinicalDataGetFact(queue);
//		factory.start();
//		getfactory.start();
		
		testZero(Double.MIN_VALUE);
		testZero(Double.MAX_VALUE);
		
	}
	
	public static void testZero(double v2){
		if(v2==0){
			System.out.println(true);
			System.out.println(v2);
		}else{
			System.out.println(false);
			System.out.println(v2);
		}
		
	}
	
	
	
	
	/**
	 * 
	 * <p>游标默认方向</p>
	 * @throws SQLException
	 * @author: XuChuanHou
	 */
	public static void testCursor001() throws SQLException{
		long cur=System.currentTimeMillis();
		PreparedStatement ps =null;
		Connection connection =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.21:1521:orcl", "XM_ZXD_SB", "xm_zxd_sb123");
			
			 ps =connection.prepareStatement("select  id,ghdjid,dj,sl,je,xmdm,xmmc from ck10_cfmx");
			ResultSet rSet=ps.executeQuery();
			long cur1=System.currentTimeMillis();
			long i=0;
			while(rSet.next()){
				Object ghdjid=rSet.getObject("ghdjid");
				Object xmdm=rSet.getObject("xmdm");
				ghdjid=(String)ghdjid+(String)xmdm;
				i++;
				if(i%100000==0){
					System.out.println("i="+i+"  耗时:"+(System.currentTimeMillis()-cur1)/1000);
					cur1=System.currentTimeMillis();
				}
			}
			
			ps.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		System.out.println("testCursor_001 耗时:"+(System.currentTimeMillis()-cur)/1000);
	}
	
	
	/**
	 * 
	 * <p> <p>游标只能向下</p></p>
	 * @throws SQLException
	 * @author: XuChuanHou
	 */
	public static void testCursor002() throws SQLException{
		long cur=System.currentTimeMillis();
		PreparedStatement ps =null;
		Connection connection =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.21:1521:orcl", "XM_ZXD_SB", "xm_zxd_sb123");
			
			 ps =connection.prepareStatement("select  id,ghdjid,dj,sl,je,xmdm,xmmc from ck10_cfmx");
			ResultSet rSet=ps.executeQuery();
			rSet.setFetchDirection(ResultSet.FETCH_FORWARD);
			rSet.setFetchSize(10000);
			
			long i=0;
			long cur1=System.currentTimeMillis();
			while(rSet.next()){
				Object ghdjid=rSet.getObject("ghdjid");
				Object xmdm=rSet.getObject("xmdm");
				ghdjid=(String)ghdjid+(String)xmdm;
				
				i++;
				if(i%100000==0){
					System.out.println("i="+i+"  耗时:"+(System.currentTimeMillis()-cur1)/1000);
					cur1=System.currentTimeMillis();
				}
			}
			
			ps.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		System.out.println("testCursor_002 耗时:"+(System.currentTimeMillis()-cur)/1000);
	}
	


}
