/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */


package org.opensearch.jdbc.config;

public class TimeZoneConnectionProperty extends StringConnectionProperty {
    public static final String KEY = "timeZone";

    public TimeZoneConnectionProperty() {
        super(KEY);
    }

    public String getDefault() {
        return "UTC";
    }

}
