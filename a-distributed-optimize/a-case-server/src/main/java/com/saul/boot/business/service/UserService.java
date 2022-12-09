package com.saul.boot.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.saul.boot.business.entity.CoreUserDTO;
import com.saul.boot.business.entity.CoreUserVO;
import com.saul.boot.business.entity.page.PageInfo;
import com.saul.boot.business.entity.page.PageQuery;
import com.saul.boot.business.model.dto.UserDTO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author luozm
 * @since 2020-06-30
 */
public interface UserService extends IService<CoreUserVO> {
    /**
     * 功能描述: hello
     *
     * @Param: [id]
     * @Return: com.nsc.boot.common.msg.Result<java.lang.Boolean>
     * @Author: luo_zm
     * @Date: 2020/9/5 15:41
     */
    String hello(Long id);

    String post(UserDTO userDTO);

    PageInfo<CoreUserVO> getPageList(PageQuery<CoreUserDTO> query);

}

