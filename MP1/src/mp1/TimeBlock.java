package mp1;

public class TimeBlock {

    private DaysOfWeek day;
    private int startTime;
    private int endTime;
    private String comments;
    private String location;

    public TimeBlock(DaysOfWeek day, int startTime, int endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;

    }
    public TimeBlock(DaysOfWeek day, int startTime, int endTime, String comments) {

        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.comments = comments;

    }
    public TimeBlock(DaysOfWeek day, int startTime, int endTime, String comments, String location) {

        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.comments = comments;
        this.location = location;

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
    
    /*
      Implemented Project Method
    */
    public String getFormatedTimeBlock() {

        return startTime + " - " + endTime + " \t" + comments + "\t" + location;

    }

 

}
