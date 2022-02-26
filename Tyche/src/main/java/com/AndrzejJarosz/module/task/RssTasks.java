package com.AndrzejJarosz.module.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RssTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(RssTasks.class);

    private static final SimpleDateFormat DATAFORMAT = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 5000)
    public void getRSS(){
        LOGGER.info("Get RSS {}", DATAFORMAT.format(new Date()));
    }
}
