package com.robbinespu.asdess;

import com.robbinespu.asdess.exception.ExitException;
import com.robbinespu.asdess.service.HelloWorldService;
import com.robbinespu.asdess.util.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsdessApplication implements CommandLineRunner {

    final
    HelloWorldService helloWorldService;

    final
    MenuUtils menuUtils;

    public AsdessApplication(HelloWorldService helloWorldService, MenuUtils menuUtils) {
        this.helloWorldService = helloWorldService;
        this.menuUtils = menuUtils;
    }

    public static void main(String[] args) {
        SpringApplication.run(AsdessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.helloWorldService.getHelloMessage());
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new ExitException();
        }
        menuUtils.commandMethod();
    }
}
