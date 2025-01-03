/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcel.tracker.Repositories;

//import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import parcel.tracker.CustomerModel;
import parcel.tracker.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rashm
 */
public class CustomerRepository {

    // Save a customer to the database
    public void save(CustomerModel customer) throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO customers (seq_no, name, parcel_id) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, customer.getSeqNo());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getParcelId());
        ps.executeUpdate();
    }

    // Retrieve all customers from the database
    public List<CustomerModel> getAll() throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT * FROM customers";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<CustomerModel> customers = new ArrayList<>();
        while (rs.next()) {
            customers.add(new CustomerModel(
                    rs.getInt("seq_no"),
                    rs.getString("name"),
                    rs.getString("parcel_id")
            ));
        }
        return customers;
    }

    // Find a customer by sequence number
    public CustomerModel findBySeqNo(int seqNo) throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT * FROM customers WHERE seq_no = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, seqNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new CustomerModel(
                    rs.getInt("seq_no"),
                    rs.getString("name"),
                    rs.getString("parcel_id")
            );
        }
        return null;
    }
}
