package com.saul.boot.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saul.boot.business.entity.CoreUserDTO;
import com.saul.boot.business.entity.CoreUserVO;
import com.saul.boot.business.entity.page.PageInfo;
import com.saul.boot.business.entity.page.PageQuery;
import com.saul.boot.business.mapper.UserMapper;
import com.saul.boot.business.model.dto.UserDTO;
import com.saul.boot.business.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author luozm
 * @since 2020-06-30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, CoreUserVO> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String hello(Long id) {
        return "hello---" + id;
    }

    @Override
    public String post(UserDTO userDTO) {
        return "hello" + userDTO.getUnitName();
    }
    @Override
    public PageInfo<CoreUserVO> getPageList(PageQuery<CoreUserDTO> query) {
        PageInfo<CoreUserVO> coreUserVONcPageInfo = userMapper.getPageList(query).toPageInfo(CoreUserVO.class);
        return coreUserVONcPageInfo;
    }
}
