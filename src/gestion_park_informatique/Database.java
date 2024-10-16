/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_park_informatique;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Miandry
 */
public class Database {
    public static Connection connectdb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/informatique","miandry","miandry123");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
