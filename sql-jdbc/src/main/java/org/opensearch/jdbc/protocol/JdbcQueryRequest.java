/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */


package org.opensearch.jdbc.protocol;

import java.util.List;
import java.util.Objects;

public class JdbcQueryRequest implements QueryRequest {

    private String statement;
    private int fetchSize;
    List<JdbcQueryParam> parameters;

    public JdbcQueryRequest(String sql) {
        this.statement = sql;
    }

    public JdbcQueryRequest(String sql, int fetchSize) {
        this.statement = sql;
        this.fetchSize = Math.max(fetchSize, 1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JdbcQueryRequest)) return false;
        JdbcQueryRequest that = (JdbcQueryRequest) o;
        return Objects.equals(statement, that.statement) &&
                Objects.equals(getParameters(), that.getParameters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(statement, getParameters());
    }

    @Override
    public String getQuery() {
        return statement;
    }

    @Override
    public List<JdbcQueryParam> getParameters() {
        return parameters;
    }

    public void setParameters(List<JdbcQueryParam> parameters) {
        this.parameters = parameters;
    }

    @Override
    public int getFetchSize() {
        return fetchSize;
    }

    @Override
    public String toString() {
        return "JdbcQueryRequest{" +
                "statement='" + statement + '\'' +
                ", fetchSize='" + fetchSize + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
