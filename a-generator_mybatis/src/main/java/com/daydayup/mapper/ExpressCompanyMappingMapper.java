package com.daydayup.mapper;

import com.daydayup.pojo.ExpressCompanyMapping;

public interface ExpressCompanyMappingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExpressCompanyMapping record);

    int insertSelective(ExpressCompanyMapping record);

    ExpressCompanyMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExpressCompanyMapping record);

    int updateByPrimaryKey(ExpressCompanyMapping record);
}