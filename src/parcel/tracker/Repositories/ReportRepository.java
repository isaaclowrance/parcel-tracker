/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Repositories;

import parcel.tracker.ReportModel;
import parcel.tracker.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rashm
 */
public class ReportRepository {
   private List<ReportModel> reports = new ArrayList<>();

    public void addReport(ReportModel report) {
        reports.add(report);
    }

    public List<ReportModel> getAllReports() {
        return reports;
    }

    public ReportModel findReportById(int reportId) {
        return reports.stream().filter(report -> report.getReportId() == reportId).findFirst().orElse(null);
    }
}
