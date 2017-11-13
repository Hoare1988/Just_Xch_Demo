package org.just.xch.stdxch.mongo.service.intf;


import java.util.List;

import org.just.xch.stdxch.mongo.entity.Ghdj;

public interface IMonitorService {
    
    List<Ghdj> findByGhdjID(String id);
    
}
