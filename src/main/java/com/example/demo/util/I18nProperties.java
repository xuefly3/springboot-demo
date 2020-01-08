package com.example.demo.util;

import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 类功能描述：<br>
 * <ul>
 * <li>类功能描述1<br>
 * <li>类功能描述2<br>
 * <li>类功能描述3<br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li>修改记录描述1<br>
 * <li>修改记录描述2<br>
 * <li>修改记录描述3<br>
 * </ul>
 *
 * @author xuefl
 * @version 5.0 since 2020-01-08
 */
public class I18nProperties {

    private static final String strPro = "properties.msg";

    /**
     * 获取国际化字符串
     * @param strKey
     * @return
     */
    public static String getI18nString(String strKey)
    {
        Locale cn = Locale.CHINA;//中文
        Locale us = Locale.US;//英文

        String lang = "cn";
        try {
            ResourceBundle strI18n = ResourceBundle.getBundle(strPro, cn);
            if (!StringUtils.isEmpty(lang) && "English(en-US)".contains(lang)) {
                strI18n = ResourceBundle.getBundle(strPro, us);
            }
            return strI18n.getString(strKey);
        } catch (Exception e) {
            return strKey;
        }
    }
}
