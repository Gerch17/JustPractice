package ru.gerch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gerch.models.Human;
import ru.gerch.models.Profession;

@RestController
@Slf4j
public class ProcessorController {

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody Human human) {
        log.debug("Receive such Human: {}", human);
        return ResponseEntity.ok(human.getName());
    }

    @GetMapping("/string")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/random")
    public Human getRandomHuman() {
        Profession profession = new Profession();
        profession.setId(12);
        profession.setName("Dancer");
        profession.setSalary(120000);
        Human human = new Human();
        human.setProfession(profession);
        human.setId(11);
        human.setName("BobBob");
        human.setAge(23);
        human.setSecondName("kjdbsjkbdsjhf");
        return human;
    }

    @PostMapping("/human")
    public String postHuman(@RequestBody Human human) {
        log.debug("Receive such Human: {}", human.toString());
        return "Success!";
    }
}
