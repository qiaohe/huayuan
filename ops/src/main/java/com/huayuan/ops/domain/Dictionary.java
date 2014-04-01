package com.huayuan.ops.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dell on 14-3-31.
 */
@Entity
@Table(name = "VALUE_EDUCATION")
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 3607546095778315177L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "UPDATOR")
    private String key;
    @Basic
    @Column(name = "VALUE")
    private String value;
    @Basic
    @Column(name = "CREATE_TIME")
    private Date createTime;

    public Dictionary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.key).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dictionary)) return false;
        if (this == obj) return true;
        final Dictionary otherObject = (Dictionary) obj;
        return new EqualsBuilder().append(this.id, otherObject.id).append(this.key, otherObject.key).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("key", this.key).append("value", this.value).toString();
    }
}
