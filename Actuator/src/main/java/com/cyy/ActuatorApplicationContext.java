package com.cyy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author:CYY
 * @create: 2023-05-24 09:43:59
 * @Description:
 */

@EnableAdminServer
@SpringBootApplication
public class ActuatorApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplicationContext.class, args);
    }
}
