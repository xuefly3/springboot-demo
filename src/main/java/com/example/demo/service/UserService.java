package com.example.demo.service;
import com.example.demo.entity.User;

import java.util.List;

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
public interface UserService {
    List<User> selectAll();

    User getOne(String id);

    void delete(String id);

    void insert(User user);

    void update(User user);
}
