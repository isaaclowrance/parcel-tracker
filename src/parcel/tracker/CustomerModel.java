/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker;

/**
 *
 * @author rashm
 */
public class CustomerModel {

    private int seqNo;
    private String name;
    private String parcelId;

    public CustomerModel(int seqNo, String name, String parcelId) {
        this.seqNo = seqNo;
        this.name = name;
        this.parcelId = parcelId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }
    
    public float collectParcel() {
        return 0.0f; // Placeholder for logic
    }
    
}
