package com.inspur.system.login.service.impl;

import com.inspur.system.login.VO.RouterVO;
import com.inspur.system.login.dao.RouterModelMapper;
import com.inspur.system.login.service.IRouterModelService;
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
