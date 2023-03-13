package com.devphilip.robotapocalypse.controller;

import com.devphilip.robotapocalypse.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
	
	private final ReportService reportService;

	@GetMapping
	@Operation(summary = "Get report of ")
	public ResponseEntity<?> getReport() {
		return ResponseEntity.ok(reportService.getReport());
	}

}
