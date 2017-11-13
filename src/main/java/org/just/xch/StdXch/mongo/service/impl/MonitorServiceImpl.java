package org.just.xch.stdxch.mongo.service.impl;

import java.util.List;

import org.just.xch.stdxch.mongo.dao.intf.IMonitorDao;
import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.service.intf.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitorServiceImpl implements IMonitorService {
    
    @Autowired
    private IMonitorDao monitorDao;

    @Override
    public List<Ghdj> findByGhdjID(String ghdjid) {
        return monitorDao.findByGhdjID(ghdjid);
    }
    
}
