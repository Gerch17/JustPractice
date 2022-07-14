package ru.gerch.justpractice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JustPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustPracticeApplication.class, args);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.stream().forEach(System.out::println);
    }

}
