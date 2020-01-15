package com.example.demo.controller;
import com.example.demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
 * @version 5.0 since 2020-01-02
 */
@RestController
@RequestMapping("/redis")
@Api(value = "SwaggerValue", tags={"SwaggerController"},description = "swagger应用",  produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    //添加
    @RequestMapping(value="/add", method = RequestMethod.GET)
    @ApiOperation(value="redis",httpMethod = "GET",notes="test set redis key",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRedis(){
        return redisUtil.set("a","test");
    }

    //获取
    @GetMapping(value="/get")
    @ApiOperation(value="redis",httpMethod = "GET",notes="test get redis key",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getRedis(){
        return redisUtil.get("a");
    }
}
