package com.devphilip.robotapocalypse.controller;

import com.devphilip.robotapocalypse.model.Location;
import com.devphilip.robotapocalypse.model.Survivor;
import com.devphilip.robotapocalypse.service.SurvivorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/survivors")
@RequiredArgsConstructor
public class SurvivorController {

    private final SurvivorService survivorService;

    @GetMapping
    @Operation(summary = "Fetch all Survivors")
    public ResponseEntity<List<Survivor>> getSurvivors() {
        return ResponseEntity.ok(survivorService.getAllSurvivors());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Fetch a Survivor by Id")
    public ResponseEntity<Survivor> getSurvivorById(@PathVariable Long id) {
        return ResponseEntity.ok(survivorService.getSurvivorById(id));
    }

    @PostMapping
    @Operation(summary = "Add new Survivors")
    private ResponseEntity<Survivor> addSurvivor(@Valid @RequestBody Survivor survivor) {
        survivor = survivorService.addSurvivor(survivor);
        URI location = URI.create(String.format("/survivors/%s", survivor.getId()));
        return ResponseEntity.created(location).body(survivor);
    }

    @PutMapping("/{id}/location")
    @Operation(summary = "Update location for Survivors")
    private ResponseEntity<?> updateLocation(@PathVariable Long id, @Valid @RequestBody Location location) {
        survivorService.updateLocation(id, location);
        return ResponseEntity.ok("Survivor updated successfully");
    }

    @PutMapping("/{id}/mark-as-infected")
    @Operation(summary = "Flag Survivors infected")
    private ResponseEntity<?> markAsInfected(@PathVariable Long id) {
        survivorService.markAsInfected(id);
        return ResponseEntity.ok("Survivor Marked as Infected");
    }

}
