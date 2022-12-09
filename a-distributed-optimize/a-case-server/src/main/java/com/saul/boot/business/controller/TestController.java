package com.saul.boot.business.controller;


import com.alibaba.fastjson.JSON;
import com.saul.boot.business.entity.CoreUserDTO;
import com.saul.boot.business.entity.WrappedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author luozm
 * @since 2020-06-30
 */
@Controller
@RequestMapping("/form/")
@Api(value = "测试表单提交")
@Slf4j
public class TestController {
    @ApiOperation("测试表单提交")
    @RequestMapping(value = "test_form", method = RequestMethod.POST)
    @ApiResponse(code = 200, message = "成功为true,失败为false", response = WrappedResult.class)
    @ResponseBody
    public WrappedResult<String> TestForm(String userId, CoreUserDTO coreUserDTO) {
        log.info(userId);
        log.info(JSON.toJSONString(coreUserDTO));
        return new WrappedResult<String>("success");
    }

}

