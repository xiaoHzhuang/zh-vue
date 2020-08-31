package com.inspur.system.login.controller;

import com.inspur.system.login.VO.RouterVO;
import com.inspur.system.login.service.IRouterModelService;
import com.inspur.system.response.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("routerModule")
public class RouterModuleController {
    @Autowired
    private IRouterModelService routerModuleServiceImpl;

    @RequestMapping("list")
    public ServerResponse<List<RouterVO>> listModules(String moduleId) {
        return ServerResponse.createBySuccess(routerModuleServiceImpl.listModules(moduleId));
    }
}
