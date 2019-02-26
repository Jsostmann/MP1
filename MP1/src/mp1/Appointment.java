
package mp1;

public class Appointment {

    private String description;
    private TimeBlock timeBlock;

    public Appointment(TimeBlock timeBlock) {

        this.timeBlock = timeBlock;
        this.description = timeBlock.getComments();

    }

    /*
      Getters and Setters
    */
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
    
     @Override
    public String toString() {
        return description + System.lineSeparator() + timeBlock.toString();
    }
    
    /*
      Implemented Project Method
    */
    public String getFormattedTimeBlocks() {

        return this.timeBlock.getFormatedTimeBlock() + System.lineSeparator();

    }

   

}
