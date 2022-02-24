package ru.gerch.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Human {

    private long id;

    private String name;

    private String secondName;

    private int age;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profession profession;

}
