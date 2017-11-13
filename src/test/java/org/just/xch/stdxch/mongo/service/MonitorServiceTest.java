package org.just.xch.stdxch.mongo.service;

import java.util.List;

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
        
        List<Ghdj> ajList=monitorService.findByGhdjID("2017092801010");
        Assert.assertNotNull(ajList);
    }
}
