package coursescheduleramg7817;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Aryan
 */


import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.sql.PreparedStatement;




public class CourseQueries {
    
    private static Connection connection;
    
    private static ArrayList<String> semester = new ArrayList<String>();
    
    private static ArrayList<String> courseID = new ArrayList<String>();
    
    private static ArrayList<String> courseDes = new ArrayList<String>();
    
    private static ArrayList<int[]> seats = new ArrayList<int[]>();
    
    private static PreparedStatement addCourse;
    
    private static PreparedStatement getCourseList;
    
    private static PreparedStatement getAllCourses;
    
    private static PreparedStatement getAllCourseCodes;
    
    private static PreparedStatement dropCourse;
    
    private static ResultSet resultSet;
    
    private static PreparedStatement getCourseSeats;
    
   
    public static void addCourse(String sem, String CourseId, String description, int num_seats)
    {
    
        connection = DBConnection.getConnection();
        
        try
        
        {
        
            addCourse = connection.prepareStatement("insert into app.course (semester, coursecode, description, seats) values (?, ?, ?, ?)");
            
            addCourse.setString(1, sem);
            
            addCourse.setString(2, CourseId);
            
            addCourse.setString(3, description);
            
            addCourse.setInt(4, num_seats);
            
            addCourse.executeUpdate();
        }
        
        catch(SQLException sqlException)
        
        {
        
            sqlException.printStackTrace();
        }
        
    }
    
        public static ArrayList<CourseEntry> getAllCourses(String semester)
    {
        
        connection = DBConnection.getConnection();
        
        ArrayList<CourseEntry> courses = new ArrayList<>();
        
        try
        
        {

            
            getAllCourses = connection.prepareStatement("select courseCode, description, seats from app.course where semester = ? order by courseCode");
            
            getAllCourses.setString(1, semester);
            
            resultSet = getAllCourses.executeQuery();
            
            
            while(resultSet.next())
            {
                
            
                CourseEntry course = new CourseEntry(semester, resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                courses.add(course);
            }
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        }
        
        return courses;
        
    }
    
        public static ArrayList<String> getAllCourseCodes(String semester)
    {
       
        connection = DBConnection.getConnection();
        
        ArrayList<String> cCodes = new ArrayList<String>();
        
        try
        {
        
            getAllCourseCodes = connection.prepareStatement("select courseCode from app.course where semester = ? order by courseCode");
            
            getAllCourseCodes.setString(1, semester);
            
            resultSet = getAllCourseCodes.executeQuery();
            
            
            while(resultSet.next())
            
            {
                cCodes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return cCodes;
        
    }   
    public static int getCourseSeats(String semester, String courseCode)
    {
      
        connection = DBConnection.getConnection();
        
        int seats = 0;
        
        try
        
        {
        
            getCourseSeats = connection.prepareStatement("select seats from app.course where semester = ? and courseCode = ?");
            
            getCourseSeats.setString(1, semester);
            
            getCourseSeats.setString(2, courseCode);
            resultSet = getCourseSeats.executeQuery();
            
            
            while(resultSet.next())
            {
            
                seats = resultSet.getInt(1);
            }
        }
        
        catch(SQLException sqlException)
        {
        
            sqlException.printStackTrace();
        }
        
        return seats;
        
    }
    
   
    public static void dropCourse(String semester, String courseCode)
   
    {
        
        connection = DBConnection.getConnection();
       
        try
     
        {
         
            dropCourse = connection.prepareStatement("delete from app.course where semester = ? and courseCode = ?");
         
            dropCourse.setString(1, semester);
      
            dropCourse.setString(2, courseCode);
          
            dropCourse.executeUpdate();
  
        }
        
        catch(SQLException sqlException)
        
        {
         
            sqlException.printStackTrace();
       
        }
        
    }
    
    
}