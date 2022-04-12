package ru.gerch.justpractice.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gerch.justpractice.dto.OfficeDto;
import ru.gerch.justpractice.models.Office;

@Service
@Slf4j
public class OfficeMapper {

    public Office dtoToEntity (OfficeDto officeDto) {
        Office office = new Office();
        office.setName(officeDto.getName());
        office.setAddress(officeDto.getAddress());
        log.debug("finally got such office: {}", office.toString());
        return office;
    }
}
