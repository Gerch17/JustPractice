package ru.gerch.justpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gerch.justpractice.dto.OfficeDto;
import ru.gerch.justpractice.mappers.OfficeMapper;
import ru.gerch.justpractice.models.Office;
import ru.gerch.justpractice.repository.OfficeRepository;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    @Autowired
    public OfficeService (OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    public void postOffice(OfficeDto office) {
        Office officeEntity = officeMapper.dtoToEntity(office);
        officeRepository.save(officeEntity);
    }
}
