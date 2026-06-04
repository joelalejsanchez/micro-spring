package com.ssdd.report_ms.service;

import com.netflix.discovery.EurekaClient;
import com.ssdd.report_ms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl  implements ReportService{

    private final CompaniesRepository companiesRepository;

    @Override
    public String makeReport(String name) {
        return this.companiesRepository.getByName(name).orElseThrow().getName();
        //return "";
    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String name) {

    }
}
