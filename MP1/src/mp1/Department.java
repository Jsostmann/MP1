/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jamesostmann
 */
public class Department {

    private String departmentName;
    private String unitName;
    private String universityName;
    private ArrayList<Faculty> faculty;
    
    
    public Department(){
        
         this(null,null,null);
       
    
    }
    public Department(String departmentName, String unitName, String universityName) {
        
        this.departmentName = departmentName;
        this.unitName = unitName;
        this.universityName = universityName;
        faculty = new ArrayList<>();

    }
    
    
    
    
    
    

    public void addFaculty(Faculty fac) {

        faculty.add(fac);

    }

    public void removeFaculty(Faculty fac) {

        faculty.remove(fac);

    }

    public Faculty getFaculty(int index) {
        if (index > -1 && index < faculty.size()) {
            return faculty.get(index);
        } else {

            return null;

        }

    }

    public int numFaculty() {

        return faculty.size();
    }

    
    
    
    
    
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return departmentName + System.lineSeparator() + 
                unitName + System.lineSeparator() + 
                universityName + System.lineSeparator() + getFaculty();
                
    }
    
    
    public String getFaculty(){
        String result = "";
        
        for(Faculty fac: faculty){
        
        
            result += fac.toString();
        
        }
        
        return result;
    
    }
    
    
    

    public void loadDepartmentData(String inputFileName) {
        try {
            
            Scanner scan = new Scanner(new File(inputFileName));
            
            departmentName = scan.nextLine();
            unitName = scan.nextLine();
            universityName = scan.nextLine();
            
            
         while(scan.hasNextLine()) {
             
            String fName = scan.nextLine();
            String lName = scan.nextLine();
            String officeLocation = scan.nextLine();
            
            Faculty fac = new Faculty(fName,lName,officeLocation);
            int numCourses = Integer.parseInt(scan.nextLine());

               for (int i = 0; i < numCourses; i++) {
                   
                String courseName = scan.nextLine();
                String courseLocation = scan.nextLine();
                
                Course course = new Course(courseName,courseLocation);
                
                int numMeetingDays = Integer.parseInt(scan.nextLine());

                    for (int j = 0; j < numMeetingDays; j++) {
                    
                        
                         String day = scan.nextLine();
                         DaysOfWeek realDay = DaysOfWeek.valueOf(day);
                         
                         
                         int startT = Integer.parseInt(scan.nextLine());
                         int endT = Integer.parseInt(scan.nextLine());
                         TimeBlock courseBlock = new TimeBlock(realDay,startT,endT);
                        
                        course.addTimeBlock(courseBlock);
                        
                    }

                 fac.addCourse(course);
            }
               
             int officeHrs = Integer.parseInt(scan.nextLine());
             
             for(int k = 0; k < officeHrs; k++) {
             
                 DaysOfWeek day = DaysOfWeek.valueOf(scan.nextLine());
                 int startT = Integer.parseInt(scan.nextLine());
                 int endT = Integer.parseInt(scan.nextLine());
                 
                TimeBlock officeHr = new TimeBlock(day,startT,endT);
                fac.addOfficeHours(officeHr);
                
             }
             
             int apptHrs = Integer.parseInt(scan.nextLine());
             
             for(int j = 0; j < apptHrs; j++) {
                    
                 String description = scan.nextLine();
                 DaysOfWeek day = DaysOfWeek.valueOf(scan.nextLine());
                 int startT = Integer.parseInt(scan.nextLine());
                 int endT = Integer.parseInt(scan.nextLine());
                 
                 TimeBlock block = new TimeBlock(day,startT,endT,description);
                 Appointment apt = new Appointment(block);
                 
                 fac.addAppointment(apt);
                 
             }
            
            
            
            
            
            
            faculty.add(fac);
         }
            scan.close();
        
        
        
        } catch(FileNotFoundException e) {
        
            System.err.println("Couldnt find file for reading.");
            System.exit(-1);
        
        }
    }

    public void saveDepartmentData(String outputFileName) {

        try {
        
            PrintWriter output = new PrintWriter(new File(outputFileName));
            
            output.print(this.toString());
            
            output.close();
          
            
        } catch (IOException e) {
        
            System.err.println("Couldnt find file for writing.");
            System.exit(-1);
        
        
        }
        
    }

}
