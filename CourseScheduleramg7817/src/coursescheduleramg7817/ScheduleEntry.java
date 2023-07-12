package coursescheduleramg7817;

import java.sql.Timestamp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan
 */
public class ScheduleEntry {
    
    private String semester;
    
    private String status;
    
    private String courseCode;
    
    private String studentID;
    
    private Timestamp Timestamp;
    

    public ScheduleEntry(String semester, String courseCode, String studentID, String status, Timestamp Timestamp) {
        
        this.semester = semester;
        
        this.Timestamp = Timestamp;
        
        this.courseCode = courseCode;
        
        this.status = status;
        
        this.studentID = studentID;
        
    }
    
    public String getStudentID() {
    
        return studentID;
    
    }

    public String getSemester() {
        
        return semester;
        
    }

    public String getCourseCode() {
        
        return courseCode;
    
    }

    public Timestamp getTimestamp() {
        return Timestamp;
    }
    

    public String getStatus() {
   
        return status;
     
    }

    
}
