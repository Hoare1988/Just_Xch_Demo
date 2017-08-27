package org.just.xch.StdXch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class ClinicalDataFactory extends Thread {
	
	BlockingQueue<Map<String, Object>> dataQueue;
	
	public ClinicalDataFactory(BlockingQueue<Map<String, Object>> dataQueue){
		this.dataQueue = dataQueue ;
	}

	/** 
	 * 
	 * @see java.lang.Thread#run()
	 * @时间: 2017年8月27日 下午3:33:21 
	 * @author: XuChuanHou
	*/
	@Override
	public void run() {
		long cur=System.currentTimeMillis();
		PreparedStatement ps =null;
		Connection connection =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.21:1521:orcl", "XM_wxzxd", "XM_wxzxd123");
			
			 ps =connection.prepareStatement("select  id,ghdjid,dj,sl,je,xmdm,xmmc from ck10_cfmx");
			ResultSet rSet=ps.executeQuery();
			rSet.setFetchDirection(ResultSet.FETCH_FORWARD);
			rSet.setFetchSize(10000);
			
			long i=0;
			long cur1=System.currentTimeMillis();
			while(rSet.next()){
				Object id=rSet.getObject("id");
				Object ghdjid=rSet.getObject("ghdjid");
				Object xmdm=rSet.getObject("xmdm");
				ghdjid=(String)ghdjid+(String)xmdm;
				
				Map<String,Object> patient=new HashMap<String,Object>();
				patient.put("id", id);
				patient.put("ghdjid", ghdjid);
				patient.put("xmdm", xmdm);
				
				dataQueue.put(patient);
				
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
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("testCursor_002 耗时:"+(System.currentTimeMillis()-cur)/1000);
	}
	
	
	
}
