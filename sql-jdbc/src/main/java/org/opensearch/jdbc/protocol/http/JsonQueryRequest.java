/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */


package org.opensearch.jdbc.protocol.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.opensearch.jdbc.protocol.Parameter;
import org.opensearch.jdbc.protocol.QueryRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class JsonQueryRequest implements QueryRequest {

    private String query;
    private String timeZone;
    private int fetchSize;
    private List<? extends Parameter> parameters;
    private List<Object> params;

    public JsonQueryRequest(QueryRequest queryRequest) {
        this(queryRequest, null);
    }

    public JsonQueryRequest(QueryRequest queryRequest, String timeZone) {
        this.query = queryRequest.getQuery();
        this.parameters = queryRequest.getParameters();
        if (this.parameters != null) {
            this.params = queryRequest.getParameters().stream().map(Parameter::getValue).collect(Collectors.toList());
        }
        this.fetchSize = queryRequest.getFetchSize();
        this.timeZone = timeZone;

    }

    @Override
    public String getQuery() {
        return query;
    }

    @JsonIgnore
    @Override
    public List<? extends Parameter> getParameters() {
        return parameters;
    }

    @JsonInclude(Include.NON_NULL)
    public List<Object> getParams() {
        return params;
    }

    @JsonProperty("fetch_size")
    @Override
    public int getFetchSize() {
        return fetchSize;
    }

    @JsonProperty("time_zone")
    @JsonInclude(Include.NON_NULL)
    public String getTimeZone() {
        return timeZone;
    }
}
