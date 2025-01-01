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
        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JButton addButton = new JButton("Add Customer");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying customers
        String[] columns = {"ID", "Name", "Email"};
        JTable table = new JTable(new Object[0][3], columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service.addCustomer(nameField.getText(), emailField.getText());
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
