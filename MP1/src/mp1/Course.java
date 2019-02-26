
package mp1;

import java.util.ArrayList;


public class Course {
    private String courseName;
    private String location;
    private ArrayList<TimeBlock> timeBlocks;
    
    public Course(String courseName ,String location) {
        
        timeBlocks = new ArrayList<>();
        this.courseName = courseName;
        this.location = location;
    }

    /*
      Getters and Setters
    */
    public String getCourseName() {
        return courseName;
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
    
    /*
      Widget Methods For ArrayList Objects
    */
    public void addTimeBlock(TimeBlock block) {
        
        timeBlocks.add(block);
    }
   

    @Override
    public String toString() {
       return courseName + System.lineSeparator() + 
              location + System.lineSeparator() + getTimeAndDays();
               
    }
    
    /*
      Helper Method
    */
    private String getTimeAndDays(){
    
        String result = "";
        
        for(TimeBlock tempTimeBlock: timeBlocks){
        
            result += tempTimeBlock.toString();
        
        }
        return result;
    }
    
    
    
    
    
}
