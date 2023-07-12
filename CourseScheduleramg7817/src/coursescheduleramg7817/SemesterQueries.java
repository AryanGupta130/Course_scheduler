package coursescheduleramg7817;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.ArrayList;

import java.sql.PreparedStatement;



/**
 *
 * @author Aryan
 */
public class SemesterQueries {
    private static PreparedStatement addSem;
    
    private static Connection conn;
    
    private static PreparedStatement getSemList;
    
    private static ResultSet result;
    
    private static ArrayList<String> faculty = new ArrayList<String>();
    
    
    
    
    
    public static void addSemester(String name)
    {
        
        conn = DBConnection.getConnection();
        
        try
        {
            
            
            addSem = conn.prepareStatement("insert into app.semester (semester) values (?)");
            
            addSem.setString(1, name);
            
            addSem.executeUpdate();
        
        }
        catch(SQLException sqlException)
        
        {
            
            sqlException.printStackTrace();
        
        }
        
    }
    
    public static ArrayList<String> getSemesterList()
    {
        conn = DBConnection.getConnection();
        
        ArrayList<String> semester = new ArrayList<String>();
        
        try
        
        {
        
            getSemList = conn.prepareStatement("select semester from app.semester order by semester");
            
            result = getSemList.executeQuery();
            
            while(result.next())
            
            {
            
                semester.add(result.getString(1));
            
            }
        
        }
        
        catch(SQLException sqlException)
        
        {
            
            sqlException.printStackTrace();
        
        }
        
        return semester;
        
    }
    
    
}
