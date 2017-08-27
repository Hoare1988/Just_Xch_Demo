package org.just.xch.StdXch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class ClinicalDataGetFact extends Thread {

	BlockingQueue<Map<String, Object>> dataQueue;
	
	Connection  connection;
	
	public ClinicalDataGetFact(BlockingQueue<Map<String, Object>> dataQueue){
		this.dataQueue = dataQueue ;
		
		try {
		     Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.21:1521:orcl", "XM_ZXD_SB", "xm_zxd_sb123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException  e) {
			// TODO: handle exception
		}
		
	}
	
	
	/** 
	 * 
	 * @see java.lang.Thread#run()
	 * @时间: 2017年8月27日 下午3:47:30 
	 * @author: XuChuanHou
	*/
	@Override
	public void run() {
			
			long i=0;
			long cur1=System.currentTimeMillis();
			while (true) {
					i++;
			 try {
				Map<String, Object> patient=dataQueue.take();
				 Object id=  patient.get("id");
				 Object ghdjid=  patient.get("ghdjid");
				 Object xmdm=  patient.get("xmdm");
				
				 if(i%10000==0){
					 System.out.println(i+"   "+(System.currentTimeMillis()-cur1)/1000);
				 }
				 
				 patient.clear();
				 patient=null;
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
	}

	
	
	
	public void toDB( Map<String, Object> patient) throws SQLException{
		long cur=System.currentTimeMillis();
		PreparedStatement ps =null;
		Connection connection =null;
		try{
			
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
	
	
}
