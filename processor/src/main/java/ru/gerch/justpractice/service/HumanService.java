package ru.gerch.justpractice.service;

import org.springframework.http.ResponseEntity;
import ru.gerch.justpractice.dto.HumanDto;
import ru.gerch.justpractice.mappers.HumanMapper;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanService {
    private final HumanRepository humanRepository;
    private final HumanMapper humanMapper;
    private final ProfessionService professionService;
    private final RestService restService;


    @Autowired
    public HumanService(HumanRepository humanRepository,
                        HumanMapper humanMapper,
                        ProfessionService professionService,
                        RestService restService) {
        this.humanRepository = humanRepository;
        this.humanMapper = humanMapper;
        this.professionService = professionService;
        this.restService = restService;
    }

    public void postHuman(HumanDto human) {
        Human humanEntity = humanMapper.dtoToEntity(human);
        humanRepository.save(humanEntity);
    }

    public Human getHuman(long id) {
        return humanRepository.findHumanById(id);
    }

    public List<Human> getAllHuman() {
        return humanRepository.findAll();
    }

    public void changeProfession(long humanId, long professionId) {
        Human human = humanRepository.findHumanById(humanId);
        human.setProfession(professionService.findProfessionById(professionId));
        humanRepository.save(human);
    }

    public ResponseEntity<String> getHumanName(long id) {
        return restService.getHuman(humanRepository.findHumanById(id));
    }

    public Human getRandomHuman() {
        return restService.getRandomHuman();
    }

    public String postHumanToAnotherModule(Human human) {
        return restService.postHuman(human);
    }

    public Human changeName(long humanId, String name) {
        Human human = humanRepository.findHumanById(humanId);
        human.setName(name);
        humanRepository.save(human);
        return human;
    }

    public List<Human> getHumanBetween(int from, int to) {
        return humanRepository.findHumansByAgeBetween(from, to);
    }
}
