
package com.tb.jpa.common.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.tb.jpa.common.data.id.CustomerId;
import com.tb.jpa.common.data.id.SchedulerEventId;
import com.tb.jpa.common.data.id.TenantId;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SchedulerEvent extends SearchTextBasedWithAdditionalInfo<SchedulerEventId> implements HasName, HasTenantId, HasCustomerId {
    private static final long serialVersionUID = 2807343040519543363L;
    private TenantId tenantId;
    private CustomerId customerId;
    private String name;
    private String type;
    private String schedule;
    private transient JsonNode additionalInfo;
    private transient JsonNode configuration;

    public SchedulerEvent() {
        super();
    }

    public SchedulerEvent(SchedulerEventId id) {
        super(id);
    }

    public SchedulerEvent(SchedulerEvent schedulerEvent) {
        super(schedulerEvent);
        this.tenantId = schedulerEvent.getTenantId();
        this.customerId = schedulerEvent.getCustomerId();
        this.name = schedulerEvent.getName();
        this.type = schedulerEvent.getType();
        this.configuration=schedulerEvent.configuration;
        this.additionalInfo=schedulerEvent.additionalInfo;
    }

    public TenantId getTenantId() {
        return tenantId;
    }

    public void setTenantId(TenantId tenantId) {
        this.tenantId = tenantId;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public JsonNode getConfiguration() {
        return configuration;
    }

    public void setConfiguration(JsonNode configuration) {
        this.configuration = configuration;
    }

    public JsonNode getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(JsonNode additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    @Override
    public String getSearchText() {
        return getName();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Device [tenantId=");
        builder.append(tenantId);
        builder.append(", customerId=");
        builder.append(customerId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", type=");
        builder.append(type);
        builder.append(", additionalInfo=");
        builder.append(getAdditionalInfo());
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }

}
