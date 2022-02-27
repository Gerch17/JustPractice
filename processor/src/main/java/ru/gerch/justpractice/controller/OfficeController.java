package ru.gerch.justpractice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gerch.justpractice.dto.OfficeDto;
import ru.gerch.justpractice.service.OfficeService;

@Controller
@Slf4j
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/office")
    public ResponseEntity<String> postOffice(@RequestBody OfficeDto office) {
        log.debug("Receive office:{}", office.toString());
        officeService.postOffice(office);
        return ResponseEntity.ok("Office has been successfully added");
    }

}
