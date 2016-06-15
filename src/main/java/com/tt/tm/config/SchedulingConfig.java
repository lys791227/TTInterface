package com.tt.tm.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置类
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年3月21日
 */
@Configuration
@EnableScheduling // 启用定时任务
public class SchedulingConfig {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Scheduled(cron = "0/30 * * * * ?") // 每30秒执行一次
	public void scheduler() {
		//logger.info(">>>>>>>>>>>>> scheduled  sendmail... ");

	}

}