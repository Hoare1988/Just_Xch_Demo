package org.just.xch.stdxch.mongo.controller;

import java.util.List;

import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.service.intf.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/monitor/*")
public class MonitorController {

    @Autowired
    IMonitorService monitorService;
    
    @RequestMapping(value="/ghdj",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    @ResponseBody
    List<Ghdj> findByGhdjID(@RequestParam("ghdjid") String ghdjid ) {
//       List<Ghdj>  ghdjList= monitorService.findByGhdjID(ghdjid);
        List<Ghdj>  ghdjList= monitorService.findManGhdj();
        return ghdjList;
    }
    
}
