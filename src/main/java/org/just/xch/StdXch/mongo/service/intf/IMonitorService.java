package org.just.xch.stdxch.mongo.service.intf;


import java.util.List;

import org.just.xch.stdxch.mongo.entity.Ghdj;

public interface IMonitorService {
    
    Ghdj findByGhdjID(String id);
    
    List<Ghdj> findManGhdj();
    
    Ghdj saveGhdj(Ghdj ghdj);
}
