package com.inspur.system.security.controller;

import com.inspur.system.response.ResponseCode;
import com.inspur.system.response.ServerResponse;
import com.inspur.constant.TokenConstant;
import com.inspur.system.security.DO.SystemUser;
import com.inspur.system.security.DO.SystemUserDetail;
import com.inspur.system.security.VO.LoginUserVO;
import com.inspur.system.security.service.IUserService;
import com.inspur.system.security.token.TokenRedisUtil;
import com.inspur.system.utils.LoginUserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {
    @Autowired
    private TokenRedisUtil tokenRedisUtil;

    @Autowired
    private IUserService userService;


    @RequestMapping("login")
    public ServerResponse<LoginUserVO> login(HttpServletRequest request) {
        String token = (String) request.getAttribute(TokenConstant.TOKEN_HEADER);
        String userName = (String) request.getAttribute("userCaption");
        return ServerResponse.createBySuccess(new LoginUserVO(token, userName));
    }

    @RequestMapping("logOut")
    public ServerResponse<String> logOut(HttpServletResponse response) {
        Map<String, Object> rsMap = new HashMap<String, Object>(2);
        SystemUserDetail systemUserDetail = LoginUserUtil.getCurrentUser();
        if (tokenRedisUtil.hasTokenKey(systemUserDetail.getUserId())) {
            tokenRedisUtil.deleteToken(systemUserDetail.getUserId());
        }
        return ServerResponse.createBySuccess(String.valueOf(ResponseCode.RE_LOGIN.getCode()));
    }


    @RequestMapping("register")
    public ServerResponse<String> regiser(@RequestBody SystemUser user) {
        userService.regiser(user);
        return ServerResponse.createBySuccess("注册成功");
    }


    @RequestMapping("pwd/retrieve")
    public ServerResponse<String> retrievePwd(@RequestParam("mail") String mailReceiver) throws Exception {
        userService.retrievePwd(mailReceiver);
        return ServerResponse.createBySuccess("发送邮件成功");
    }
}
