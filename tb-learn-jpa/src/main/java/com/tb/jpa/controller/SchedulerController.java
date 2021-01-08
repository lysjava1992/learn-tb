package com.tb.jpa.controller;

import com.tb.jpa.common.data.SchedulerEvent;
import com.tb.jpa.common.data.id.TenantId;
import com.tb.jpa.common.dataApi.schedulerEvent.SchedulerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api")
public class SchedulerController {
    @Autowired
    private SchedulerEventService schedulerEventService;

    @RequestMapping(value = "/schedulerEvent", method = RequestMethod.POST)
    @ResponseBody
    public SchedulerEvent saveSchedulerEvent(@RequestBody SchedulerEvent se) throws Exception {
        try {
            // 设置租户ID
            se.setTenantId(new TenantId(UUID.randomUUID()));
            // 权限检查
            SchedulerEvent savedSe = schedulerEventService.saveSchedulerEvent(se);
            return savedSe;
        } catch (Exception e) {
          e.printStackTrace();
          return null;
        }

    }


}
