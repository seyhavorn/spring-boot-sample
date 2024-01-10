package com.seyhavorn.springcoredemo.config;

import com.seyhavorn.springcoredemo.common.Coach;
import com.seyhavorn.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
