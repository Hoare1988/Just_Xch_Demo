package org.just.xch.stdxch.mongo.dao.impl;

import org.just.xch.stdxch.mongo.dao.MongodbBaseDao;
import org.just.xch.stdxch.mongo.entity.Jsmx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


@Component
public class JsmxDao extends MongodbBaseDao<Jsmx> {

    @Autowired  
    @Qualifier("mongoTemplate")  
    public void setMongoTemplate(MongoTemplate mongoTemplate) {  
        super.mongoTemplate = mongoTemplate;  
    }  
    
    @Override
    protected Class<Jsmx> getEntityClass() {
        return Jsmx.class;
    }
}
