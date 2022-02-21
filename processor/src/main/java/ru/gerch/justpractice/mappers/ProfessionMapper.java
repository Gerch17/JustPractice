package ru.gerch.justpractice.mappers;

import ru.gerch.justpractice.dto.ProfessionDto;
import ru.gerch.justpractice.models.Profession;
import org.springframework.stereotype.Service;

@Service
public class ProfessionMapper {

    public Profession dtoTpEntity(ProfessionDto professionDto) {
        Profession profession = new Profession();
        profession.setName(professionDto.getName());
        profession.setSalary(professionDto.getSalary());
        return profession;
    }
}
