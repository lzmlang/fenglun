package com.saul.boot.business.controller;


import com.saul.boot.business.entity.CoreUserDTO;
import com.saul.boot.business.entity.CoreUserVO;
import com.saul.boot.business.entity.WrappedResult;
import com.saul.boot.business.entity.page.PageInfo;
import com.saul.boot.business.entity.page.PageQuery;
import com.saul.boot.business.model.LogDeviceId;
import com.saul.boot.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author luozm
 * @since 2020-06-30
 */
@RestController
@RequestMapping("/user/")
@Api(value = "人员管理", tags = "用户管理")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<Boolean> add() {
        return null;
    }

    @ApiOperation("修改用户")
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<Boolean> update() {
        return null;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<Boolean> delete() {
        return null;
    }

    @ApiOperation("获取用户")
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<CoreUserVO> get() {
        return null;
    }

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/get_page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<PageInfo<CoreUserVO>> getPageList(@RequestBody PageQuery<CoreUserDTO> query) {
        return WrappedResult.success(userService.getPageList(query));
    }

    @ApiOperation("测试表单提交")
    @RequestMapping(value = "/test_form", method = RequestMethod.POST)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<String> TestForm(String userId, CoreUserDTO coreUserDTO) {
        return new WrappedResult<String>("success");
    }

    @ApiOperation("测试表单提交")
    @RequestMapping(value = "/test_form2", method = RequestMethod.POST)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    public WrappedResult<String> TestForm(String userId, @RequestBody List<LogDeviceId> logDeviceIdList) {
        return new WrappedResult<String>("success");
    }
}

