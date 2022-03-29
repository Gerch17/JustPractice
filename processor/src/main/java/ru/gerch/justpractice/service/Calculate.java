package ru.gerch.justpractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Calculate {

    private AutoTestImpl autoTest;
    private final int expected = 10;

    public String calculateTests() {
        int temp = 0;
        for (int i = 0; i <= expected; i++) {
            if (autoTest.createAutoTest()) {
                temp++;
            }
        }

        if (temp == expected) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

}
