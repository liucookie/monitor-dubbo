package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.Dictionary;

import java.util.List;

public interface DictionaryMapper {

    int deleteByPrimaryKey(String dictionaryCode);


    int insert(Dictionary record);


    int insertSelective(Dictionary record);

    /**
     *
     * @param dictionaryCode
     * @return 通过code值查询所需要的
     */

    Dictionary selectByPrimaryKey(String dictionaryCode);

    List<Dictionary>  queryTypeCode(String dictionaryTypeCode);



    int updateByPrimaryKeySelective(Dictionary record);


    int updateByPrimaryKeyWithBLOBs(Dictionary record);


    int updateByPrimaryKey(Dictionary record);
}