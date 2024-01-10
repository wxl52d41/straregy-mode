package com.boommanpro.springenumstrategypatternTwo.login.handler;


import com.boommanpro.springenumstrategypatternTwo.enmus.LoginTypeEnum;
import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;

/**
 * @ClassName: LoginTypeHandler
 * @Description: 登录策略
 * @Author wxl
 * @Date 2024-01-10
 * @Version 1.0.0
 **/
public interface LoginTypeHandler {

    /**
     * 枚举身份的识别
     */
    LoginTypeEnum getHandlerType();

    /**
     * 普通移动端登录
     *
     * @param loginInfo
     * @Author wxl
     * @Date 2024-01-10
     **/
    void login(LoginInfo loginInfo);

    /**
     * 普通pc端登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void pcLogin(LoginInfo loginInfo);

    /**
     * 量盾登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void quantumLogin(LoginInfo loginInfo);

    /**
     * pc盾登录
     *
     * @Author wxl
     * @Date 2024-01-10
     **/
    void pcQuantumLogin(LoginInfo loginInfo);
}
