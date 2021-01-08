/**
 * Copyright © 2016-2020 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tb.jpa.dao.model.sql;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tb.jpa.common.data.SchedulerEvent;
import com.tb.jpa.common.data.ShortCustomerInfo;
import com.tb.jpa.common.data.id.CustomerId;
import com.tb.jpa.common.data.id.SchedulerEventId;
import com.tb.jpa.common.data.id.TenantId;
import com.tb.jpa.dao.model.BaseSqlEntity;
import com.tb.jpa.dao.model.ModelConstants;
import com.tb.jpa.dao.model.SearchTextEntity;
import com.tb.jpa.dao.util.mapping.JsonStringType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.UUID;

@Data
@Slf4j
@EqualsAndHashCode()
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = ModelConstants.SCHEDULER_EVENT_COLUMN_FAMILY_NAME)
public final class SchedulerEventEntity extends BaseSqlEntity<SchedulerEvent> implements SearchTextEntity<SchedulerEvent> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JavaType assignedCustomersType =
            objectMapper.getTypeFactory().constructCollectionType(HashSet.class, ShortCustomerInfo.class);

    @Column(name = ModelConstants.SCHEDULER_EVENT_TENANT_ID_PROPERTY)
    private UUID tenantId;

    @Column(name = ModelConstants.SCHEDULER_EVENT_CUSTOMER_ID_PROPERTY)
    private UUID customerId;

    @Column(name = ModelConstants.SCHEDULER_EVENT_NAME_PROPERTY)
    private String name;

    @Column(name = ModelConstants.SCHEDULER_EVENT_TYPE_PROPERTY)
    private String type;

    @Column(name = ModelConstants.SCHEDULER_EVENT_SCHEDULE_PROPERTY)
    private String schedule;

    @Type(type = "json")
    @Column(name = ModelConstants.SCHEDULER_EVENT_ADDITIONAL_INFO_PROPERTY )
    private JsonNode additionalInfo;

    @Type(type = "json")
    @Column(name = ModelConstants.SCHEDULER_EVENT_CONFIGURATION_PROPERTY)
    private JsonNode configuration;

    public SchedulerEventEntity() {
        super();
    }

    public SchedulerEventEntity(SchedulerEvent schedulerEvent) {
        if (schedulerEvent.getId() != null) {
            this.setUuid(schedulerEvent.getId().getId());
        }
        this.setCreatedTime(schedulerEvent.getCreatedTime());
        if (schedulerEvent.getTenantId() != null) {
            this.tenantId = schedulerEvent.getTenantId().getId();
        }
        if (schedulerEvent.getCustomerId() != null) {
            this.customerId = schedulerEvent.getCustomerId().getId();
        }
        this.additionalInfo=schedulerEvent.getAdditionalInfo();
        this.name=schedulerEvent.getName();
        this.type=schedulerEvent.getType();
        this.schedule=schedulerEvent.getSchedule();
        this.configuration = schedulerEvent.getConfiguration();
    }

    @Override
    public String getSearchTextSource() {
     return "";
    }

    @Override
    public void setSearchText(String searchText) {

    }

    @Override
    public SchedulerEvent toData() {
        SchedulerEvent schedulerEvent = new SchedulerEvent(new SchedulerEventId(this.getUuid()));
        schedulerEvent.setCreatedTime(this.getCreatedTime());
        if (tenantId != null) {
            schedulerEvent.setTenantId(new TenantId(tenantId));
        }
        schedulerEvent.setAdditionalInfo(additionalInfo);
        schedulerEvent.setCustomerId(new CustomerId(customerId));
        schedulerEvent.setName(name);
        schedulerEvent.setType(type);
        schedulerEvent.setSchedule(schedule);
        schedulerEvent.setConfiguration(configuration);
        return schedulerEvent;
    }
}
