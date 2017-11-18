package org.just.xch.stdxch.mongo.dao.impl;

import java.util.List;
import java.util.Map;

import org.just.xch.stdxch.mongo.constant.Constant;
import org.just.xch.stdxch.mongo.dao.MongodbBaseDao;
import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository 
public class MonitorDaoImpl extends MongodbBaseDao<Ghdj> {

    @Autowired  
    @Qualifier("mongoTemplate")  
    public void setMongoTemplate(MongoTemplate mongoTemplate) {  
        super.mongoTemplate = mongoTemplate;  
    }  
    
    @Override
    protected Class<Ghdj> getEntityClass() {
        return Ghdj.class;
    }

    /** 
     * @param id
     * @see org.just.xch.stdxch.mongo.dao.intf.IMonitorDao#findByGhdjID(java.lang.String)
     * @时间: 2017年9月10日 下午4:50:00 
     * @author: XuChuanHou
    */
    public Ghdj findByGhdjID(String id) {
         Query query = new Query(Criteria.where("id").is(id));
         return  super.findOne(query);
    }
    
    public List<Ghdj> findByCondits(Map<String, Object> conidt) {
        int id=0;
        
        Criteria condit=null;
        for(Map.Entry<String, Object> entry:conidt.entrySet()){
            if(id==0){
                condit=Criteria.where(entry.getKey()).is(entry.getValue());
            }else{
                condit=condit.and(entry.getKey()).is(entry.getValue());
            }
        }
        
        Query query = new Query(condit);
        return   super.find(query);
    }

    /** 
     * @param ghdjid
     * @see org.just.xch.stdxch.mongo.dao.intf.IMonitorDao#deleteByGhdjID(java.lang.String)
     * @时间: 2017年9月10日 下午4:53:26 
     * @author: XuChuanHou
    */
    public void deleteByGhdjID(String id) {
         Query query = new Query(Criteria.where("id").is(id));  
            Update update = new Update();  
             update.set("dele_flg", Constant.DELE_FLG_TRUE);  
            mongoTemplate.updateFirst(query, update, getEntityClass());  
        
    }
    
}
