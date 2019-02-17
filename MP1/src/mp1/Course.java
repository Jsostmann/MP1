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
public class Course {
    private String courseName;
    private String location;
    private ArrayList<TimeBlock> timeBlocks;
    
    public Course(String courseName ,String location) {
        
        timeBlocks = new ArrayList<>();
        this.courseName = courseName;
        this.location = location;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addTimeBlock(TimeBlock block) {
        
        timeBlocks.add(block);
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<TimeBlock> getTimeBlocks() {
        return timeBlocks;
    }

    public void setTimeBlocks(ArrayList<TimeBlock> timeBlocks) {
        this.timeBlocks = timeBlocks;
    }

    @Override
    public String toString() {
       return courseName + System.lineSeparator() + 
              location + System.lineSeparator() + getTimeAndDays();
               
    }
    
    private String getTimeAndDays(){
    
        String result = "";
        
        for(TimeBlock tempTimeBlock: timeBlocks){
        
            result += tempTimeBlock.toString();
        
        }
        return result;
    }
    
    
    
    
    
}
