package com.devphilip.robotapocalypse.service;

import com.devphilip.robotapocalypse.model.Survivor;
import com.devphilip.robotapocalypse.repository.SurvivorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportService {
	
	private final SurvivorRepository survivorRepository;
	private final RobotService robotService;

	public Map<String, Object> getReport() {

		List<Survivor> survivors = survivorRepository.findAll();
		List<Survivor> infectedSurvivors = survivors.stream().filter(Survivor::getIsInfected).collect(Collectors.toList());
		List<Survivor> nonInfectedSurvivors = survivors.stream().filter(survivor -> !survivor.getIsInfected()).collect(Collectors.toList());
		log.info("The survivors Size: {}", survivors.size());
		log.info("The infectedSurvivors Size: {}", infectedSurvivors.size());
		log.info("The nonInfectedSurvivors Size: {}", nonInfectedSurvivors.size());

		HashMap<String, Object> report = new HashMap<>();

		report.put("survivors", survivors);
		report.put("infectedSurvivors", infectedSurvivors);
//		report.put("infectedSurvivorsPercent", (infectedSurvivors.size() / Double.parseDouble(String.valueOf(survivors.size()))) * 100.00);
		report.put("infectedSurvivorsPercent", (infectedSurvivors.size() / (double) survivors.size()) * 100.00);
		report.put("nonInfectedSurvivors", nonInfectedSurvivors);
//		report.put("nonInfectedSurvivorsPercent",(nonInfectedSurvivors.size() / Double.parseDouble(String.valueOf(survivors.size()))) * 100.00);
		report.put("nonInfectedSurvivorsPercent",(nonInfectedSurvivors.size() / (double) survivors.size()) * 100.00);
		report.put("robot", robotService.getAllRobots());

		return report;
	}
}
