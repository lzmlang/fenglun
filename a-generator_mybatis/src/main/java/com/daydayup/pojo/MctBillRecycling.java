package com.daydayup.pojo;

import java.util.Date;

public class MctBillRecycling {
    /**
     * 账单回收信息id
     */
    private Long billRecyclingId;

    /**
     * 客户名称关键字
     */
    private String nameKeyword;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 账单回收信息id
     * @return BILL_RECYCLING_ID 账单回收信息id
     */
    public Long getBillRecyclingId() {
        return billRecyclingId;
    }

    /**
     * 账单回收信息id
     * @param billRecyclingId 账单回收信息id
     */
    public void setBillRecyclingId(Long billRecyclingId) {
        this.billRecyclingId = billRecyclingId;
    }

    /**
     * 客户名称关键字
     * @return NAME_KEYWORD 客户名称关键字
     */
    public String getNameKeyword() {
        return nameKeyword;
    }

    /**
     * 客户名称关键字
     * @param nameKeyword 客户名称关键字
     */
    public void setNameKeyword(String nameKeyword) {
        this.nameKeyword = nameKeyword == null ? null : nameKeyword.trim();
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     * @return CREATE_BY 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 更新时间
     * @return UPDATE_TIME 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新人
     * @return UPDATE_BY 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}