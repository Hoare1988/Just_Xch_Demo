package org.just.xch.StdXch.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagnoseTest {

	public static void main(String[] args) {
		long cur=System.currentTimeMillis();
		PreparedStatement ps =null;
		Connection connection =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.21:1521:orcl", "XM_wxzxd", "XM_wxzxd123");
				
			 ps =connection.prepareStatement(" select id,cyzddm ,ryzddm,cyzdmc,ryzdmc from ck10_ghdj");
			ResultSet rSet=ps.executeQuery();
			long cur1=System.currentTimeMillis();
			long i=0;
			rSet.setFetchDirection(ResultSet.FETCH_FORWARD);
			rSet.setFetchSize(100000);
			
			Map<String, List<Map<String, Object>>> zdAllMap= new HashMap<String, List<Map<String,Object>>>();
			
			while(rSet.next()){
				Map<String,Object> zd=new HashMap<String, Object>();
				
//			、TODO	if(zdAllMap.co){}
				
				zd.put("id",rSet.getObject("id"));
				zd.put("cyzddm",rSet.getObject("cyzddm"));
				zd.put("ryzddm",rSet.getObject("ryzddm"));
				zd.put("cyzdmc",rSet.getObject("cyzdmc"));
				zd.put("ryzdmc",rSet.getObject("ryzdmc"));
				
			
				
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("testCursor_001 耗时:"+(System.currentTimeMillis()-cur)/1000);
	}

}
