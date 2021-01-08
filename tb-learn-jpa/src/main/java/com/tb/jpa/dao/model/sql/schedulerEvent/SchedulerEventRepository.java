package com.tb.jpa.dao.model.sql.schedulerEvent;



import com.tb.jpa.dao.model.sql.SchedulerEventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SchedulerEventRepository  extends CrudRepository<SchedulerEventEntity, UUID> {

    Long countByTenantId(UUID tenantId);
}

