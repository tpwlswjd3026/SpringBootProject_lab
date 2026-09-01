package com.rookies6.myspringbootlab.runner;

import com.rookies6.myspringbootlab.property.MyPropProperties;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Component
public class MyPropRunner implements ApplicationRunner{

    @Value("${myprop.username}")
    private String username;

    @Value("${myprop.port}")
    private int port;


    @Autowired
    private MyPropProperties properties;

    private static final Logger logger = LoggerFactory.getLogger(MyPropRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //System.out.println(username);
        logger.debug("username = {}", username);
        //System.out.println(port);
        logger.info("port = {}", port);

        logger.debug("username = {}", properties.getUsername());
        logger.info("port = {}", properties.getPort());
    }
}
