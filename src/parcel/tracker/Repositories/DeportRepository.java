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
public class DeportRepository {
    
     private List<ParcelModel> parcels = new ArrayList<>();

    public void addParcel(ParcelModel parcel) {
        parcels.add(parcel);
    }

    public ParcelModel findParcelById(String parcelId) {
        return parcels.stream().filter(parcel -> parcel.getParcelId().equals(parcelId)).findFirst().orElse(null);
    }

    public List<ParcelModel> getAllParcels() {
        return parcels;
    }

}
