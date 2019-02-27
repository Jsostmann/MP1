
package mp1;

import java.util.ArrayList;


public class Course {
    private String courseName;
    private String location;
    private ArrayList<TimeBlock> timeBlocks;
    
    public Course() {
        
        timeBlocks = new ArrayList<>();
        this.courseName = null;
        this.location = null;
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
    
    
    
    /*
      Widget Methods For ArrayList Objects
    */
    public void addTimeBlock(TimeBlock block) {
        timeBlocks.add(block);
    }
    public TimeBlock getTimeBlock(int index){
        if(index > -1 && index < timeBlocks.size()) {
            return timeBlocks.get(index);
        } else {
            return null;
        }
    }
    public int getTimeBlocksSize(){
        return timeBlocks.size();
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
