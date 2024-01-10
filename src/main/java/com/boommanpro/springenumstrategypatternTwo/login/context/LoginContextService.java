package com.boommanpro.springenumstrategypatternTwo.login.context;

import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;

/**
 * @ClassName: LoginContextService
 * @Description: 登录上下文
 * @Author: wang xiao le
 * @Date: 2024/01/10 20:57
 **/
public interface LoginContextService {
    /**
     * 普通移动端登录
     *
     * @param loginInfo
     * @param loginType
     * @Author wxl
     * @Date 2024-01-10
     **/
    void login(LoginInfo loginInfo,String loginType);

    /**
     * 普通pc端登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void pcLogin(LoginInfo loginInfo,String loginType);

    /**
     * 量盾登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void quantumLogin(LoginInfo loginInfo,String loginType);

    /**
     * pc盾登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void pcQuantumLogin(LoginInfo loginInfo,String loginType);
}
