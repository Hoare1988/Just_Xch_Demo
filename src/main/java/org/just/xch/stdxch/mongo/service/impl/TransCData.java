package org.just.xch.stdxch.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.just.xch.stdxch.mongo.dao.impl.CfmxDao;
import org.just.xch.stdxch.mongo.dao.impl.JsmxDao;
import org.just.xch.stdxch.mongo.dao.impl.MonitorDaoImpl;
import org.just.xch.stdxch.mongo.entity.Cfmx;
import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.entity.Jsmx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class TransCData {
    
    Logger logger=LoggerFactory.getLogger(TransCData.class);
    
    @Autowired
    private MonitorDaoImpl monitorDao;
    
    @Autowired
    private CfmxDao cfmxDao;
    
    @Autowired
    private JsmxDao jsmxDao;
    
    public void tansClinicalData(){
        
       List<Ghdj> ghdjs = monitorDao.findAll(); 
       boolean changed=false;
       
       Update update=null;
       
       Query ghQuery=null;
       int i=0;
       for(Ghdj ghdj:ghdjs){
           i++;
           if(i%100==0){
               logger.info(""+i);
           }
           Query query = new Query(Criteria.where("ghdjid").is(ghdj.getId()));
           
            changed=false;
          List<Cfmx> cfmxs= cfmxDao.find(query);
          List<Jsmx> jsmxs= jsmxDao.find(query);
          
          update = new Update();
          if(!cfmxs.isEmpty()){
              changed=true;
              ghdj.setCfmxs(cfmxs);
              update.set("cfmxs", cfmxs);
          }
          if(!jsmxs.isEmpty()){
              changed=true;
              ghdj.setJsmxs(jsmxs);
              
              update.set("jsmxs", jsmxs);
//              update.setOnInsert("jsmxs",jsmxs);
          }
          
          if(changed){
              ghQuery = new Query(Criteria.where("id").is(ghdj.getId()));
              monitorDao.updateFirst(ghQuery, update);
          }
       }
    }
    
    
    public  void updateGHdj(){
        List<Cfmx> cfmxs=new ArrayList<>(6);
        Cfmx cfmx=new Cfmx();
        cfmx.setXmdm("aaaaa");
        cfmxs.add(cfmx);
        
        monitorDao.updateFirst(new Query(Criteria.where("id").is("CD5DE4E1-11C3-4BA3-ADCF-82BB0D56DAD1")), new Update().set("cfmxs",cfmxs));
        
    }
    
    
    /**
     * 
     * <p> 将挂号等级的处方和结算补全</p>
     * @param id
     * @author: XuChuanHou
     */
    public  void updateGHdjByID(String id){
        Query query = new Query(Criteria.where("ghdjid").is(id));
        
          List<Cfmx> cfmxs= cfmxDao.find(query);
          List<Jsmx> jsmxs= jsmxDao.find(query);
          monitorDao.updateFirst(new Query(Criteria.where("id").is(id)), new Update().set("cfmxs",cfmxs).set("jsmxs", jsmxs));
    }
    
}
