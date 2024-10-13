package com.boommanpro.springenumstrategypatternThree.enmus;

import lombok.Getter;

/**
 * 认证方式枚举
 *
 * @author wangxiaole
 * @version 1.0.0
 * @ClassName: AuthTypeEnum
 * @date 2024/01/11
 **/
@Getter
public enum AuthTypeEnum {

    QCT_PASSWORD("qct_password", "密码"),
    MOBILE("mobile", "验证码");
    public final String code;
    public final String desc;

    AuthTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AuthTypeEnum getByCode(String codeVal) {
        for (AuthTypeEnum resultCodeEnum : AuthTypeEnum.values()) {
            if (resultCodeEnum.code.equals(codeVal)) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
