package com.microservicedemo.postsservice;

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
@RequestMapping("/posts")
public class PostsController {

    Logger logger = LoggerFactory.getLogger(PostsController.class);

    @Value("${db.connection}")
    String connectionString;
    
    @GetMapping("/{id}")
    public Posts getUserById(@PathVariable int id){
        logger.info("successfully called posts service");
        logger.info("DB: "+connectionString);
        return new Posts(id, "description for post id: "+id);
    }
}
