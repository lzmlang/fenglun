package com.daydayup.mapper;

import com.daydayup.pojo.OmallSyncInfo;

public interface OmallSyncInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmallSyncInfo record);

    int insertSelective(OmallSyncInfo record);

    OmallSyncInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmallSyncInfo record);

    int updateByPrimaryKey(OmallSyncInfo record);
}