package com.inspur.system.login.dao;

import com.inspur.system.login.DO.RouterModel;
import com.inspur.system.login.VO.RouterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouterModelMapper {
    int insert(RouterModel record);

    int insertSelective(RouterModel record);

    List<RouterVO> listModules(String moduleId);
}