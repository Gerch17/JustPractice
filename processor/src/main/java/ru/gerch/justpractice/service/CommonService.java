package ru.gerch.justpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    private RestService restService;

    public CommonService(RestService restService) {
        this.restService = restService;
    }

    public ResponseEntity<String> getGreeting() {
        return restService.getString();
    }
}
