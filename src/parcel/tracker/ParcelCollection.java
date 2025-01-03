/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author rashm
 */
public class ParcelCollection {
   private Map<String, ParcelModel> parcels;

    public ParcelCollection() {
        this.parcels = new HashMap<>();
    }

    public void addParcel(ParcelModel parcel) {
        parcels.put(parcel.getParcelId(), parcel);
    }

    public ParcelModel getParcel(String parcelId) {
        return parcels.get(parcelId);
    }

    public void removeParcel(String parcelId) {
        parcels.remove(parcelId);
    }

    public int size() {
        return parcels.size();
    }
    
    public List<ParcelModel> getAllParcels() {
        return new ArrayList<>(parcels.values());
    }
}


