package com.saul.boot.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ;luo_zm
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoreUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String password;

    private LocalDateTime createTime;

    private Integer orgId;

    @ApiModelProperty(value = "用户状态 1:启用 0:停用")
    private String state;

    private String jobType1;

    @ApiModelProperty(value = "用户删除标记 0:未删除 1:已删除")
    private Integer delFlag;

    private LocalDateTime updateTime;

    private String jobType0;

    private String attachmentId;


}
