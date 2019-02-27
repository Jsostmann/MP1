
package mp1;

import java.util.ArrayList;


public class Faculty {
    
    private String firstName;
    private String lastName;
    private String officeLocation;
    
    private ArrayList<Course> courses;
    private ArrayList<TimeBlock> officeHours;
    private ArrayList<Appointment> appointments;
    
    
    public Faculty() {
            courses = new ArrayList<>();
            officeHours = new ArrayList<>();
            appointments = new ArrayList<>();
            
            this.firstName = null;
            this.lastName = null;
            this.officeLocation = null;
                  
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
    public Appointment getAppointment(int index){
        if(index > -1 && index < appointments.size()) {
            return appointments.get(index);
        } else {
            return null;
        }
    }
    public Course getCourse(int index){
        if(index > -1 && index < courses.size()) {
            return courses.get(index);
        } else {
            return null;
        }
    }
    public TimeBlock getOfficeHour(int index){
        if(index > -1 && index < officeHours.size()) {
            return officeHours.get(index);
        } else {
            return null;
        }
    }
    public int getAppointmentsize(){
        return appointments.size();
    }
    public int getCourseSize() {
        return courses.size();
    }
    public int getOfficeHoursSize() {
        return officeHours.size();
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
        
        String result = "Office Hours" + System.lineSeparator();
        
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
            result += day + System.lineSeparator();
            
            for(Course tempCourse: courses){
            
                for(int i = 0; i < tempCourse.getTimeBlocksSize(); i++) {
                
                    if(DaysOfWeek.valueOf(day).equals(tempCourse.getTimeBlock(i).getDay())){
                    
                        times.add(tempCourse.getTimeBlock(i));
                    
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
                          result += String.format("\t %-30s %d - %d \n",temp.getComments(),temp.getStartTime(),temp.getEndTime());
                       
                       }
                
                }
            
            
            }
            
            
        
        }
    
 
        
        return result;
    
    }
    
    
    
    
    
    
}
