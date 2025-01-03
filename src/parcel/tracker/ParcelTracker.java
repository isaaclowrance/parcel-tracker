/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcel.tracker;

import parcel.tracker.*;
import parcel.tracker.GUI.*;
import parcel.tracker.Repositories.*;
import parcel.tracker.Service.*;

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

        // Initialize repositories
        CustomerRepository customerRepository = new CustomerRepository();
        ParcelRepository parcelRepository = new ParcelRepository();
        ReportRepository reportRepository = new ReportRepository();
        DeportRepository depotRepository = new DeportRepository();
        CustomerQueueRepository customerQueueRepository = new CustomerQueueRepository();
        ParcelCollectionRepostory parcelCollectionRepository = new ParcelCollectionRepostory();

        // Initialize services
        CustomerService customerService = new CustomerService(customerRepository);
        ParcelService parcelService = new ParcelService(parcelRepository);
        ReportService reportService = new ReportService(reportRepository);
        DeportService depotService = new DeportService(depotRepository);
        CustomerQueueService customerQueueService = new CustomerQueueService(customerQueueRepository);
        ParcelCollectionService parcelCollectionService = new ParcelCollectionService(parcelCollectionRepository);

        // Create GUI tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Customers", new CustomerPanel(customerService));
        tabs.add("Parcels", new ParcelPanel(parcelService));
        tabs.add("Reports", new ReportPanel(reportService));
        tabs.add("Depot", new DepotPanel(depotService));
        tabs.add("Customer Queue", new CustomerQueuePanel(customerQueueService));
        tabs.add("Parcel Collection", new ParcelCollectionPanel(parcelCollectionService));

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
