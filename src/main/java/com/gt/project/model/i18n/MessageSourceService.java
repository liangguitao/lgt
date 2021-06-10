package com.gt.project.model.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author liangguitao
 * @packageName com.telecomyt.check.platform.common
 * @email liangguitao@telecomyt.com.cn
 * @description 返回提示
 * @createTime 2021年05月10日 11:02:00
 * @Version v1.0.0
 */
@SuppressWarnings("WeakerAccess")
@Component
public class MessageSourceService {

    @Resource
    private MessageSource messageSource;

    /**
     * 根据code获取message
     *
     * @param code code
     * @return msg
     */
    public String getMessage(int code) {
        return getMessage(code, null);
    }

    /**
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @return msg
     */
    public String getMessage(int code, Object[] args) {
        return getMessage(code, args, "");
    }

    /**
     *
     * @param code 对应messages配置的key.
     * @param args 数组参数.
     * @param defaultMessage 没有设置key的时候的默认值.
     * @return msg
     */
    public String getMessage(int code, Object[] args, String defaultMessage) {
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(String.valueOf(code), args, defaultMessage, locale);
    }
}
