package com.appMain.config;

import com.appMain.Repository.RealtorRepository;
import com.appMain.entity.Realtor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner demo(final RealtorRepository realtorRepository) {
        return strings -> {
            Realtor realtor1 = new Realtor("Jack", "Ma", "email");
            realtorRepository.save(realtor1);

        };
    }
}