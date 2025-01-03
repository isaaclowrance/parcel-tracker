/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.GUI;

import parcel.tracker.Service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author rashm
 */
public class ReportPanel extends JPanel{
    private final ReportService reportService;

    public ReportPanel(ReportService reportService) {
        this.reportService = reportService;
        setLayout(new BorderLayout());

        JButton generateReportButton = new JButton("Generate Report");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateReportButton);

        add(buttonPanel, BorderLayout.NORTH);

        // Area for displaying reports
        JTextArea reportArea = new JTextArea(20, 50);
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Generate button action
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String report = reportService.generateReport();
                    reportArea.setText(report);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
}
}