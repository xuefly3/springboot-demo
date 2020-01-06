package com.example.demo.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
@Data
@Getter
@Setter
public class User {
    private String id;
    private String userName;
    private String userPasswd;
    private Integer userType;
    private String userPhone;
    private String userMailbox;
    private Integer userSafeState;
    private String userSafeAddress;
    private Integer userLoginCount;
    private Date userLoginTime;
    private Integer userExpiryDateCount;
    private Date userExpiryDate;
    private Integer userPassExpiryDateCount;
    private Date userPassExpiryDate;
    private Integer userSessionTime;
    private Date userCreateTime;
    private String userDetails;
}