package com.ssdd.report_ms.service;

public interface ReportService {
    String makeReport(String name);
    String saveReport(String nameReport);
    void deleteReport(String name);
}
