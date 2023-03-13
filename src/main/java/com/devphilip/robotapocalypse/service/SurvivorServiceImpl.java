package com.devphilip.robotapocalypse.service;

import com.devphilip.robotapocalypse.model.Location;
import com.devphilip.robotapocalypse.model.Survivor;
import com.devphilip.robotapocalypse.repository.SurvivorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurvivorServiceImpl implements SurvivorService {

    private final SurvivorRepository survivorRepository;

    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    public Survivor addSurvivor(Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    public void updateLocation(Long survivorId, Location location) {
        Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(
                () -> new RuntimeException("Survivor not found"));
        survivor.setLocation(location);
        survivorRepository.save(survivor);
    }

    public void markAsInfected(Long id) {
        Survivor survivor = survivorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Survivor not found"));
        Integer reportedInfectionCount = survivor.getReportedInfectionCount();
        survivor.setReportedInfectionCount(reportedInfectionCount += 1);
        if (reportedInfectionCount >= 3) {
            survivor.setIsInfected(true);
        }
        survivorRepository.save(survivor);
    }

    @Override
    public Survivor getSurvivorById(Long id) {
        return survivorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Survivor not found"));
    }
}

