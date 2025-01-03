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
public class ParcelCollectionRepostory {
       private final ParcelCollection parcelMap;

    public ParcelCollectionRepostory() {
        this.parcelMap = new ParcelCollection();
    }

    public void addParcel(ParcelModel parcel) {
        parcelMap.addParcel(parcel);
    }

    public ParcelModel getParcel(String parcelId) {
        return parcelMap.getParcel(parcelId);
    }

    public void removeParcel(String parcelId) {
        parcelMap.removeParcel(parcelId);
    }

    public int getMapSize() {
        return parcelMap.size();
    }
    
    public List<ParcelModel> getAllParcels() {
        return parcelMap.getAllParcels();
    }
}
