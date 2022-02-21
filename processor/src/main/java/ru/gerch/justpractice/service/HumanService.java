package ru.gerch.justpractice.service;

import ru.gerch.justpractice.dto.HumanDto;
import ru.gerch.justpractice.mappers.HumanMapper;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanService {
    private HumanRepository humanRepository;
    private HumanMapper humanMapper;
    private ProfessionService professionService;

    @Autowired
    public HumanService(HumanRepository humanRepository,
                        HumanMapper humanMapper,
                        ProfessionService professionService) {
        this.humanRepository = humanRepository;
        this.humanMapper = humanMapper;
        this.professionService = professionService;
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
}
