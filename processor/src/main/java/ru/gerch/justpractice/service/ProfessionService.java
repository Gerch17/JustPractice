package ru.gerch.justpractice.service;

import lombok.extern.slf4j.Slf4j;
import ru.gerch.justpractice.dto.ProfessionDto;
import ru.gerch.justpractice.mappers.ProfessionMapper;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProfessionService {
    private ProfessionRepository professionRepository;
    private ProfessionMapper professionMapper;

    @Autowired
    public ProfessionService(ProfessionRepository professionRepository,
                             ProfessionMapper professionMapper) {
        this.professionRepository = professionRepository;
        this.professionMapper = professionMapper;
    }

    public void postProfession(ProfessionDto professionDto) {
        professionRepository.save(professionMapper.dtoTpEntity(professionDto));
    }

    public Profession findProfessionById(long id) {
        log.debug("Got such profession after searching: {}", professionRepository.findProfessionById(id).toString());
        return professionRepository.findProfessionById(id);
    }

    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }

    public String getProfessionNameById(long id) {
        Profession profession = professionRepository.findProfessionById(id);
        return profession.getName();
    }
}
