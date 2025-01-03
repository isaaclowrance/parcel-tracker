/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Service;

import parcel.tracker.*;
import parcel.tracker.Repositories.*;

import java.util.List;
/**
 *
 * @author rashm
 */
public class CustomerQueueService {
   private final CustomerQueueRepository customerQueueRepository;

    public CustomerQueueService(CustomerQueueRepository customerQueueRepository) {
        this.customerQueueRepository = customerQueueRepository;
    }

    public void addCustomerToQueue(CustomerModel customer) {
        customerQueueRepository.addCustomer(customer);
    }

    public CustomerModel removeCustomer() {
        return customerQueueRepository.removeCustomer();
    }

    public CustomerModel findCustomerBySeqNo(int seqNo) {
        return customerQueueRepository.findCustomerBySeqNo(seqNo);
    }

    public List<CustomerModel> getAllCustomers() {
        return customerQueueRepository.getAllCustomers();
    }
}
