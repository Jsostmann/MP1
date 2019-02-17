/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;

/**
 *
 * @author jamesostmann
 */
public class Main {
    
    public static void main(String[] args) {
       /* TimeBlock timeb1 = new TimeBlock(DaysOfWeek.Monday,1500,1700,"COMP 163","Cherry 150");
        TimeBlock timeb2 = new TimeBlock(DaysOfWeek.Tuesday,1200,1500,"COMP 163","Cherry 150");
        TimeBlock timeb3 = new TimeBlock(DaysOfWeek.Wednesday,1000,1200,"COMP 163","Cherry 150");
        
        TimeBlock timb4 = new TimeBlock(DaysOfWeek.Thursday,2100,3500,"lunch");
        TimeBlock timb5 = new TimeBlock(DaysOfWeek.Sunday,1000,1500,"church");

        
        
        Appointment apt1 = new Appointment(timb4);
        Appointment apt2 = new Appointment(timb5);
        
        Course course1 = new Course(timeb1.getComments(),timeb1.getLocation());
        course1.addTimeBlock(timeb1);
        course1.addTimeBlock(timeb2);
        course1.addTimeBlock(timeb3);
        
        
        TimeBlock timeb7 = new TimeBlock(DaysOfWeek.Monday,1500,1700,"COMP 167","Graham 111");
        TimeBlock timeb8 = new TimeBlock(DaysOfWeek.Tuesday,1200,1500,"COMP 167","Graham 111");
        TimeBlock timeb9 = new TimeBlock(DaysOfWeek.Wednesday,1000,1200,"COMP 167","Graham 111");
        
        
        Course course2 = new Course(timeb7.getComments(),timeb7.getLocation());
        course2.addTimeBlock(timeb7);
        course2.addTimeBlock(timeb8);
        course2.addTimeBlock(timeb9);
        
        
        TimeBlock timeb10 = new TimeBlock(DaysOfWeek.Monday,1500,1700,"");
        TimeBlock timeb11 = new TimeBlock(DaysOfWeek.Thursday,1500,1700,"");

        
        Faculty fac1 = new Faculty("Kelvin","Bryant","McNair 506");
        fac1.addCourse(course1);
        fac1.addCourse(course2);
        fac1.addAppointment(apt1);
        fac1.addAppointment(apt2);
        fac1.addOfficeHours(timeb10);
        fac1.addOfficeHours(timeb11);
        
        Department d1 = new Department();
        d1.addFaculty(fac1);
        
        System.out.println(d1.toString());
        
        */
       
       Department t = new Department();
       
       t.loadDepartmentData("departmentData.txt");
       System.out.println(t.toString()); 
       
      
       
      
     
        
        
        

        

                
        
    }
    
    
}
