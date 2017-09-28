package org.just.xch.StdXch.mongo.dao.impl;

import java.util.List;

import org.just.xch.StdXch.mongo.constant.Constant;
import org.just.xch.StdXch.mongo.dao.MongodbBaseDao;
import org.just.xch.StdXch.mongo.dao.intf.IMonitorDao;
import org.just.xch.StdXch.mongo.entity.ShAj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository 
public class MonitorDaoImpl extends MongodbBaseDao<ShAj> implements IMonitorDao {

	 @Autowired  
    @Qualifier("mongoTemplate")  
    public void setMongoTemplate(MongoTemplate mongoTemplate) {  
        super.mongoTemplate = mongoTemplate;  
    }  
	
	@Override
	protected Class<ShAj> getEntityClass() {
		return ShAj.class;
	}

	/** 
	 * @param ghdjid
	 * @see org.just.xch.StdXch.mongo.dao.intf.IMonitorDao#findByGhdjID(java.lang.String)
	 * @时间: 2017年9月10日 下午4:50:00 
	 * @author: XuChuanHou
	*/
	@Override
	public List<ShAj> findByGhdjID(String ghdjid) {
		 Query query = new Query(Criteria.where("ghdjid").is(ghdjid));  
	      return mongoTemplate.find(query, getEntityClass());  
	}

	/** 
	 * @param ghdjid
	 * @see org.just.xch.StdXch.mongo.dao.intf.IMonitorDao#deleteByGhdjID(java.lang.String)
	 * @时间: 2017年9月10日 下午4:53:26 
	 * @author: XuChuanHou
	*/
	@Override
	public void deleteByGhdjID(String ghdjid) {
		 Query query = new Query(Criteria.where("ghdjid").is(ghdjid));  
	        Update update = new Update();  
	         update.set("dele_flg", Constant.DELE_FLG_TRUE);  
	        mongoTemplate.updateFirst(query, update, getEntityClass());  
		
	}
	
	
	
	
}