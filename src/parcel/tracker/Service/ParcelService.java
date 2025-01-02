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

    public void addParcel(String description, String status) throws Exception {
        ParcelModel parcel = new ParcelModel(0, description, status);
        repository.save(parcel);
    }

    public List<ParcelModel> getAllParcels() throws Exception {
        return repository.getAll();
    }
}
