/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Service;

import parcel.tracker.*;
import parcel.tracker.Repositories.*;
import java.util.*;
/**
 *
 * @author rashm
 */
public class ParcelCollectionService {
     private final ParcelCollectionRepostory repository;

    public ParcelCollectionService(ParcelCollectionRepostory repository) {
        this.repository = repository;
    }

    public void addParcel(ParcelModel parcel) {
        repository.addParcel(parcel);
    }

    public ParcelModel getParcelById(String parcelId) {
        return repository.getParcel(parcelId);
    }

    public void removeParcel(String parcelId) {
        repository.removeParcel(parcelId);
    }

    public int getParcelCount() {
        return repository.getMapSize();
    }
    
     public List<ParcelModel> getAllParcels() {
        return repository.getAllParcels();
    }
}
