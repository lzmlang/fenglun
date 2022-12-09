package com.saul.boot.business.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luo_zm
 * @DESCRIPTION  接收前端所传用户信息参数对象
 * @create 2020/2/4 14:15
 */
@Data
public class UserDTO {

    /**
     * 编号id
     */
    @ApiModelProperty(value = "用户id", example = "1", position = 10)
    private Long id;

    /**
     * 所在单位
     */
    @ApiModelProperty(value = "所在单位id",example = "87",position = 20)
    private Long unitId;

    /**
     * 所在单位
     */
    @ApiModelProperty(value = "所在单位名称",example = "郴州郴能电力有限公司")
    private String unitName;



    /**
     * 部门ID
     */
    @ApiModelProperty(value = "所在部门id",example = "13",position = 30)
    private Long departId;
    /**
     * 所在部门名称
     */
    @ApiModelProperty(value = "所在部门名称",example = "")
    private String departName;

    /**
     * 职务ID
     */
    @ApiModelProperty(value = "职务id",position = 40)
    private Long dutyId;

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名",position = 50)
    private String username;


    @ApiModelProperty(value = "密码", example = "", position = 60)
    private String password;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",position = 70)
    private String name;

    /**
     * 身份证证号
     */
    @ApiModelProperty(value = "身份证号码",position = 80)
    private String idcard;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",position = 90)
    private String email;


    /**
     * 民族
     */
    @ApiModelProperty(value = "民族",position = 100)
    private String nation;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "联系方式",position = 110)
    private String mobile;

    /**
     * 1:开启 0 ：不开启
     */
    @ApiModelProperty(value = "绑定设备",example = "0",position = 120)
    private Boolean bindDev;

    /**
     * 是否隐藏手机号1:不隐藏 2:隐藏
     */
    @ApiModelProperty(value = "是否隐藏手机号",example = "1",position = 130)
    private Boolean hidePhone;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别",position = 140)
    private String sex;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注",position = 150)
    private String remarks;

    /**
     * 紧急联系人姓名
     */
    @ApiModelProperty(value = "紧急联系人姓名",position = 160)
    private String emgContactName;

    /**
     * 紧急联系人电话
     */
    @ApiModelProperty(value = "紧急联系人电话",position = 170)
    private String emgContactTel;

    /**
     * 和本人关系
     */
    @ApiModelProperty(value = "和本人关系",position = 180)
    private String relationShip;

    /**
     * 文化程度
     */
    @ApiModelProperty(value = "文化程度",position = 190)
    private String educationDegree;

    /**
     * 用工形式
     */
    @ApiModelProperty(value = "用工形式",position = 200)
    private String employmentForm;

    /**
     * 参加工作年份（单位：年）
     */
    @ApiModelProperty(value = "参加工作年份",position = 210)
    private Integer firstWorkYear;

    /**
     * 社会保险号
     */
    @ApiModelProperty(value = "社会保险号",position = 220)
    private String socialSecurityNumber;

    /**
     * 职称
     */
    @ApiModelProperty(value = "职称",position = 230)
    private String jobTitle;

    /**
     * 职称证书编号
     */
    @ApiModelProperty(value = "职称证书编号",position = 240)
    private String jobTitleCertNo;

    @ApiModelProperty(value = "技能等级", example = "", position = 250)
    private String skillLevel;

    @ApiModelProperty(value = "技能等级编号", example = "", position = 260)
    private String skillNumber;


    @ApiModelProperty(value = "从事专业", example = "", position = 270)
    private String major;

    @ApiModelProperty(value = "关键岗位名称", example = "", position = 280)
    private String stationName;

    @ApiModelProperty(value = "工作业绩", example = "", position = 290)
    private String jobPerformance;

    @ApiModelProperty(value = "负面清单", example = "", position = 300)
    private String negativeList;

    @ApiModelProperty(value = "是否设总 0：false ,1：true",position = 310)
    private String isDesignDirector;

    @ApiModelProperty(value = "工作年限",position = 320)
    private String designPeriod;

    /**
     * 用户类型(0:开发人员 1.系统超级管理员 2.普通用户；3接口用户)
     */
    @ApiModelProperty(value = "人员类型",position = 330)
    private String userType;

    /**
     * 用户来源
     */
    @ApiModelProperty(value = "人员类型",position = 340)
    private String userFrom;

    /**
     * 安全考试日期
     */
    @ApiModelProperty(value = "安全考试日期",position = 350)
    private String safetyTestDate;

    /**
     * 考试成绩
     */
    @ApiModelProperty(value = "考试成绩",position = 360)
    private String testScore;


    /**
     * 最近一次体检时间
     */
    @ApiModelProperty(value = "最近一次体检时间",position = 400)
    private String lastCheckDate;

    /**
     * 检验结果
     */
    @ApiModelProperty(value = "检验结果",position = 500)
    private String testResult;

    /**
     * 状态
     */
    private Integer status;
}
