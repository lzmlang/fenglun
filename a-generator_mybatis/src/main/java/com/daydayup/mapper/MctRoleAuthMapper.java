package com.daydayup.mapper;

import com.daydayup.pojo.MctRoleAuth;

public interface MctRoleAuthMapper {
    int deleteByPrimaryKey(Long roleAuthId);

    int insert(MctRoleAuth record);

    int insertSelective(MctRoleAuth record);

    MctRoleAuth selectByPrimaryKey(Long roleAuthId);

    int updateByPrimaryKeySelective(MctRoleAuth record);

    int updateByPrimaryKey(MctRoleAuth record);
}