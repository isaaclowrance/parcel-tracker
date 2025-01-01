/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcel.tracker;

import parcel.tracker.GUI.CustomerPanel;
import parcel.tracker.Repositories.CustomerRepository;
import parcel.tracker.Service.CustomerService;

import javax.swing.*;

/**
 *
 * @author rashm
 */
public class ParcelTracker extends JFrame {

    public ParcelTracker() {
        setTitle("Parcel Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CustomerRepository repository = new CustomerRepository();
        CustomerService service = new CustomerService(repository);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Customers", new CustomerPanel(service));

        add(tabs);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            new ParcelTracker().setVisible(true);
        });

        System.out.println("hello");
    }

}
