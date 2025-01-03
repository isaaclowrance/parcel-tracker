/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcel.tracker.Service.CustomerService;
import parcel.tracker.*;
import java.util.List;

/**
 *
 * @author rashm
 */
public class CustomerPanel extends JPanel {
     private final CustomerService service;

    public CustomerPanel(CustomerService service) {
        this.service = service;
        setLayout(new BorderLayout());

        // Input Fields
        JTextField seqNoField = new JTextField(10);
        JTextField nameField = new JTextField(20);
        JTextField parcelIdField = new JTextField(20);
        JButton addButton = new JButton("Add Customer");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Seq No:"));
        inputPanel.add(seqNoField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Parcel ID:"));
        inputPanel.add(parcelIdField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying customers
        String[] columns = {"Seq No", "Name", "Parcel ID"};
        JTable table = new JTable(new Object[0][3], columns);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int seqNo = Integer.parseInt(seqNoField.getText());
                    String name = nameField.getText();
                    String parcelId = parcelIdField.getText();
                    service.addCustomer(seqNo, name, parcelId);
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");

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

    // Update table with customer data
    private void updateTable(JTable table) throws Exception {
        List<CustomerModel> customers = service.getAllCustomers();
        String[][] data = new String[customers.size()][3];
        for (int i = 0; i < customers.size(); i++) {
            CustomerModel customer = customers.get(i);
            data[i][0] = String.valueOf(customer.getSeqNo());
            data[i][1] = customer.getName();
            data[i][2] = customer.getParcelId();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Seq No", "Name", "Parcel ID"}));
    }
}
