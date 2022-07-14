package ru.gerch.justpractice.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class HumanDto {
    private String name;
    private String secondName;
    private int age;
    private long professionId;
}

