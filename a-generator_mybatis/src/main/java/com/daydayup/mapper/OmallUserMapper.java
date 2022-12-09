package com.daydayup.mapper;

import com.daydayup.pojo.OmallUser;

public interface OmallUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmallUser record);

    int insertSelective(OmallUser record);

    OmallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmallUser record);

    int updateByPrimaryKey(OmallUser record);
}