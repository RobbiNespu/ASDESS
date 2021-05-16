package com.github.robbinespu.asdess;

import com.github.robbinespu.asdess.utils.Menus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsdEssApplication implements CommandLineRunner {

    private static Logger log = LoggerFactory
            .getLogger(AsdEssApplication.class);

    @Autowired
      Menus menus;

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(AsdEssApplication.class, args);
        //SpringApplication app = new SpringApplication(AsdEssApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        //app.run(AsdEssApplication.class, args).close();
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Spring Boot Application");
        menus.commandMethod();

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.error("CommandLineRunner.run()");
            log.warn("CommandLineRunner.run()");
            log.info("CommandLineRunner.run()");
            log.debug("CommandLineRunner.run()");
            log.trace("CommandLineRunner.run()");
        };
    }
}
