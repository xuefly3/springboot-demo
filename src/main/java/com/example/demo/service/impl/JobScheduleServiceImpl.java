package com.example.demo.service.impl;
import com.example.demo.service.JobScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
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
 * @version 5.0 since 2019-12-19
 */
@Service
@Slf4j
public class JobScheduleServiceImpl implements JobScheduleService {

    /**
     * 因为在配置中设定了这个bean的名称，这里就需要指定bean的名称，不然启动就会报错
     */
    @Autowired
    @Qualifier("funnyScheduler")
    private Scheduler scheduler;

    /**
     * 功能描述: 添加简单任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void addSimpleJob(Class taskClass, String jobName, String jobGroup, Date startTime, Date endTime) {
        JobDetail jobDetail = JobBuilder.newJob(taskClass).withIdentity(jobName, jobGroup).build();
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, jobGroup)
                .startAt(startTime)
                .endAt(endTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)
                        .withRepeatCount(5))
                .build();
        try {
            scheduler.scheduleJob(jobDetail, simpleTrigger);
        } catch (SchedulerException e) {
            log.error("addSimpleJob catch {}", e.getMessage());
        }
    }

    /**
     * 功能描述: 添加定时任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void addCronJob(Class taskClass, String jobName, String jobGroup, Date startTime, Date endTime, String cronExpression) {
        JobDetail jobDetail = JobBuilder.newJob(taskClass).withIdentity(jobName, jobGroup).build();
        // 触发器

        try {
            CronTrigger trigger = new CronTriggerImpl(jobName, jobGroup, jobName, jobGroup, startTime, endTime, cronExpression);// 触发器名,触发器组
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException | ParseException e) {
            log.error("addCronJob catch {}", e.getMessage());
        }
    }

    /**
     * 功能描述: 修改任务Trigger，即修改任务的定时机制
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void modifyJob(String jobName, String jobGroup, String cronExpression) {
        TriggerKey oldKey = new TriggerKey(jobName, jobGroup);
        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().
                withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder).build();
        try {
            scheduler.rescheduleJob(oldKey, trigger);
        } catch (SchedulerException e) {
            log.error("modifyJob catch {}", e.getMessage());
        }
    }

    /**
     * 功能描述: 暂停任务，只支持定时任务的暂停，不支持单次任务，单次任务需要interrupt
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void pauseJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (StringUtils.isEmpty(jobDetail)) {
                System.out.println("没有这个job");
            }
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error("pauseJob catch {}", e.getMessage());
        }
    }

    /**
     * 功能描述: 从暂停状态中恢复定时任务运行
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void resumeJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error("resumeJob catch {}", e.getMessage());
        }
    }

    /**
     * 功能描述: 删除任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    @Override
    public void deleteJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            log.error("deleteJob catch {}", e.getMessage());
        }
    }
}
