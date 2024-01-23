package com.seyhavorn.aopdemo.service;

import org.springframework.stereotype.Service;

//import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        // simulate a delay
//        try {
//            //TimeUnit.SECONDS.sleep(5);
////            return false;
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return "Expect heavy traffic this Morning!";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major accident ! Highway is closed!");
        }

        return getFortune();
    }
}
