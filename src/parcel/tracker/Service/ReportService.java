/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Service;

import parcel.tracker.*;
import parcel.tracker.Repositories.ReportRepository;

import java.util.List;

/**
 *
 * @author rashm
 */
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

//    public void generateReport(ReportModel report) {
//        reportRepository.generateReport(report);
//    }
//
//    public void addParcelToReport (ParcelModel parcel) {
//        reportRepository.addParcelToReport(parcel);
//    }

    public List<ReportModel> getAllReports() {
        return reportRepository.getAllReports();
    }
    
    public String generateReport() throws Exception {
        // Generate the report content
        StringBuilder reportContent = new StringBuilder();
        List<ReportModel> reports = reportRepository.getAllReports();

        reportContent.append("=== Generated Reports ===\n");
        for (ReportModel report : reports) {
            reportContent.append("Report ID: ").append(report.getReportId()).append("\n");
            reportContent.append("Content: ").append(report.getContentString()).append("\n");
            reportContent.append("Generated On: ").append(report.getGeneratedOn()).append("\n");
            reportContent.append("--------------------------\n");
        }

        return reportContent.toString();
    }

}

