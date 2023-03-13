package com.devphilip.robotapocalypse.controller;

import com.devphilip.robotapocalypse.model.Robot;
import com.devphilip.robotapocalypse.service.RobotService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/robots")
@RequiredArgsConstructor
public class RobotController {

    private final RobotService robotService;

    @GetMapping
    @Operation(summary = "Fetch all Robots")
    public ResponseEntity<List<Robot>> getRobots() {
        return ResponseEntity.ok(robotService.getAllRobots());
    }

}
