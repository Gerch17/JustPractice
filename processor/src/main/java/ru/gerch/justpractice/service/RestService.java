package ru.gerch.justpractice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gerch.justpractice.models.Human;

@Service
@Slf4j
public class RestService {

    private final RestTemplate template;

    private final String serverUrl = "http://localhost:8068";

    public RestService(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    public ResponseEntity<String> getHuman(Human human) {
        HttpEntity<Human> request = new HttpEntity<>(human);
        ResponseEntity<String> result =
                template.exchange(serverUrl + "/test", HttpMethod.POST, request, String.class);
        return result;
    }

    public ResponseEntity<String> getString() {
        return template.getForEntity(serverUrl + "/string", String.class);
    }

    public Human getRandomHuman() {
        return template.getForObject(serverUrl + "/random", Human.class);
    }

    public String postHuman(Human human) {
        HttpEntity<Human> request = new HttpEntity<>(human);
        return template.postForObject(serverUrl + "/human", request, String.class);
    }
}
