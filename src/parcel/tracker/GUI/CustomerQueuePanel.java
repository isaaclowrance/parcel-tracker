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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rashm
 */
public class CustomerQueuePanel extends JPanel{
    private final CustomerQueueService customerQueueService;
    private final DefaultTableModel tableModel;

    public CustomerQueuePanel(CustomerQueueService customerQueueService) {
        this.customerQueueService = customerQueueService;
        setLayout(new BorderLayout());

        // Input Fields
        JTextField customerIdField = new JTextField(20);
        JButton addCustomerButton = new JButton("Add Customer to Queue");
        JButton removeCustomerButton = new JButton("Remove Customer");
        JButton findCustomerButton = new JButton("Find Customer");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(customerIdField);
        inputPanel.add(addCustomerButton);
        inputPanel.add(removeCustomerButton);
        inputPanel.add(findCustomerButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying queue
        String[] columns = {"Seq No", "Name", "Parcel ID"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addCustomerButton.addActionListener(e -> {
            try {
                int seqNo = Integer.parseInt(customerIdField.getText());
                String name = JOptionPane.showInputDialog("Enter Customer Name:");
                String parcelId = JOptionPane.showInputDialog("Enter Parcel ID:");

                CustomerModel customer = new CustomerModel(seqNo, name, parcelId);

                // Add the customer to the queue
                customerQueueService.addCustomerToQueue(customer);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Customer added to queue successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Remove button action
        removeCustomerButton.addActionListener(e -> {
            CustomerModel removedCustomer = customerQueueService.removeCustomer();
            if (removedCustomer != null) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Removed customer: " + removedCustomer.getName());
            } else {
                JOptionPane.showMessageDialog(this, "Queue is empty.");
            }
        });

        // Find button action
        findCustomerButton.addActionListener(e -> {
            try {
                int seqNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Sequence Number:"));
                CustomerModel customer = customerQueueService.findCustomerBySeqNo(seqNo);
                if (customer != null) {
                    JOptionPane.showMessageDialog(this, "Customer Found:\nName: " + customer.getName() +
                            "\nParcel ID: " + customer.getParcelId());
                } else {
                    JOptionPane.showMessageDialog(this, "No customer found with sequence number: " + seqNo);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (CustomerModel customer : customerQueueService.getAllCustomers()) {
            tableModel.addRow(new Object[]{customer.getSeqNo(), customer.getName(), customer.getParcelId()});
        }
    }
}
