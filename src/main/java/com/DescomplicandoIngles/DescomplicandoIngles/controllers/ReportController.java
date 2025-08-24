package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.ReportDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController (ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportDTO> returnReport (@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(reportService.findByReport(id));
    }

}
