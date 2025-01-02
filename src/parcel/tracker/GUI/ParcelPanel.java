/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.GUI;

import parcel.tracker.Service.ParcelService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JTextField descriptionField = new JTextField(20);
        JTextField statusField = new JTextField(20);
        JButton addButton = new JButton("Add Parcel");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying parcels
        String[] columns = {"ID", "Description", "Status"};
        JTable table = new JTable(new Object[0][3], columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service.addParcel(descriptionField.getText(), statusField.getText());
                    JOptionPane.showMessageDialog(null, "Parcel added successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    } 
}
