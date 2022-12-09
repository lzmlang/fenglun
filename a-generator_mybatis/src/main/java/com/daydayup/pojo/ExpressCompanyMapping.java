package com.daydayup.pojo;

import java.util.Date;

public class ExpressCompanyMapping {
    /**
     * 主键ID，自增
     */
    private Long id;

    /**
     * 平台
     */
    private String source;

    /**
     * 平台物流公司编码
     */
    private String matchType;

    /**
     * 平台物流公司编码
     */
    private String platformBizId;

    /**
     * 平台物流公司编码
     */
    private String platformBizCode;

    /**
     * 平台物流公司名称
     */
    private String platformBizname;

    /**
     * 关联的系统的物流公司ID
     */
    private Long relativeExpressCompanyId;

    /**
     * 系统物流公司编码
     */
    private String sysBizCode;

    /**
     * 系统物流公司名称
     */
    private String sysBizname;

    /**
     * 启用状态，1：启用，0未启用，默认为0
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
     * 平台
     * @return source 平台
     */
    public String getSource() {
        return source;
    }

    /**
     * 平台
     * @param source 平台
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 平台物流公司编码
     * @return match_type 平台物流公司编码
     */
    public String getMatchType() {
        return matchType;
    }

    /**
     * 平台物流公司编码
     * @param matchType 平台物流公司编码
     */
    public void setMatchType(String matchType) {
        this.matchType = matchType == null ? null : matchType.trim();
    }

    /**
     * 平台物流公司编码
     * @return platform_biz_id 平台物流公司编码
     */
    public String getPlatformBizId() {
        return platformBizId;
    }

    /**
     * 平台物流公司编码
     * @param platformBizId 平台物流公司编码
     */
    public void setPlatformBizId(String platformBizId) {
        this.platformBizId = platformBizId == null ? null : platformBizId.trim();
    }

    /**
     * 平台物流公司编码
     * @return platform_biz_code 平台物流公司编码
     */
    public String getPlatformBizCode() {
        return platformBizCode;
    }

    /**
     * 平台物流公司编码
     * @param platformBizCode 平台物流公司编码
     */
    public void setPlatformBizCode(String platformBizCode) {
        this.platformBizCode = platformBizCode == null ? null : platformBizCode.trim();
    }

    /**
     * 平台物流公司名称
     * @return platform_bizname 平台物流公司名称
     */
    public String getPlatformBizname() {
        return platformBizname;
    }

    /**
     * 平台物流公司名称
     * @param platformBizname 平台物流公司名称
     */
    public void setPlatformBizname(String platformBizname) {
        this.platformBizname = platformBizname == null ? null : platformBizname.trim();
    }

    /**
     * 关联的系统的物流公司ID
     * @return relative_express_company_id 关联的系统的物流公司ID
     */
    public Long getRelativeExpressCompanyId() {
        return relativeExpressCompanyId;
    }

    /**
     * 关联的系统的物流公司ID
     * @param relativeExpressCompanyId 关联的系统的物流公司ID
     */
    public void setRelativeExpressCompanyId(Long relativeExpressCompanyId) {
        this.relativeExpressCompanyId = relativeExpressCompanyId;
    }

    /**
     * 系统物流公司编码
     * @return sys_biz_code 系统物流公司编码
     */
    public String getSysBizCode() {
        return sysBizCode;
    }

    /**
     * 系统物流公司编码
     * @param sysBizCode 系统物流公司编码
     */
    public void setSysBizCode(String sysBizCode) {
        this.sysBizCode = sysBizCode == null ? null : sysBizCode.trim();
    }

    /**
     * 系统物流公司名称
     * @return sys_bizname 系统物流公司名称
     */
    public String getSysBizname() {
        return sysBizname;
    }

    /**
     * 系统物流公司名称
     * @param sysBizname 系统物流公司名称
     */
    public void setSysBizname(String sysBizname) {
        this.sysBizname = sysBizname == null ? null : sysBizname.trim();
    }

    /**
     * 启用状态，1：启用，0未启用，默认为0
     * @return active 启用状态，1：启用，0未启用，默认为0
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 启用状态，1：启用，0未启用，默认为0
     * @param active 启用状态，1：启用，0未启用，默认为0
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