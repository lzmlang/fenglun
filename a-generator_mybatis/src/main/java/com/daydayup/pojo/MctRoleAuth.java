package com.daydayup.pojo;

import java.util.Date;

public class MctRoleAuth {
    /**
     * 主键id
     */
    private Long roleAuthId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单权限ID
     */
    private Long authId;

    /**
     * 新增 0为有效,1为无效
     */
    private Boolean addStatus;

    /**
     *  修改 0为有效,1为无效
     */
    private Boolean deleteStatus;

    /**
     * 删除 0为有效,1为无效
     */
    private Boolean updateStatus;

    /**
     * 查询0为有效,1为无效
     */
    private Boolean queryStatus;

    /**
     * 导出0为有效,1为无效
     */
    private Boolean exportStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 主键id
     * @return role_auth_id 主键id
     */
    public Long getRoleAuthId() {
        return roleAuthId;
    }

    /**
     * 主键id
     * @param roleAuthId 主键id
     */
    public void setRoleAuthId(Long roleAuthId) {
        this.roleAuthId = roleAuthId;
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 菜单权限ID
     * @return auth_id 菜单权限ID
     */
    public Long getAuthId() {
        return authId;
    }

    /**
     * 菜单权限ID
     * @param authId 菜单权限ID
     */
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * 新增 0为有效,1为无效
     * @return add_status 新增 0为有效,1为无效
     */
    public Boolean getAddStatus() {
        return addStatus;
    }

    /**
     * 新增 0为有效,1为无效
     * @param addStatus 新增 0为有效,1为无效
     */
    public void setAddStatus(Boolean addStatus) {
        this.addStatus = addStatus;
    }

    /**
     *  修改 0为有效,1为无效
     * @return delete_status  修改 0为有效,1为无效
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *  修改 0为有效,1为无效
     * @param deleteStatus  修改 0为有效,1为无效
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 删除 0为有效,1为无效
     * @return update_status 删除 0为有效,1为无效
     */
    public Boolean getUpdateStatus() {
        return updateStatus;
    }

    /**
     * 删除 0为有效,1为无效
     * @param updateStatus 删除 0为有效,1为无效
     */
    public void setUpdateStatus(Boolean updateStatus) {
        this.updateStatus = updateStatus;
    }

    /**
     * 查询0为有效,1为无效
     * @return query_status 查询0为有效,1为无效
     */
    public Boolean getQueryStatus() {
        return queryStatus;
    }

    /**
     * 查询0为有效,1为无效
     * @param queryStatus 查询0为有效,1为无效
     */
    public void setQueryStatus(Boolean queryStatus) {
        this.queryStatus = queryStatus;
    }

    /**
     * 导出0为有效,1为无效
     * @return export_status 导出0为有效,1为无效
     */
    public Boolean getExportStatus() {
        return exportStatus;
    }

    /**
     * 导出0为有效,1为无效
     * @param exportStatus 导出0为有效,1为无效
     */
    public void setExportStatus(Boolean exportStatus) {
        this.exportStatus = exportStatus;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
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
     * @return create_by 创建人
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
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     * @return update_by 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改人
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}