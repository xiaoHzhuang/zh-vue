package com.inspur.system.security.service.impl;

import com.inspur.system.security.dao.RouterModelMapper;
import com.inspur.system.security.service.IRouterModelService;
import com.inspur.system.security.VO.RouterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterModelServiceImpl implements IRouterModelService {
    @Autowired
    private RouterModelMapper routerModelMapper;

    @Override
    public List<RouterVO> listModules(String moduleId) {
        return routerModelMapper.listModules(moduleId);
    }
}
