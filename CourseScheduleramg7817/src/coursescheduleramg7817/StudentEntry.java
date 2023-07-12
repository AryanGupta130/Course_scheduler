/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursescheduleramg7817;

/**
 *
 * @author Aryan
 */
public class StudentEntry {
    
    private String studentID;
    
    private String FirstName;
    
    private String LastName;

    
    public StudentEntry(String studentID, String FirstName, String LastName) {
        
        this.studentID = studentID;
        
        this.FirstName = FirstName;
        
        this.LastName = LastName;
    
    }

    
    public String getStudentID() {
        
        return studentID;
    
    }


    public String getFirstName() {
        
        return FirstName;
    
    }

    public String getLastName() {
        
        return LastName;
    
    }
 
    public void setStudentID(String studentID) {
        
        this.studentID = studentID;
    
    }

    public void setFirstName(String firstName) {
        
        this.FirstName = firstName;
    
    }

    public void setLastName(String lastName) {
        
        this.LastName = lastName;
    
    }
    
    @Override
    public String toString() {
        
        return LastName + ", " + FirstName;
    }
    
    
}
