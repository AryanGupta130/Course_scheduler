package coursescheduleramg7817;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;

import java.sql.Timestamp;

import java.sql.Connection;

import java.util.ArrayList;

import java.sql.PreparedStatement;

import java.sql.SQLException;



/**
 *
 * @author Aryan
 */
public class ScheduleQueries {
    private static Connection conn;
    
    private static PreparedStatement addSchedule;
    
    private static PreparedStatement getSchedByStudent;
    
    private static PreparedStatement getSchedByStudentCount;
    
    private static ResultSet result;
    
    private static PreparedStatement addScheduleEntry;
    
    private static PreparedStatement getScheduledStudentsByCourse;
    
    private static PreparedStatement getWaitlistedStudentsByCourse;
    
    private static PreparedStatement dropStudentScheduleByCourse;
    
    private static PreparedStatement dropScheduleByCourse;
    
    private static PreparedStatement updateScheduleEntry;
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID)
    {
        conn = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedule = new ArrayList<>();
        try
        {
            getSchedByStudent = conn.prepareStatement("select semester, coursecode, studentID, status, timestamp from app.schedule where semester = ? and studentID = ? order by status, coursecode");
            
            getSchedByStudent.setString(1, semester);
            
            getSchedByStudent.setString(2, studentID);
            
            result = getSchedByStudent.executeQuery();
            
            while(result.next())
            {
                
                ScheduleEntry entry = new ScheduleEntry(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getTimestamp(5));
                
                schedule.add(entry);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return schedule;
        
    }
    
    public static int getScheduledStudentCount(String semester, String courseCode)
    {
        conn = DBConnection.getConnection();
        int count = 0;
        try
        {
            
            getSchedByStudentCount = conn.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ? and status = 's'");
            
            getSchedByStudentCount.setString(1, semester);
            
            getSchedByStudentCount.setString(2, courseCode);
            
            result = getSchedByStudentCount.executeQuery();
            
            while(result.next())
            {
            
                count = result.getInt(1);
            
            }
            
        }
        catch(SQLException sqlException)
        
        {
        
            sqlException.printStackTrace();
        
        }
        
        return count;
        
    }   
    
    public static void addScheduleEntry(ScheduleEntry entry)
    {
        conn = DBConnection.getConnection();
        try
        {
            addSchedule = conn.prepareStatement("insert into app.schedule (semester, coursecode, studentid, status, timestamp) values (?, ?, ?, ?, ?)");
            
            addSchedule.setString(1, entry.getSemester());
            
            addSchedule.setString(2, entry.getCourseCode());
            
            addSchedule.setString(3, entry.getStudentID());
            
            addSchedule.setString(4, entry.getStatus());
            
            addSchedule.setTimestamp(5, entry.getTimestamp());
            
            addSchedule.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    
 public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode)
    {
        conn = DBConnection.getConnection();
        
        
        ArrayList<ScheduleEntry> schedule = new ArrayList<>();
        
        try
        {
        
            getScheduledStudentsByCourse = conn.prepareStatement("select semester, coursecode, studentID, status, timestamp from app.schedule where semester = ? and courseCode = ? and status = 's' ");
            
            getScheduledStudentsByCourse.setString(1, semester);
            
            getScheduledStudentsByCourse.setString(2, courseCode);
            

            result = getScheduledStudentsByCourse.executeQuery();
            
            while(result.next())
            {
                
                ScheduleEntry entry = new ScheduleEntry(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getTimestamp(5));
                
                schedule.add(entry);
            }
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
        return schedule;
        
    }
    
   public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode)
    {
        conn = DBConnection.getConnection();
        
        ArrayList<ScheduleEntry> schedule = new ArrayList<>();
        
        try
        {
            
            getWaitlistedStudentsByCourse = conn.prepareStatement("select semester, coursecode, studentID, status, timestamp from app.schedule where semester = ? and courseCode = ? and status = 'w' order by timestamp");
            
            getWaitlistedStudentsByCourse.setString(1, semester);
            
            getWaitlistedStudentsByCourse.setString(2, courseCode);
            
            result = getWaitlistedStudentsByCourse.executeQuery();
            
            while(result.next())
            {
                
                ScheduleEntry entry = new ScheduleEntry(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getTimestamp(5));
                
                schedule.add(entry);
            }
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
        return schedule;
        
    }
   
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode)
    {
        conn = DBConnection.getConnection();
        
        try
        {
            dropStudentScheduleByCourse = conn.prepareStatement("delete from app.schedule where semester = ? and studentID = ? and courseCode = ?");
            
            dropStudentScheduleByCourse.setString(1, semester);
            
            dropStudentScheduleByCourse.setString(2, studentID);
            
            dropStudentScheduleByCourse.setString(3, courseCode);
            
            dropStudentScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
    }
   
    public static void dropScheduleByCourse(String semester, String courseCode)
    {
        conn = DBConnection.getConnection();
        
        try
        {
            
            dropScheduleByCourse = conn.prepareStatement("delete from app.schedule where semester = ? and courseCode = ?");
            
            dropScheduleByCourse.setString(1, semester);
            
            dropScheduleByCourse.setString(2, courseCode);
            
            dropScheduleByCourse.executeUpdate();
        
        }
        catch(SQLException sqlException)
        {
            
            sqlException.printStackTrace();
        
        }
        
    }
   
    public static void updateScheduleEntry(ScheduleEntry entry)
    {
        conn = DBConnection.getConnection();
        
        try
        {
            
            updateScheduleEntry = conn.prepareStatement("update app.schedule set status = 's' where semester = ? and studentID = ? and courseCode = ?");
            
            updateScheduleEntry.setString(2, entry.getStudentID());
            
            updateScheduleEntry.setString(3, entry.getCourseCode());
            
            updateScheduleEntry.setString(1, entry.getSemester());
            
            
            updateScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
}