package org.just.xch.stdxch.mongo.dao.impl;

import org.just.xch.stdxch.mongo.dao.MongodbBaseDao;
import org.just.xch.stdxch.mongo.entity.Cfmx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CfmxDao extends MongodbBaseDao<Cfmx> {

    @Autowired  
    @Qualifier("mongoTemplate")  
    public void setMongoTemplate(MongoTemplate mongoTemplate) {  
        super.mongoTemplate = mongoTemplate;  
    }  
    
    @Override
    protected Class<Cfmx> getEntityClass() {
        return Cfmx.class;
    }
}
