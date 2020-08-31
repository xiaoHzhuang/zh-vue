package com.inspur.utils;

import com.inspur.system.login.DO.SystemUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUserUtils {


    public static SystemUserDetail getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SystemUserDetail SystemUserDetail = null;
        if ((principal instanceof SystemUserDetail)) {
            SystemUserDetail = (SystemUserDetail) principal;
        }
        return SystemUserDetail;
    }
}
