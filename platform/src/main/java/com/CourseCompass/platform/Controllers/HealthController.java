package com.CourseCompass.platform.Controllers;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private static final Logger log = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/health")
    public String index() throws UnknownHostException {
        log.info("Health Controller triggered");
        return "App is running on " + InetAddress.getLocalHost().getHostName();
    }
}