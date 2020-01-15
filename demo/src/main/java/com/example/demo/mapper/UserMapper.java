package com.example.demo.mapper;
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

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userMapper")
public interface UserMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "userPasswd", column = "userPasswd"),
            @Result(property = "userType", column = "userType"),
            @Result(property = "userPhone", column = "userPhone"),
            @Result(property = "userMailbox", column = "userMailbox"),
            @Result(property = "userDetails", column = "userDetails")
    })
    @Select("SELECT * FROM user ")
    List<User> selectAll();
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "userPasswd", column = "userPasswd"),
            @Result(property = "userType", column = "userType"),
            @Result(property = "userPhone", column = "userPhone"),
            @Result(property = "userMailbox", column = "userMailbox"),
            @Result(property = "userDetails", column = "userDetails")
    })
    @Select("SELECT * FROM user WHERE id = #{id} ")
    User getOne(String id);

    @Delete("DELETE FROM user WHERE id =#{id} ")
    void delete(String id);

    @Insert("INSERT INTO user(id,userName,userPasswd,userType,userPhone,userMailbox,userDetails)" +
            " VALUES(#{id}, #{userName}, #{userPasswd}, #{userType},#{userPhone},#{userMailbox},#{userDetails}) ")
    void insert(User user);

    @Update("UPDATE user SET userName=#{userName},userPasswd=#{userPasswd} WHERE id =#{id}")
    void update(User user);
}