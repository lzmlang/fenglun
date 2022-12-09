package com.daydayup.mapper;

import com.daydayup.pojo.MctRole;

public interface MctRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(MctRole record);

    int insertSelective(MctRole record);

    MctRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(MctRole record);

    int updateByPrimaryKey(MctRole record);
}