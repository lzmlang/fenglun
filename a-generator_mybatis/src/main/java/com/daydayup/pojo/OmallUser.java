package com.daydayup.pojo;

import java.util.Date;

public class OmallUser {
    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 平台类型
     */
    private String source;

    /**
     * 企业ID
     */
    private Long companyId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 店铺简称
     */
    private String shortName;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 授权字段列表（authField）
     */
    private String authFieldList;

    /**
     * token信息
     */
    private String token;

    /**
     * token到期时间
     */
    private Date tokenExpire;

    /**
     * 是否有到期时间 1：是，0：否
     */
    private Boolean hasExistDeadline;

    /**
     * 到期时间
     */
    private Date deadline;

    /**
     * 版本（预留）
     */
    private String version;

    /**
     * 是否停用
     */
    private Boolean active;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date modified;

    /**
     * 数据状态 1：有效 0：无效
     */
    private Boolean enableStatus;

    /**
     * 主键ID，自增
     * @return id 主键ID，自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，自增
     * @param id 主键ID，自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 平台类型
     * @return source 平台类型
     */
    public String getSource() {
        return source;
    }

    /**
     * 平台类型
     * @param source 平台类型
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 企业ID
     * @return company_id 企业ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 企业ID
     * @param companyId 企业ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 店铺名称
     * @return name 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 店铺名称
     * @param name 店铺名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 店铺简称
     * @return short_name 店铺简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 店铺简称
     * @param shortName 店铺简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 备注信息
     * @return remark 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 授权字段列表（authField）
     * @return auth_field_list 授权字段列表（authField）
     */
    public String getAuthFieldList() {
        return authFieldList;
    }

    /**
     * 授权字段列表（authField）
     * @param authFieldList 授权字段列表（authField）
     */
    public void setAuthFieldList(String authFieldList) {
        this.authFieldList = authFieldList == null ? null : authFieldList.trim();
    }

    /**
     * token信息
     * @return token token信息
     */
    public String getToken() {
        return token;
    }

    /**
     * token信息
     * @param token token信息
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * token到期时间
     * @return token_expire token到期时间
     */
    public Date getTokenExpire() {
        return tokenExpire;
    }

    /**
     * token到期时间
     * @param tokenExpire token到期时间
     */
    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    /**
     * 是否有到期时间 1：是，0：否
     * @return has_exist_deadline 是否有到期时间 1：是，0：否
     */
    public Boolean getHasExistDeadline() {
        return hasExistDeadline;
    }

    /**
     * 是否有到期时间 1：是，0：否
     * @param hasExistDeadline 是否有到期时间 1：是，0：否
     */
    public void setHasExistDeadline(Boolean hasExistDeadline) {
        this.hasExistDeadline = hasExistDeadline;
    }

    /**
     * 到期时间
     * @return deadline 到期时间
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * 到期时间
     * @param deadline 到期时间
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * 版本（预留）
     * @return version 版本（预留）
     */
    public String getVersion() {
        return version;
    }

    /**
     * 版本（预留）
     * @param version 版本（预留）
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 是否停用
     * @return active 是否停用
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 是否停用
     * @param active 是否停用
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 创建时间
     * @return created 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 创建时间
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 修改时间
     * @return modified 修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 修改时间
     * @param modified 修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 数据状态 1：有效 0：无效
     * @return enable_status 数据状态 1：有效 0：无效
     */
    public Boolean getEnableStatus() {
        return enableStatus;
    }

    /**
     * 数据状态 1：有效 0：无效
     * @param enableStatus 数据状态 1：有效 0：无效
     */
    public void setEnableStatus(Boolean enableStatus) {
        this.enableStatus = enableStatus;
    }
}