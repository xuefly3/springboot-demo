package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * @version 5.0 since 2020-01-15
 */
@RequestMapping("/producer")
@RestController
public class ProducerController {

    @Autowired
    private UserService userService;

    @GetMapping("/get_user")
    @ApiOperation(value="get_user",httpMethod = "GET",notes="test get_user",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser(){
        return userService.selectAll();
    }
}
