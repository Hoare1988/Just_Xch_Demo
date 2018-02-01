package org.just.xch.stdxch.mongo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.just.xch.stdxch.mongo.dao.impl.MonitorDaoImpl;
import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.service.intf.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitorServiceImpl implements IMonitorService {
    
    @Autowired
    private MonitorDaoImpl monitorDao;

    @Override
    public Ghdj findByGhdjID(String ghdjid) {
        return monitorDao.findByGhdjID(ghdjid);
    }

    @Override
    public List<Ghdj> findManGhdj() {
        Map<String,Object> condit=new HashMap<>();
       // condit.put("hzxb", "1");
        return monitorDao.findByCondits(condit);
    }

    @Override
    public Ghdj saveGhdj(Ghdj ghdj) {
        return monitorDao.save(ghdj);
    }
    
}
