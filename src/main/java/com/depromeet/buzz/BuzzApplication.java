package com.depromeet.buzz;

import com.depromeet.buzz.common.service.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BuzzApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BuzzApplication.class, args);

        InitService initService = context.getBean(InitService.class);

        initService.init();
    }
}
