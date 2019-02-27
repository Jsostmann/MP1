package mp1;

public class TimeBlock {

    private DaysOfWeek day;
    private int startTime;
    private int endTime;
    private String comments;
    private String location;

    public TimeBlock() {
        

    }
  
  

    /*
      Getters and Setters
    */
    public DaysOfWeek getDay() {
        return day;
    }
    public void setDay(DaysOfWeek day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    
    @Override
    public String toString() {
        return day + ", " + startTime + ", " + endTime + System.lineSeparator();
    }
    
   

 

}
