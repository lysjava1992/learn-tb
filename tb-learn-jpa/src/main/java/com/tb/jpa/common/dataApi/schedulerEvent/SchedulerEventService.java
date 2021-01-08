package com.tb.jpa.common.dataApi.schedulerEvent;


import com.tb.jpa.common.data.SchedulerEvent;
import com.tb.jpa.common.data.id.SchedulerEventId;
import com.tb.jpa.common.data.id.TenantId;

public interface SchedulerEventService {
    SchedulerEvent findSchedulerEventById(TenantId tenantId, SchedulerEventId schedulerEventId);

    SchedulerEvent saveSchedulerEvent(SchedulerEvent se);

}
