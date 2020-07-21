package com.inspur.system.security.service;

import com.inspur.system.security.DO.SystemUser;

public interface IUserService {
    void regiser(SystemUser user);

    void retrievePwd(String mailReceiver) throws Exception;
}
