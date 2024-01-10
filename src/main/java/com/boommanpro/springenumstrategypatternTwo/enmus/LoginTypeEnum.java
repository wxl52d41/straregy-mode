package com.boommanpro.springenumstrategypatternTwo.enmus;

import lombok.Getter;

/**
 * 题目类型枚举
 * 1单选 2多选 3判断 4简答
 * @author: ChickenWing
 * @date: 2023/10/3
 */
@Getter
public enum LoginTypeEnum {

    PASSWORD("password","密码登录"),
    CAPTCHA("captcha","验证码登录"),
    FREE("free","免密登录"),
    ;

    public String code;

    public String desc;

    LoginTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static LoginTypeEnum getByCode(String codeVal){
        for(LoginTypeEnum resultCodeEnum : LoginTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
