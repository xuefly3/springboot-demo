package com.example.demo.schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类功能描述：<br>
 * <ul>
 * <li>类功能描述1<br>
 * <li>类功能描述2<br>
 * <li>类功能描述3<br>
 * <li>#cron 的表达式：
 *（1）0 0 2 1 * ? *   表示在每月的1日的凌晨2点调整任务
 *
 *（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
 *
 *（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作
 *
 *（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点
 *
 *（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
 *
 *（6）0 0 12 ? * WED    表示每个星期三中午12点
 *
 *（7）0 0 12 * * ?   每天中午12点触发
 *
 *（8）0 15 10 ? * *    每天上午10:15触发
 *
 *（9）0 15 10 * * ?     每天上午10:15触发
 *
 *（10）0 15 10 * * ? *    每天上午10:15触发
 *
 *（11）0 15 10 * * ? 2005    2005年的每天上午10:15触发
 *
 *（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发
 *
 *（13）0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发
 *
 *（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 *
 *（15）0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发
 *
 *（16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发
 *
 *（17）0 15 10 ? * MON-FRI    周一至周五的上午10:15触发
 *
 *（18）0 15 10 15 * ?    每月15日上午10:15触发
 *
 *（19）0 15 10 L * ?    每月最后一日的上午10:15触发
 *
 *（20）0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发
 *
 *（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发
 *
 *（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发<br>
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
@Component
@Slf4j
public class TestSchedule {

    @Scheduled(fixedRate = 10 * 1000, initialDelay = 5000)  //采用间隔调度，每10秒执行一次
    public void runJoba(){ //定义一个执行的任务
        log.info("[*******MyTaskA -- 间隔调度 ******]"+
                new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

    @Scheduled(cron = "*/10 * * * * ?")  //采用间隔调度，每10秒执行一次
    public void runJobb(){ //定义一个执行的任务
        log.info("[*******MyTaskB -- 间隔调度 ******]"+
                new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

}
