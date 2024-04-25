package edu.tcu.cs.onlineshop;

import edu.tcu.cs.onlineshop.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineshopApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}
