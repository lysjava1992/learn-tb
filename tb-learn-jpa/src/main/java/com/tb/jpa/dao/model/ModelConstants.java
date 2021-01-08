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
package com.tb.jpa.dao.model;



import com.tb.jpa.common.data.id.TenantId;

import java.util.UUID;

/**
 * 定义实体
 */
public class ModelConstants {



    private ModelConstants() {
    }
    public static final UUID NULL_UUID = UUID.randomUUID();
    public static final long EPOCH_DIFF = 122192928000000000L;
    public static final String TENANT_ID_PROPERTY = "tenant_id";
    public static final String CUSTOMER_ID_PROPERTY = "customer_id";
    public static final String ID_PROPERTY = "id";
    public static final String CREATED_TIME_PROPERTY = "created_time";
    public static final String USER_ID_PROPERTY = "user_id";
    public static final String DEVICE_ID_PROPERTY = "device_id";
    public static final String TITLE_PROPERTY = "title";
    public static final String ALIAS_PROPERTY = "alias";
    public static final String SEARCH_TEXT_PROPERTY = "search_text";
    public static final String ADDITIONAL_INFO_PROPERTY = "additional_info";
    public static final String ENTITY_TYPE_PROPERTY = "entity_type";




    public static final String SCHEDULER_EVENT_COLUMN_FAMILY_NAME = "scheduler_event";
    public static final String SCHEDULER_EVENT_TENANT_ID_PROPERTY = TENANT_ID_PROPERTY;
    public static final String SCHEDULER_EVENT_CONFIGURATION_PROPERTY = "configuration";
    public static final String SCHEDULER_EVENT_ADDITIONAL_INFO_PROPERTY = ADDITIONAL_INFO_PROPERTY;
    public static final String SCHEDULER_EVENT_CUSTOMER_ID_PROPERTY= CUSTOMER_ID_PROPERTY;
    public static final String SCHEDULER_EVENT_NAME_PROPERTY="name";
    public static final String SCHEDULER_EVENT_TYPE_PROPERTY="type";
    public static final String SCHEDULER_EVENT_SCHEDULE_PROPERTY="schedule";


}
