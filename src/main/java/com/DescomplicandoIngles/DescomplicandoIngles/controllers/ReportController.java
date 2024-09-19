package com.DescomplicandoIngles.DescomplicandoIngles.controllers;

import com.DescomplicandoIngles.DescomplicandoIngles.dto.ReportDTO;
import com.DescomplicandoIngles.DescomplicandoIngles.service.ReportService;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.NoLessonNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/{id}")
    public ReportDTO returnReport (@PathVariable Integer id) {
        ReportDTO reportDTO = reportService.findByReport(id);
        return reportDTO;
    }

}
