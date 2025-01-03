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
public class DepotPanel extends JPanel {

    private final DeportService depotService;

    public DepotPanel(DeportService depotService) {
        this.depotService = depotService;
        setLayout(new BorderLayout());

        // Input Fields
        JTextField parcelIdField = new JTextField(20);
        JButton addParcelButton = new JButton("Add Parcel to Depot");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Parcel ID:"));
        inputPanel.add(parcelIdField);
        inputPanel.add(addParcelButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying depot parcels
        String[] columns = {"Parcel ID"};
        JTable table = new JTable(new Object[0][1], columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addParcelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Prompt for additional parcel details
                    String parcelId = parcelIdField.getText();
                    int daysInDepot = Integer.parseInt(JOptionPane.showInputDialog("Enter Days in Depot:"));
                    float weight = Float.parseFloat(JOptionPane.showInputDialog("Enter Parcel Weight:"));
                    String dimensions = JOptionPane.showInputDialog("Enter Parcel Dimensions:");
                    String status = JOptionPane.showInputDialog("Enter Parcel Status:");

                    // Create a ParcelModel object
                    ParcelModel parcel = new ParcelModel(parcelId, daysInDepot, weight, dimensions, status, 0);

                    // Add the parcel to the depot
                    depotService.addParcelToDepot(parcel);
                    JOptionPane.showMessageDialog(null, "Parcel added successfully to Depot!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
