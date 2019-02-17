/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;

import java.util.ArrayList;

/**
 *
 * @author jamesostmann
 */
public class Faculty {
    
    private String firstName;
    private String lastName;
    private String officeLocation;
    
    private ArrayList<Course> courses;
    private ArrayList<TimeBlock> officeHours;
    private ArrayList<Appointment> appointments;
    
    
    public Faculty(String firstName, String lastName, String officeLocation) {
            courses = new ArrayList<>();
            officeHours = new ArrayList<>();
            appointments = new ArrayList<>();
            
            this.firstName = firstName;
            this.lastName = lastName;
            this.officeLocation = officeLocation;
                  
    }

    public String getFirstName() {
        return firstName;
    }

    public void addCourse(Course course) {
    
        courses.add(course);
    }
    
    public void addAppointment(Appointment apt){
    
        appointments.add(apt);
    }
    
    public void addOfficeHours(TimeBlock officeHrs) {
    
        officeHours.add(officeHrs);
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @Override
    public String toString() {
        
        return firstName + System.lineSeparator() + lastName + System.lineSeparator() + 
                officeLocation + System.lineSeparator() + 
                getCourses() + getOfficeHours() + getAppointments();
                
    }
     
    private String getCourses(){
        
        String result = "";
        
        for(Course temp: courses) {
        
            result+= temp.toString();
            
        }
    
        return result;
        
    }
    
    private String getOfficeHours(){
        
        String result = "";
        
        for(TimeBlock temp: officeHours) {
        
            result+= temp.toString();
            
        }
    
        return result;
    
    }
    
    private String getAppointments(){
    String result = "";
        
        for(Appointment temp: appointments) {
        
            result+= temp.toString();
            
        }
    
        return result;
    }
    
    
    
    
}
