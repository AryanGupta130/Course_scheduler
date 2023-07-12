package coursescheduleramg7817;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Aryan
 */


import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.util.ArrayList;

import java.util.logging.Level;

import java.util.logging.Logger;






public class StudentQueries {
   
    private static Connection conn;
    
    private static ArrayList<String> firstName = new ArrayList<String>();
    
    private static ArrayList<String> lastName = new ArrayList<String>();
    
    private static PreparedStatement addStud;
    
    private static ArrayList<String> studentID = new ArrayList<String>();
    
    private static PreparedStatement getStudentList;
    
    private static PreparedStatement getStudent;
    
    private static PreparedStatement dropStudent;
    
    private static ResultSet result;
    
    
    public static void addStudent(StudentEntry entry)
    {
        
        conn = DBConnection.getConnection();
        
        try
        {
        
            addStud = conn.prepareStatement("insert into app.student (studentid, firstname, lastname) values (?, ?, ?)");
            
            addStud.setString(2, entry.getFirstName());
            
            addStud.setString(3, entry.getLastName());
            
            addStud.setString(1, entry.getStudentID());
            
            addStud.executeUpdate();
        
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
    }
    
    public static ArrayList<StudentEntry> getStudentList()
    {
        
        conn = DBConnection.getConnection();
        
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        
        try
        {
        
            getStudentList = conn.prepareStatement("select studentID, firstName, lastName from app.student order by lastName, firstName");
            
            result = getStudentList.executeQuery();
            
            
            while(result.next())
            {
            
                StudentEntry student = new StudentEntry(result.getString(1), result.getString(2), result.getString(3));
                
                students.add(student);
            }
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
        return students;
        
    }
    
    
    public static void dropStudent(String studentID)
    {
        
        conn = DBConnection.getConnection();
        
        try
        {
        
            dropStudent = conn.prepareStatement("delete from app.student where studentID = ?");
            
            dropStudent.setString(1, studentID);
            
            dropStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static StudentEntry getStudent(String studentID)
    {
        
        conn = DBConnection.getConnection();
        
        StudentEntry student = new StudentEntry("", "", "");
        
        try
        {
        
            getStudent = conn.prepareStatement("select studentID, firstName, lastName from app.student where studentID = ? order by lastName, firstName");
            
            getStudent.setString(1, studentID);
            
            result = getStudent.executeQuery();
            
            while(result.next())
            {
            
                student.setLastName(result.getString(3));
                
                student.setFirstName(result.getString(2));
                
                student.setStudentID(result.getString(1));
            
            }
        }
        
        catch(SQLException sqlException)
        {
        
            sqlException.printStackTrace();
        
        }
        
        return student;
        
    }
    
}
