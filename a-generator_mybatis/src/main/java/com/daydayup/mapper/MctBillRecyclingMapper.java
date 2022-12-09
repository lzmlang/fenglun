package com.daydayup.mapper;

import com.daydayup.pojo.MctBillRecycling;

public interface MctBillRecyclingMapper {
    int deleteByPrimaryKey(Long billRecyclingId);

    int insert(MctBillRecycling record);

    int insertSelective(MctBillRecycling record);

    MctBillRecycling selectByPrimaryKey(Long billRecyclingId);

    int updateByPrimaryKeySelective(MctBillRecycling record);

    int updateByPrimaryKey(MctBillRecycling record);
}