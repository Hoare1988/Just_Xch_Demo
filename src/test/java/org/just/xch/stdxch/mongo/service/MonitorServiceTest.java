package org.just.xch.stdxch.mongo.service;

import org.junit.Assert;
import org.junit.Test;
import org.just.xch.stdxch.BaseTest;
import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.service.intf.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;

public class MonitorServiceTest extends BaseTest {

    @Autowired
    private IMonitorService monitorService;
    
    @Test
    public void findByGhdjID_001(){
        
        Ghdj ghdj=new Ghdj();
        ghdj.setId("20170111301010");
        ghdj.setRyzddm("J10.135X");
        
         monitorService.saveGhdj(ghdj);
       Ghdj ghdj_EN =  monitorService.findByGhdjID("20170111301010");
        Assert.assertNotNull(ghdj_EN);
    }
}
