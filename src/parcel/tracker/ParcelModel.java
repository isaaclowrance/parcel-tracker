/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker;

/**
 *
 * @author rashm
 */
public class ParcelModel {

    private String parcelId;
    private int daysInDepot;
    private float weight;
    private String dimensions;
    private String status;
    private float collectionFee;

    public ParcelModel(String parcelId, int daysInDepot, float weight, String dimensions, String status, float collectionFee) {
        this.parcelId = parcelId;
        this.daysInDepot = daysInDepot;
        this.weight = weight;
        this.dimensions = dimensions;
        this.status = status;
        this.collectionFee = collectionFee;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public void setDaysInDepot(int daysInDepot) {
        this.daysInDepot = daysInDepot;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getCollectionFee() {
        return collectionFee;
    }

    public void setCollectionFee(float collectionFee) {
        this.collectionFee = collectionFee;
    }

    public void calculateFee() {
        // Logic for fee calculation
    }

    public void updateStatus() {
        // Logic to update status
    }
}
