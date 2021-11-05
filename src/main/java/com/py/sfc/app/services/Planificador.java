package com.py.sfc.app.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;


@Component
public class Planificador {

	    @Autowired
	    private BolsaPuntosService bDao;
	    
		private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
		private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    @Scheduled(fixedRate = 5000)
	    public void atSchedule() throws InterruptedException {
	        //bDao.consultaBolsaVencida();
			//log.info("The time is now {}", dateFormat.format(new Date()));

	    }
	    
}
