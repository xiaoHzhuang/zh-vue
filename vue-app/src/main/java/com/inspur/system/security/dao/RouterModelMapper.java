package com.inspur.system.security.dao;

import com.inspur.system.security.DO.RouterModel;
import com.inspur.system.security.VO.RouterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouterModelMapper {
    int insert(RouterModel record);

    int insertSelective(RouterModel record);

    List<RouterVO> listModules(String moduleId);
}