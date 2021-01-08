package com.tb.jpa.dao.schedulerEvent;

import com.tb.jpa.common.data.SchedulerEvent;
import com.tb.jpa.common.data.id.SchedulerEventId;
import com.tb.jpa.common.data.id.TenantId;
import com.tb.jpa.common.dataApi.schedulerEvent.SchedulerEventService;
import com.tb.jpa.dao.entity.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SchedulerEventServiceImpl extends AbstractEntityService implements SchedulerEventService {

    public static final String INCORRECT_DEVICE_ID = "Incorrect schedulerEventId ";


    @Autowired
    private SchedulerEventDao schedulerEventDao;

    @Override
    public SchedulerEvent findSchedulerEventById(TenantId tenantId, SchedulerEventId schedulerEventId) {

            return schedulerEventDao.findById(tenantId, schedulerEventId.getId());
    }
    @Override
    public SchedulerEvent saveSchedulerEvent(SchedulerEvent schedulerEvent) {
        return schedulerEventDao.save(schedulerEvent.getTenantId(), schedulerEvent);
    }

}
