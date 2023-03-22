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


public interface ReportService {

	Map<String, Object> getReport();

}
