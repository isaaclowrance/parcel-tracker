/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Service;

import parcel.tracker.ParcelModel;
import parcel.tracker.Repositories.ParcelRepository;

import java.util.List;

/**
 *
 * @author rashm
 */
public class ParcelService {
   private final ParcelRepository repository;

    public ParcelService(ParcelRepository repository) {
        this.repository = repository;
    }

    public void addParcel(String parcelId, int daysInDepot, float weight, String dimensions, String status) {
        ParcelModel parcel = new ParcelModel(parcelId, daysInDepot, weight, dimensions, status, 0);
        repository.save(parcel);
    }

    public List<ParcelModel> getAllParcels() {
        return repository.getAll();
    }

    public ParcelModel getParcelById(String parcelId) {
        return repository.findById(parcelId);
    }
}
