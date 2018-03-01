package org.zstack.sdk.zwatch.alarm;

import org.zstack.sdk.zwatch.ruleengine.ComparisonOperator;
import org.zstack.sdk.zwatch.alarm.AlarmStatus;

public class AlarmInventory  {

    public java.lang.String uuid;
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }
    public java.lang.String getUuid() {
        return this.uuid;
    }

    public java.lang.String name;
    public void setName(java.lang.String name) {
        this.name = name;
    }
    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String description;
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    public java.lang.String getDescription() {
        return this.description;
    }

    public ComparisonOperator comparisonOperator;
    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }
    public ComparisonOperator getComparisonOperator() {
        return this.comparisonOperator;
    }

    public java.lang.Integer period;
    public void setPeriod(java.lang.Integer period) {
        this.period = period;
    }
    public java.lang.Integer getPeriod() {
        return this.period;
    }

    public java.lang.String namespace;
    public void setNamespace(java.lang.String namespace) {
        this.namespace = namespace;
    }
    public java.lang.String getNamespace() {
        return this.namespace;
    }

    public java.lang.String metricName;
    public void setMetricName(java.lang.String metricName) {
        this.metricName = metricName;
    }
    public java.lang.String getMetricName() {
        return this.metricName;
    }

    public java.lang.Double threshold;
    public void setThreshold(java.lang.Double threshold) {
        this.threshold = threshold;
    }
    public java.lang.Double getThreshold() {
        return this.threshold;
    }

    public java.lang.Integer repeatInterval;
    public void setRepeatInterval(java.lang.Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
    public java.lang.Integer getRepeatInterval() {
        return this.repeatInterval;
    }

    public AlarmStatus status;
    public void setStatus(AlarmStatus status) {
        this.status = status;
    }
    public AlarmStatus getStatus() {
        return this.status;
    }

    public java.sql.Timestamp createDate;
    public void setCreateDate(java.sql.Timestamp createDate) {
        this.createDate = createDate;
    }
    public java.sql.Timestamp getCreateDate() {
        return this.createDate;
    }

    public java.sql.Timestamp lastOpDate;
    public void setLastOpDate(java.sql.Timestamp lastOpDate) {
        this.lastOpDate = lastOpDate;
    }
    public java.sql.Timestamp getLastOpDate() {
        return this.lastOpDate;
    }

    public java.util.List labels;
    public void setLabels(java.util.List labels) {
        this.labels = labels;
    }
    public java.util.List getLabels() {
        return this.labels;
    }

    public java.util.List actions;
    public void setActions(java.util.List actions) {
        this.actions = actions;
    }
    public java.util.List getActions() {
        return this.actions;
    }

}
