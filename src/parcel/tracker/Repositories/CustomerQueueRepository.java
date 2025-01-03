/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Repositories;

import parcel.tracker.*;
import java.util.*;
/**
 *
 * @author rashm
 */
public class CustomerQueueRepository {
    
     private Queue<CustomerModel> customerQueue = new LinkedList<>();

    public void addCustomer(CustomerModel customer) {
        customerQueue.add(customer);
    }

    public CustomerModel removeCustomer() {
        return customerQueue.poll();
    }

    public CustomerModel findCustomerBySeqNo(int seqNo) {
        return customerQueue.stream().filter(customer -> customer.getSeqNo() == seqNo).findFirst().orElse(null);
    }

    public List<CustomerModel> getAllCustomers() {
        return new ArrayList<>(customerQueue);
    }
}
