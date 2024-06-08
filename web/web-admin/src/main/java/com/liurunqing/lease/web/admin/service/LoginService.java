package com.liurunqing.lease.web.admin.service;

import com.liurunqing.lease.web.admin.vo.login.CaptchaVo;
import com.liurunqing.lease.web.admin.vo.login.LoginVo;
import com.liurunqing.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getUserInfo();
}
