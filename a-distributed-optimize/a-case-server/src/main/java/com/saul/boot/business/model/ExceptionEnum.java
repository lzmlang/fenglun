package com.saul.boot.business.model;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    INVALID_FILE_TYPE(400, "无效的文件类型！"),
    INVALID_PARAM_ERROR(400, "无效的请求参数！"),
    INVALID_PHONE_NUMBER(400, "无效的手机号码"),
    INVALID_VERIFY_CODE(400, "验证码错误！"),
    INVALID_USERNAME_PASSWORD(400, "无效的用户名和密码！"),
    INVALID_SERVER_ID_SECRET(400, "无效的服务id和密钥！"),
    INVALID_NOTIFY_PARAM(400, "回调参数有误！"),
    INVALID_NOTIFY_SIGN(400, "回调签名有误！"),
    CATEGORY_NOT_FOUND(404, "数据不存在！"),
    DATA_TRANSFER_ERROR(500, "数据转换异常！"),
    INSERT_OPERATION_FAIL(500, "新增操作失败！"),
    UPDATE_OPERATION_FAIL(500, "更新操作失败！"),
    DELETE_OPERATION_FAIL(500, "删除操作失败！"),
    FILE_UPLOAD_ERROR(500, "文件上传失败！"),
    DIRECTORY_WRITER_ERROR(500, "目录写入失败！"),
    FILE_WRITER_ERROR(500, "文件写入失败！"),
    SEND_MESSAGE_ERROR(500, "短信发送失败！"),
    INVALID_CHECK_STATUS(500, "审核状态不正确！"),
    FEIGN_CLIENT_STATUS(500, "远程接口调用失败"),
    IMPORT_FAIL(500, "导入失败"),
    IMPORT_IS_NULL(500, "导入数据为空"),

    MODIFY_UNIT_ADMIN(500,"管理员账号修改失败"),

    UNAUTHORIZED(401, "登录失效或未登录！");

    private int code;
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
