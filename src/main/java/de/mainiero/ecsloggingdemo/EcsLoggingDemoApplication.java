package de.mainiero.ecsloggingdemo;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Date;

@Log4j2
@EnableScheduling
@SpringBootApplication
public class EcsLoggingDemoApplication {

	private static final DateFormat DATE_FORMAT = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);

	public static void main(String[] args) {
		SpringApplication.run(EcsLoggingDemoApplication.class, args);
	}

	@Scheduled(initialDelay = 0, fixedRate = 1000)
	public void log(){
		String currentDate = DATE_FORMAT.format(new Date());
		MDC.put("from-mdc", "with love");
		log.log(Level.INFO, "This is a repeating log message: {}", currentDate);
	}

}