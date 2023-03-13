package com.devphilip.robotapocalypse.service;


import com.devphilip.robotapocalypse.model.Robot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RobotServiceImpl implements RobotService{

    public List<Robot> getAllRobots() {
        WebClient webClient = WebClient.create();

        return webClient.get()
                .uri("https://robotstakeover20210903110417.azurewebsites.net/robotcpu")
                .retrieve()
                .bodyToFlux(Robot.class).collectList().block();
    }

}
