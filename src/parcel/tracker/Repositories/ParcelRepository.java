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

    public void save(ParcelModel parcel) throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO parcels (description, status) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, parcel.getDescription());
        ps.setString(2, parcel.getStatus());
        ps.executeUpdate();
    }

    public List<ParcelModel> getAll() throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT * FROM parcels";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<ParcelModel> parcels = new ArrayList<>();
        while (rs.next()) {
            parcels.add(new ParcelModel(rs.getInt("id"), rs.getString("description"), rs.getString("status")));
        }
        return parcels;
    }
}
