package com.wuhunyu.mapper;

import com.wuhunyu.pojo.DataDic;

public interface DataDicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    DataDic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);
}