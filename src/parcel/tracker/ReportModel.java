/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rashm
 */
public class ReportModel {

   private int reportId;
    private String contentString;
    private LocalDateTime generatedOn;
    private List<ParcelModel> parcelList;

    public ReportModel(int reportId, String contentString) {
        this.reportId = reportId;
        this.contentString = contentString;
        this.generatedOn = LocalDateTime.now();
        this.parcelList = new ArrayList<>();
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getContentString() {
        return contentString;
    }

    public void setContentString(String contentString) {
        this.contentString = contentString;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void addParcelToReport(ParcelModel parcel) {
        parcelList.add(parcel);
    }
}
