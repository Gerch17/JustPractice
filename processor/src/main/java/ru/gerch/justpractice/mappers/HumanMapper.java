package ru.gerch.justpractice.mappers;

import lombok.extern.slf4j.Slf4j;
import ru.gerch.justpractice.dto.HumanDto;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HumanMapper {

    private ProfessionService professionService;

    @Autowired
    public HumanMapper(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public Human dtoToEntity(HumanDto humanDto) {
        Human human = new Human();
        human.setName(humanDto.getName());
        human.setAge(humanDto.getAge());
        human.setSecondName(humanDto.getSecondName());
        Profession profession = professionService.findProfessionById(humanDto.getProfessionId());
        human.setProfession(profession);
        log.debug("finally got such human: {}", human.toString());
        return human;
    }
}
