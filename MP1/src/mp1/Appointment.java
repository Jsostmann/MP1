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
public class Appointment {
    
    private String description;
    private TimeBlock timeBlock;
    
    public Appointment(TimeBlock timeBlock) {
    
        this.timeBlock = timeBlock;
        this.description = timeBlock.getComments();
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeBlock getTimeBlock() {
        return timeBlock;
    }

    public void setTimeBlock(TimeBlock timeBlock) {
        this.timeBlock = timeBlock;
    }
    
    public String getFormattedTimeBlocks(){
    
        return this.timeBlock.getFormatedTimeBlock() + System.lineSeparator();
        
    }

    @Override
    public String toString() {
        return description + System.lineSeparator() + timeBlock.getDay() + System.lineSeparator() +
                timeBlock.getStartTime() + System.lineSeparator() + timeBlock.getEndTime() + System.lineSeparator();
    }
    
    
    
    
    
}
