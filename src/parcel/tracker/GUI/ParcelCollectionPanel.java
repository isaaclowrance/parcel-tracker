/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.GUI;

import parcel.tracker.Service.*;
import parcel.tracker.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rashm
 */
public class ParcelCollectionPanel extends JPanel {

     private final ParcelCollectionService service;

    public ParcelCollectionPanel(ParcelCollectionService service) {
        this.service = service;
        setLayout(new BorderLayout());

        // Input Fields
        JTextField parcelIdField = new JTextField(20);
        JTextField daysInDepotField = new JTextField(10);
        JTextField weightField = new JTextField(10);
        JTextField dimensionsField = new JTextField(20);
        JTextField statusField = new JTextField(15);
        JTextField collectionFee = new JTextField(15);
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
        inputPanel.add(new JLabel("Collection fee:"));
        inputPanel.add(collectionFee);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying parcels
        String[] columns = {"Parcel ID", "Days in Depot", "Weight", "Dimensions", "Status"};
        JTable table = new JTable(new Object[0][5], columns);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

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
                    float collectionfee = Float.parseFloat(collectionFee.getText());
                    ParcelModel parcel = new ParcelModel(parcelId, daysInDepot, weight, dimensions, status,collectionfee);
                    service.addParcel(parcel);
                    JOptionPane.showMessageDialog(null, "Parcel added successfully!");
                    updateTable(table);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Initial table update
        updateTable(table);
    }

    private void updateTable(JTable table) {
        Object[][] data = new Object[service.getParcelCount()][5];
        int index = 0;
        for (ParcelModel parcel : service.getAllParcels()) {
            data[index][0] = parcel.getParcelId();
            data[index][1] = parcel.getDaysInDepot();
            data[index][2] = parcel.getWeight();
            data[index][3] = parcel.getDimensions();
            data[index][4] = parcel.getStatus();
            index++;
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Parcel ID", "Days in Depot", "Weight", "Dimensions", "Status"}));
    }
}
