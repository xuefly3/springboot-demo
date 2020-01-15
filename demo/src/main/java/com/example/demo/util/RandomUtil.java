package com.example.demo.util;
import java.util.Random;

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
 * @version 5.0 since 2019-12-18
 */
public class RandomUtil {
    public static String getRandomCode() {
        StringBuilder stringBuffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            //生成[0,bound)的随机整数
            int num = random.nextInt(10);
            //将随机数加入可变长字符串
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }
}
