package com.example.demo.controller;
import com.example.demo.kafka.KafkaProducer;
import com.example.demo.rabbitmq.MsgProducer;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/kafka")
@Controller
@Slf4j
@Api(value = "SwaggerValue", tags={"KafkaController"},description = "swagger应用",  produces = MediaType.APPLICATION_JSON_VALUE)
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "/send")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public void sendMsg(){
        kafkaProducer.send("this is a test kafka topic message!");
    }

}
