package com.ron.licenta.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DemoConfig {

    @Bean
    CommandLineRunner commandLineRunnerDemo(DemoService demoService){

        return args -> {
            demoService.saveAll(List.of(
                   new Demo(
                           "andrei",
                           20
                   ),
                    new Demo(
                            "test",
                            30
                    ),
                    new Demo(
                            "sisa",
                            40
                    )
            ));
        };
    }
}
