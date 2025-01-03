/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rashm
 */
public class DeportModel {
    private List<ParcelModel> parcels;
    private List<CustomerModel> customerQueue;

    public DeportModel() {
        this.parcels = new ArrayList<>();
        this.customerQueue = new ArrayList<>();
    }

    public void addParcel(ParcelModel parcel) {
        parcels.add(parcel);
    }

    public void addCustomerToQueue(CustomerModel customer) {
        customerQueue.add(customer);
    }

    public void processCustomers(CustomerModel customer) {
        customerQueue.remove(customer);
    }

    public String findParcelById(String parcelId) {
        for (ParcelModel parcel : parcels) {
            if (parcel.getParcelId().equals(parcelId)) {
                return parcel.toString();
            }
        }
        return "Parcel not found";
    } 
}
