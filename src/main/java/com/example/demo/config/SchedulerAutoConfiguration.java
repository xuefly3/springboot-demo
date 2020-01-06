package com.example.demo.config;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

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
 * @version 5.0 since 2019-12-19
 */
@Configuration
public class SchedulerAutoConfiguration {

    //这个地方如果需要使用自定义的executor，可以在别的地方配置好，然后这里注入
    //@Autowired
    //private ThreadPoolTaskExecutor taskExecutor;


    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setAutoStartup(true);
        //这里如果不配置任务池，它就会默认加载SimpleThreadPool
        //factory.setTaskExecutor();
        return factory;
    }

    @Bean(name="funnyScheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }
}
