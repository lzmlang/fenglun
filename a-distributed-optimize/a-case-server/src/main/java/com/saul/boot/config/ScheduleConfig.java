package com.saul.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author 枫伦
 * @DESCRIPTION schedule定时任务配置异步的线程池
 * @create 2021/1/8 11:33 上午
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setTaskScheduler(poolTaskScheduler());
        taskRegistrar.setScheduler(threadPoolTaskScheduler());
    }

    @Bean(name = "taskScheduler", destroyMethod = "shutdown")
    public ScheduledThreadPoolExecutor threadPoolTaskScheduler() {
//        ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
//        poolTaskScheduler.setPoolSize(Runtime.getRuntime().availableProcessors() * 5);
//        return poolTaskScheduler;
        return new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 5);
    }

}