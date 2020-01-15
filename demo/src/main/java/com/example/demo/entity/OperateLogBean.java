package com.example.demo.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
@Data
public class OperateLogBean {
    private String type;

    private String operateObj;

    private boolean result;
}
