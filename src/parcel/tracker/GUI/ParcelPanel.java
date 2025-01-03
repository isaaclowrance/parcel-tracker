/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.GUI;

import parcel.tracker.Service.ParcelService;
import parcel.tracker.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author rashm
 */
public class ParcelPanel extends JPanel {
   private final ParcelService service;

    public ParcelPanel(ParcelService service) {
        this.service = service;
        setLayout(new BorderLayout());

        // Input Fields
        JTextField parcelIdField = new JTextField(20);
        JTextField daysInDepotField = new JTextField(10);
        JTextField weightField = new JTextField(10);
        JTextField dimensionsField = new JTextField(20);
        JTextField statusField = new JTextField(15);
        JButton addButton = new JButton("Add Parcel");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Parcel ID:"));
        inputPanel.add(parcelIdField);
        inputPanel.add(new JLabel("Days in Depot:"));
        inputPanel.add(daysInDepotField);
        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Dimensions:"));
        inputPanel.add(dimensionsField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying parcels
        String[] columns = {"Parcel ID", "Days in Depot", "Weight", "Dimensions", "Status"};
        JTable table = new JTable(new Object[0][5], columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String parcelId = parcelIdField.getText();
                    int daysInDepot = Integer.parseInt(daysInDepotField.getText());
                    float weight = Float.parseFloat(weightField.getText());
                    String dimensions = dimensionsField.getText();
                    String status = statusField.getText();

                    service.addParcel(parcelId, daysInDepot, weight, dimensions, status);
                    JOptionPane.showMessageDialog(null, "Parcel added successfully!");

                    // Refresh the table
                    updateTable(table);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Initial Table Update
        try {
            updateTable(table);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error initializing table: " + ex.getMessage());
        }
    }

    private void updateTable(JTable table) throws Exception {
        List<ParcelModel> parcels = service.getAllParcels();
        String[][] data = new String[parcels.size()][5];
        for (int i = 0; i < parcels.size(); i++) {
            ParcelModel parcel = parcels.get(i);
            data[i][0] = parcel.getParcelId();
            data[i][1] = String.valueOf(parcel.getDaysInDepot());
            data[i][2] = String.valueOf(parcel.getWeight());
            data[i][3] = parcel.getDimensions();
            data[i][4] = parcel.getStatus();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Parcel ID", "Days in Depot", "Weight", "Dimensions", "Status"}));
    }
}
