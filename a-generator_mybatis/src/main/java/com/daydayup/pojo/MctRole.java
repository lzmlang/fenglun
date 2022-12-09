package com.daydayup.pojo;

import java.util.Date;

public class MctRole {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 删除标识(1已删除 0未删除)
     */
    private Boolean roleStatus;

    /**
     * 是否脱敏(1:脱敏;0:不脱敏)
     */
    private Boolean desensitionFlag;

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
     * 角色ID
     * @return ROLE_ID 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色名称
     * @return ROLE_NAME 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 描述
     * @return DESCRIPTION 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 删除标识(1已删除 0未删除)
     * @return ROLE_STATUS 删除标识(1已删除 0未删除)
     */
    public Boolean getRoleStatus() {
        return roleStatus;
    }

    /**
     * 删除标识(1已删除 0未删除)
     * @param roleStatus 删除标识(1已删除 0未删除)
     */
    public void setRoleStatus(Boolean roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 是否脱敏(1:脱敏;0:不脱敏)
     * @return DESENSITION_FLAG 是否脱敏(1:脱敏;0:不脱敏)
     */
    public Boolean getDesensitionFlag() {
        return desensitionFlag;
    }

    /**
     * 是否脱敏(1:脱敏;0:不脱敏)
     * @param desensitionFlag 是否脱敏(1:脱敏;0:不脱敏)
     */
    public void setDesensitionFlag(Boolean desensitionFlag) {
        this.desensitionFlag = desensitionFlag;
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
     * 修改时间
     * @return UPDATE_TIME 修改时间
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
     * @return UPDATE_BY 修改人
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