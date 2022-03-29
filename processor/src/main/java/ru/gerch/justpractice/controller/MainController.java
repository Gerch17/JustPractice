package ru.gerch.justpractice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gerch.justpractice.dto.HumanDto;
import ru.gerch.justpractice.dto.ProfessionDto;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.service.CommonService;
import ru.gerch.justpractice.service.HumanService;
import ru.gerch.justpractice.service.ProfessionService;

import java.util.List;

@Controller
@Slf4j
public class MainController {

    private final HumanService humanService;
    private final ProfessionService professionService;
    private final CommonService commonService;

    @Autowired
    public MainController(HumanService humanService,
                          ProfessionService professionService,
                          CommonService commonService) {
        this.humanService = humanService;
        this.professionService = professionService;
        this.commonService = commonService;
    }

    @PostMapping("/human")
    public ResponseEntity<String> postHuman(@RequestBody HumanDto human) {
        log.debug("Receive human: {}", human.toString());
        humanService.postHuman(human);
        return ResponseEntity.ok("Human has been successfully added");
    }

    @PostMapping("/profession")
    public ResponseEntity<String> postProfession(@RequestBody ProfessionDto profession) {
        professionService.postProfession(profession);
        return ResponseEntity.ok("Profession has been successfully added");
    }

    //localhost:8069/human/1
    @GetMapping("/human/{id}")
    public ResponseEntity<Human> getHuman(@PathVariable long id) {
        log.debug("human by id {}: {}", id, humanService.getHuman(id));
        return new ResponseEntity<>(humanService.getHuman(id), HttpStatus.OK);
    }

    @GetMapping("/profession/{id}")
    public ResponseEntity<Profession> getProfession(@PathVariable long id) {
        return new ResponseEntity<>(professionService.findProfessionById(id), HttpStatus.OK);
    }

    //localhost:8069/human
    @GetMapping("/human")
    public ResponseEntity<List<Human>> getAllHumans() {
        return new ResponseEntity<>(humanService.getAllHuman(), HttpStatus.OK);
    }

    @GetMapping("/profession")
    public ResponseEntity<List<Profession>> getAllProfessions() {
        return new ResponseEntity<>(professionService.getAllProfessions(), HttpStatus.OK);
    }

    //localhost:8069/human/profession/change?professionId=3&humanId=10
    @PostMapping("/human/profession/change")
    public ResponseEntity<String> changeProfession(@RequestParam long professionId,
                                                   @RequestParam long humanId) {
        humanService.changeProfession(humanId, professionId);
        return ResponseEntity.ok("Profession has been successfully changed");
    }

    @GetMapping("/human/name/{id}")
    public ResponseEntity<String> getHumanName(@PathVariable long id) {
        return humanService.getHumanName(id);
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting() {
        return commonService.getGreeting();
    }

    @GetMapping("/human/random")
    public ResponseEntity<Human> getRandomHuman() {
        return ResponseEntity.ok(humanService.getRandomHuman());
    }

    @PostMapping("/human/rest")
    public ResponseEntity<String> postHumanToAnotherModule(@RequestBody Human human) {
        return ResponseEntity.ok(humanService.postHumanToAnotherModule(human));
    }

    //localhost:8069/human/change?name=3&humanId=10
    @PostMapping("/human/change")
    public ResponseEntity<Human> changeName(@RequestParam long humanId,
                                            @RequestParam String name) {
        humanService.changeName(humanId, name);
        return ResponseEntity.ok(humanService.getHuman(humanId));
    }

    @PostMapping("/human/change/{id}/{name}")
    public ResponseEntity<Human> changeName2(@PathVariable(name="id") long humanId,
                                            @PathVariable String name) {
        humanService.changeName(humanId, name);
        return ResponseEntity.ok(humanService.getHuman(humanId));
    }
}
