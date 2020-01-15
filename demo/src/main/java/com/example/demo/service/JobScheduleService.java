package com.example.demo.service;
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
public interface JobScheduleService {

    /**
     * 功能描述: 添加简单任务
     * 可以自定义一个任务信息对象，然后从信息对象中获取参数创建简单任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void addSimpleJob(Class taskClass, String jobName, String jobGroup, Date startTime, Date endTime);

    /**
     * 功能描述: 添加定时任务
     * 可以自定义一个任务信息对象，然后从信息对象中获取参数创建定时任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void addCronJob(Class taskClass, String jobName, String jobGroup, Date startTime, Date endTime, String cronExpression);

    /**
     * 功能描述: 修改任务Trigger，即修改任务的定时机制
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void modifyJob(String jobName, String jobGroup, String cronExpression);

    /**
     * 功能描述: 暂停任务，只支持定时任务的暂停，不支持单次任务，单次任务需要interrupt
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void pauseJob(String jobName, String jobGroup);

    /**
     * 功能描述: 从暂停状态中恢复定时任务运行
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void resumeJob(String jobName, String jobGroup);

    /**
     * 功能描述: 删除任务
     *
     * @param
     * @return:void
     * @since: v1.0
     * @Author:xf
     * @Date: 2019/3/15 17:00
     */
    void deleteJob(String jobName, String jobGroup);

}
