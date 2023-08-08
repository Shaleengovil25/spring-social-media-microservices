package com.microservicedemo.usersservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicedemo.usersservice.model.Notifications;
import com.microservicedemo.usersservice.model.Posts;
import com.microservicedemo.usersservice.model.Users;

@RestController
@RefreshScope
@RequestMapping("/users")
public class UsersController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Value("${db.connection}")
    String connectionString;

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable int userId){

        Posts posts = restTemplate.getForObject("http://posts-service/posts/"+userId,Posts.class);
        Notifications notifications = restTemplate.getForObject("http://notifications-service/notifications/"+userId,Notifications.class);

        logger.info("successfully called users service");
        logger.info("DB: "+connectionString);
        return new Users(userId, "Shaleen", "8800574391", posts, notifications);
    }
}
