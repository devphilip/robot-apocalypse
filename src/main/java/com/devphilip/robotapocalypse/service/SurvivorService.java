package com.devphilip.robotapocalypse.service;

import com.devphilip.robotapocalypse.model.Location;
import com.devphilip.robotapocalypse.model.Survivor;

import java.util.List;

public interface SurvivorService {

    List<Survivor> getAllSurvivors();

    Survivor addSurvivor(Survivor survivor);

    void updateLocation(Long survivorId, Location location);

    void markAsInfected(Long id);

    Survivor getSurvivorById(Long id);
}

