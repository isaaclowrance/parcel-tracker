/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Service;

import parcel.tracker.CustomerModel;
import parcel.tracker.Repositories.CustomerRepository;
import java.util.List;
/**
 *
 * @author rashm
 */
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Add a customer
    public void addCustomer(int seqNo, String name, String parcelId) throws Exception {
        CustomerModel customer = new CustomerModel(seqNo, name, parcelId);
        repository.save(customer);
    }

    // Get all customers
    public List<CustomerModel> getAllCustomers() throws Exception {
        return repository.getAll();
    }

    // Find a customer by sequence number
    public CustomerModel findCustomerBySeqNo(int seqNo) throws Exception {
        return repository.findBySeqNo(seqNo);
    }
}
