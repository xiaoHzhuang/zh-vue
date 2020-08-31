package com.inspur.system.login.service;

import com.inspur.system.login.DO.SystemUser;

public interface IUserService {
    void regiser(SystemUser user);

    void retrievePwd(String mailReceiver) throws Exception;
}
