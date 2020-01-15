package com.example.demo.controller;
import com.example.demo.schedule.job.SimpleJob;
import com.example.demo.service.JobScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RestController
@Api(value = "SwaggerValue", tags={"SwaggerController"},description = "swagger应用",  produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController {
    @Resource
    private JobScheduleService jobScheduleService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value="hello",httpMethod = "GET",notes="hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello() {
        return "hello world";
    }

    @RequestMapping(value = "/scheduleSimpleJob", method = RequestMethod.POST)
    @ApiOperation(value="scheduleSimpleJob",httpMethod = "POST",notes="scheduleSimpleJob",produces = MediaType.APPLICATION_JSON_VALUE)
    public void scheduleSimpleJob() {
        jobScheduleService.addSimpleJob(SimpleJob.class,
                "simpleJob", "simpleJob", new Date(), null);
    }

}
