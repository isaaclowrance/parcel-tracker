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

    public void addCustomer(String name, String email) throws Exception {
        CustomerModel customer = new CustomerModel(0, name, email);
        repository.save(customer);
    }

    public List<CustomerModel> getAllCustomers() throws Exception {
        return repository.getAll();
    }
}
