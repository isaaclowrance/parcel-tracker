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
public class DeportService {
     private final DeportRepository depotRepository;

    public DeportService(DeportRepository depotRepository) {
        this.depotRepository = depotRepository;
    }

    public void addParcelToDepot(ParcelModel parcel) {
        depotRepository.addParcel(parcel);
    }

    public ParcelModel findParcelById(String parcelId) {
        return depotRepository.findParcelById(parcelId);
    }

//    public void processCustomerInDepot(DeportModel customer) {
//        depotRepository.processCustomer(customer);
//    }
}
