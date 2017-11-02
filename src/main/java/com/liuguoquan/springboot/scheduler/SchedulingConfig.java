package com.liuguoquan.springboot.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Descriptions: 定时任务
 *
 * Created by liuguoquan on 2017/11/1
 */
//@Component
//@EnableScheduling
public class SchedulingConfig {

  private final Logger logger =
      LogManager.getLogger(SchedulingConfig.class);

  @Scheduled(fixedRate = 3000L)
  public void scheduler() {
    logger.info("scheduler fixedRate");
  }
}
