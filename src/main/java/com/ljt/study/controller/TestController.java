package com.ljt.study.controller;

import com.ljt.study.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author LiJingTang
 * @date 2023-04-07 09:40
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    private static final ConcurrentHashMap<Integer, User> USER_MAP = new ConcurrentHashMap<>();


    @GetMapping("/user")
    public String cacheUser() {
        Random random = new Random();

        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 200_0000; i++) {
                USER_MAP.put(i, User.builder().id(i).name(String.valueOf(random.nextDouble())).gender(random.nextInt(2)).build());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            log.info("添加用户缓存完成");
        });

        return "OK";
    }


}
