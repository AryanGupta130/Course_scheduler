/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursescheduleramg7817;

/**
 *
 * @author Aryan
 */
public class CourseEntry {
    
    private String courseDes;
    
    private int seats;
    
    private String semester;
    
    private String courseCode;
    
    

    public CourseEntry(String semester, String courseCode, String courseDescription, int seats) {
        
        this.semester = semester;
        
        this.courseCode = courseCode;
        
        this.courseDes = courseDescription;
        
        this.seats = seats;
    }
    
    public String getCourseCode() {
     
        return courseCode;
    
    }

    public String getSemester() {
        
        return semester;

    }

    public String getCourseDescription() {
        return courseDes;
    }


    public int getSeats() {
        return seats;
    }
    
}
