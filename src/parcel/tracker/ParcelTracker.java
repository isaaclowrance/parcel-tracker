/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcel.tracker;
import java.sql.Connection;

/**
 *
 * @author rashm
 */
public class ParcelTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = DbConnection.getConnection();
                
        System.out.println("hello");
    }
    
}
