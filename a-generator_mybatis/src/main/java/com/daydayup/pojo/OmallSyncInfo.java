package com.daydayup.pojo;

import java.util.Date;

public class OmallSyncInfo {
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
     * 是否开启订单同步 1：是，0：否
     */
    private Boolean itemSyncStatus;

    /**
     * 是否开启订单同步 1：是，0：否
     */
    private Boolean tradeSyncStatus;

    /**
     * 最后一次订单同步时间
     */
    private Date lastImportTradeTime;

    /**
     * 最后一次商品同步时间
     */
    private Date lastImportItemTime;

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
     * 是否开启订单同步 1：是，0：否
     * @return item_sync_status 是否开启订单同步 1：是，0：否
     */
    public Boolean getItemSyncStatus() {
        return itemSyncStatus;
    }

    /**
     * 是否开启订单同步 1：是，0：否
     * @param itemSyncStatus 是否开启订单同步 1：是，0：否
     */
    public void setItemSyncStatus(Boolean itemSyncStatus) {
        this.itemSyncStatus = itemSyncStatus;
    }

    /**
     * 是否开启订单同步 1：是，0：否
     * @return trade_sync_status 是否开启订单同步 1：是，0：否
     */
    public Boolean getTradeSyncStatus() {
        return tradeSyncStatus;
    }

    /**
     * 是否开启订单同步 1：是，0：否
     * @param tradeSyncStatus 是否开启订单同步 1：是，0：否
     */
    public void setTradeSyncStatus(Boolean tradeSyncStatus) {
        this.tradeSyncStatus = tradeSyncStatus;
    }

    /**
     * 最后一次订单同步时间
     * @return last_import_trade_time 最后一次订单同步时间
     */
    public Date getLastImportTradeTime() {
        return lastImportTradeTime;
    }

    /**
     * 最后一次订单同步时间
     * @param lastImportTradeTime 最后一次订单同步时间
     */
    public void setLastImportTradeTime(Date lastImportTradeTime) {
        this.lastImportTradeTime = lastImportTradeTime;
    }

    /**
     * 最后一次商品同步时间
     * @return last_import_item_time 最后一次商品同步时间
     */
    public Date getLastImportItemTime() {
        return lastImportItemTime;
    }

    /**
     * 最后一次商品同步时间
     * @param lastImportItemTime 最后一次商品同步时间
     */
    public void setLastImportItemTime(Date lastImportItemTime) {
        this.lastImportItemTime = lastImportItemTime;
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