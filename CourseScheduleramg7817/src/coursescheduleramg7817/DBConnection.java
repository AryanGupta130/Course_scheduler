package coursescheduleramg7817;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.DriverManager;



/**
 *
 * @author Aryan
 */
public class DBConnection {
        
    private static final String passwd = "java";
    
    private static final String user = "java";
    
    private static final String database = "jdbc:derby://localhost:1527/CourseSchedulerDBamg7817";
    
    private static Connection connection;


    public static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(database, user, passwd);
            } catch (SQLException e)
            {
                e.printStackTrace();
                System.out.println("Could not open database.");
                System.exit(1);

            }
        }
        return connection;
    }

    
}
