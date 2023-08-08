package com.microservicedemo.notificationsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/notifications")
public class NotificationsController {

    Logger logger = LoggerFactory.getLogger(NotificationsController.class);

    @Value("${my.greeting}")
	String greeting;

    @Value("${db.connection}")
    String connectionString;
    
    @GetMapping("/{id}")
    public Notifications getUserById(@PathVariable int id){
        logger.info("successfully called notifications service "+ greeting);
        logger.info("DB: "+connectionString);
        return new Notifications(id, "decription for notification id: "+id);
    }
}
