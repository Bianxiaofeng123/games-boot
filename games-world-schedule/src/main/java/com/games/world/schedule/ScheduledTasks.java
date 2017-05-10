package com.games.world.schedule;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	// private Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	/**
	 * 部署环境变量 无：本机 dev:测试环境 prod:生产环境
	 */
	@Value("${spring.profiles.active}")
	private String activeProfile;

	/**
	 * 定时执行
	 * 
	 * @throws Exception
	 */
	// @Scheduled(cron = "0/5 * * * * ? ") // 每5秒执行一次
	public void batchCaclIncome() throws Exception {
		System.out.println("weqwewqeee");
	}

}