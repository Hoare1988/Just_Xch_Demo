package org.just.xch.stdxch.mongo.controller;

import java.util.List;

import org.just.xch.stdxch.mongo.entity.Ghdj;
import org.just.xch.stdxch.mongo.service.impl.TransCData;
import org.just.xch.stdxch.mongo.service.intf.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/monitor/*")
public class MonitorController {

    @Autowired
    IMonitorService monitorService;
    
    @Autowired
    TransCData transCData;

    @RequestMapping(value = "/ghdj", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    @ApiOperation(value = "根据就诊号获取就诊对象", notes = "根据就诊号获取就诊对象")
    List<Ghdj> findByGhdjID(@RequestParam("ghdjid") String ghdjid) {
        // List<Ghdj> ghdjList= monitorService.findByGhdjID(ghdjid);
        List<Ghdj> ghdjList = monitorService.findManGhdj();
        return ghdjList;
    }
    
    
    
    @RequestMapping(value = "/transCdata", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    @ApiOperation(value = "更新系统中就诊数据", notes = "更新系统中就诊数据")
    void tansClinicalData() {
        transCData.tansClinicalData();
        return ;
    }

}
