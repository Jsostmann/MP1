
package mp1;

import java.util.ArrayList;


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

    
    /*
      Getters and Setters
    */
    public String getFirstName() {
        return firstName;
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
    
    public ArrayList<Appointment> getAppointmentsList() {
        
        return this.appointments;
    }
    public ArrayList<Course> getCoursesList() {
    
        return this.courses;
    }
    public ArrayList<TimeBlock> getOfficeHoursList() {
        return this.officeHours;
    }
    
    
    /*
      Widget Methods For ArrayList Objects
    */ 
    public void addCourse(Course course) {
    
        courses.add(course);
    }
    public void addAppointment(Appointment apt){
    
        appointments.add(apt);
    }
    public void addOfficeHours(TimeBlock officeHrs) {
    
        officeHours.add(officeHrs);
    }
    
    
    @Override
    public String toString() {
        
        return firstName + System.lineSeparator() + lastName + System.lineSeparator() + 
                officeLocation + System.lineSeparator() + getCourses() + getOfficeHours() + getAppointments();
                
    }
    
    
    /*
      Helper Methods
    */
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
    
    /*
      Implemented Project Method
    */
    public String getCalendar() {
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        ArrayList<TimeBlock> times; 
        String result = "";
        
        
        
        for(String day: days) {
            
            times = new ArrayList<>();
            
            for(Course tempCourse: courses){
            
                for(TimeBlock courseTime: tempCourse.getTimeBlocks()) {
                
                    if(DaysOfWeek.valueOf(day).equals(courseTime.getDay())){
                    
                        times.add(courseTime);
                    
                    }
                    
                
                }
                
            }
            for(Appointment apt: appointments){
            
                if(apt.getTimeBlock().getDay().equals(DaysOfWeek.valueOf(day))) {
                
                    times.add(apt.getTimeBlock());
                
                }
            
            
            }
            for(TimeBlock officehr: officeHours){
            
                if(officehr.getDay().equals(DaysOfWeek.valueOf(day))) {
                
                    times.add(officehr);
                    
                }
                
            }
        
            for(int i = 5; i < 2400; i+=5) {
            
                for(TimeBlock temp: times){
                
                       if(temp.getStartTime() == i) {
                       
                           result += temp.toString();
                       
                       }
                
                }
            
            
            }
        
        }
    
        return result;
    
    }
    
    
    
    
}
