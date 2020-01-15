package com.example.demo.controller;
import com.example.demo.annotation.OperateLog;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RestController
@Api(value = "SwaggerValue", tags={"SwaggerController"},description = "swagger应用",  produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ApiOperation(value="users",httpMethod = "GET",notes="users",produces = MediaType.APPLICATION_JSON_VALUE)
    @OperateLog(type = "select", operateObj = "user_list")
    public List<User> selectAll() {
        return userService.selectAll();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ApiOperation(value="user",httpMethod = "GET",notes="user",produces = MediaType.APPLICATION_JSON_VALUE)
    @OperateLog(type = "select", operateObj = "user")
    public User getOne(@PathVariable("id") String id) {
        return userService.getOne(id);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value="delete user",httpMethod = "DELETE",notes="delete user",produces = MediaType.APPLICATION_JSON_VALUE)
    @OperateLog(type = "delete", operateObj = "user")
    public void deleteUser(@ApiParam(name="id",value="id",required=true) @PathVariable("id") String id) {
        userService.delete(id);
    }

    /**
     * 新增
     *
     * @param user
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation(value="insert user",httpMethod = "POST",notes="insert user",produces = MediaType.APPLICATION_JSON_VALUE)
    @OperateLog(type = "add", operateObj = "user")
    public void addUser(@ApiParam(name="user",value="user",required=true) @RequestBody User user) {
        userService.insert(user);
    }

    /**
     * 更新
     *
     * @param user
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ApiOperation(value="update user",httpMethod = "PUT",notes="update user",produces = MediaType.APPLICATION_JSON_VALUE)
    @OperateLog(type = "update", operateObj = "user")
    public void updateUser(@ApiParam(name="user",value="user",required=true) @RequestBody User user) {
        userService.update(user);
    }

}
