package com.inspur.system.login.service.impl;

import com.inspur.system.login.DO.SystemUser;
import com.inspur.system.login.DO.SystemUserDetail;
import com.inspur.system.security.dao.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetailService implements UserDetailsService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserMapper.getUserByUserName(userName);
        return new SystemUserDetail(systemUser);
    }
}
