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
 
      public void save(CustomerModel customer) throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getEmail());
        ps.executeUpdate();
    }

    public List<CustomerModel> getAll() throws Exception {
        Connection connection = DbConnection.getConnection();
        String sql = "SELECT * FROM customers";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<CustomerModel> customers = new ArrayList<>();
        while (rs.next()) {
            customers.add(new CustomerModel(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
        }
        return customers;
    }
}
