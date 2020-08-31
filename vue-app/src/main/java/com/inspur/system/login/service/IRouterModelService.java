package com.inspur.system.login.service;


import com.inspur.system.login.VO.RouterVO;

import java.util.List;

public interface IRouterModelService {
    List<RouterVO> listModules(String moduleId);
}
