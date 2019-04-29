package org.just.xch.stdxch.mongo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.just.xch.stdxch.mongo.service.impl.TransCData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TransCData_Test {
    
    @Autowired
    private TransCData transCData;
    
//    @Test
    public void updateGHdj_001(){
        transCData.updateGHdj();
    }
    
//    @Test
    public void tansClinicalData_001(){
        transCData.tansClinicalData();
    }
    
    @Test
    public void updateGHdjByID_001(){
        transCData.updateGHdjByID("99C62CCB-22B4-4879-B5AD-CE9EC827DEEE");
        
    }
    

}
