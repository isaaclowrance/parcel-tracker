/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Repositories;

import parcel.tracker.ParcelModel;
import parcel.tracker.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rashm
 */
public class ParcelRepository {

   private List<ParcelModel> parcels = new ArrayList<>();

    public void save(ParcelModel parcel) {
        parcels.add(parcel);
    }

    public List<ParcelModel> getAll() {
        return parcels;
    }

    public ParcelModel findById(String parcelId) {
        return parcels.stream().filter(parcel -> parcel.getParcelId().equals(parcelId)).findFirst().orElse(null);
    }
}
