package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Audio;

public class DAO {

    public void Insert(Audio a) throws ClassNotFoundException  {

        try {

        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO sounds (frequency, duration, decibelamplitude, timestamp ,devices_id) VALUES (" +
                    a.getFrequency() + ", " +
                    a.getDuration() + ", " +
                    a.getAmplitude() + ", " +
                    "now(), " +
                    "1" +
                    ")"
            );

        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }

    }
}
