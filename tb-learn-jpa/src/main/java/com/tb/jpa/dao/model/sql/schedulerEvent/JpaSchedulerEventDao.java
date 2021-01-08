package com.tb.jpa.dao.model.sql.schedulerEvent;

import com.tb.jpa.common.data.SchedulerEvent;
import com.tb.jpa.common.data.id.TenantId;
import com.tb.jpa.dao.model.sql.JpaAbstractSearchTextDao;
import com.tb.jpa.dao.model.sql.SchedulerEventEntity;
import com.tb.jpa.dao.schedulerEvent.SchedulerEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JpaSchedulerEventDao extends JpaAbstractSearchTextDao<SchedulerEventEntity, SchedulerEvent> implements SchedulerEventDao {
    @Autowired
    SchedulerEventRepository schedulerEventRepository;

    @Override
    public Long countByTenantId(TenantId tenantId) {
        return schedulerEventRepository.countByTenantId(tenantId.getId());
    }

    @Override
    protected Class<SchedulerEventEntity> getEntityClass() {
        return SchedulerEventEntity.class;
    }

    @Override
    protected CrudRepository<SchedulerEventEntity, UUID> getCrudRepository() {
        return schedulerEventRepository;
    }
}
