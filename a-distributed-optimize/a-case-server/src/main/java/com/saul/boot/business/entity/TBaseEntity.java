package com.saul.boot.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "数据状态", description = "数据状态")
public abstract class TBaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7582664785863208598L;
	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "创建者用户ID")
	@TableField(fill = FieldFill.INSERT)
	private Long createrId;
	
	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;
	
	@ApiModelProperty(value = "修改人用户ID")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long modifierId;
	
	@ApiModelProperty(value = "修改时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date modifyDate;
	
	@ApiModelProperty(value = "是否删除： 0=未删除 1=删除",allowableValues= "range(0, 1)",example="0")
	@JsonIgnore
    @TableLogic
	private Integer isDeleted;
}
