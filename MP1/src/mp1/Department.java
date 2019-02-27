
package mp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Department {

    private String departmentName;
    private String unitName;
    private String universityName;
    private ArrayList<Faculty> faculty;

    
    public Department() {

        this.departmentName = null;
        this.unitName = null;
        this.universityName = null;
        faculty = new ArrayList<>();

    }

    
    /*
      Widget Methods For ArrayList Objects
    */
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

    
    /*
      Getters and Setters
    */
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
        return departmentName + System.lineSeparator()
                + unitName + System.lineSeparator()
                + universityName + System.lineSeparator() + getFaculty();

    }
    
    /*
      Helper Methods
    */
    private String getFaculty() {
        String result = "";

        for (Faculty fac : faculty) {

            result += fac.toString();

        }

        return result;

    }
    private boolean isDuringTime(DaysOfWeek day, TimeBlock t, int time) {

        return t.getDay() == day && time >= t.getStartTime() && time <= t.getEndTime();

    }
    
    
    /*
      Implemented Project Methods
    */
    public void loadDepartmentData(String inputFileName) {
        try {

            Scanner scan = new Scanner(new File(inputFileName));

            departmentName = scan.nextLine();
            unitName = scan.nextLine();
            universityName = scan.nextLine();

            while (scan.hasNextLine()) {

                String fName = scan.nextLine();
                String lName = scan.nextLine();
                String officeLocation = scan.nextLine();

                Faculty fac = new Faculty(fName, lName, officeLocation);
                int numCourses = Integer.parseInt(scan.nextLine());

                for (int i = 0; i < numCourses; i++) {

                    String courseName = scan.nextLine();
                    String courseLocation = scan.nextLine();

                    Course course = new Course();
                    course.setCourseName(courseName);
                    course.setLocation(courseLocation);

                    int numMeetingDays = Integer.parseInt(scan.nextLine());

                    for (int j = 0; j < numMeetingDays; j++) {

                        String[] data = scan.nextLine().trim().split(",");

                        DaysOfWeek realDay = DaysOfWeek.valueOf(data[0].trim());
                        int startT = Integer.parseInt(data[1].trim());
                        int endT = Integer.parseInt(data[2].trim());
                        TimeBlock courseBlock = new TimeBlock();
                        courseBlock.setDay(realDay);
                        courseBlock.setStartTime(startT);
                        courseBlock.setEndTime(endT);
                        courseBlock.setComments(courseName);

                        course.addTimeBlock(courseBlock);

                    }

                    fac.addCourse(course);
                }

                int officeHrs = Integer.parseInt(scan.nextLine());

                for (int k = 0; k < officeHrs; k++) {

                    String[] data = scan.nextLine().trim().split(",");

                    DaysOfWeek realDay = DaysOfWeek.valueOf(data[0].trim());
                    int startT = Integer.parseInt(data[1].trim());
                    int endT = Integer.parseInt(data[2].trim());

                    TimeBlock officeHr = new TimeBlock();
                    officeHr.setDay(realDay);
                    officeHr.setStartTime(startT);
                    officeHr.setEndTime(endT);
                    officeHr.setComments("Office Hours");
                    fac.addOfficeHours(officeHr);

                }

                int apptHrs = Integer.parseInt(scan.nextLine());

                for (int j = 0; j < apptHrs; j++) {

                    String description = scan.nextLine();
                    String[] data = scan.nextLine().trim().split(",");

                    DaysOfWeek realDay = DaysOfWeek.valueOf(data[0].trim());
                    int startT = Integer.parseInt(data[1].trim());
                    int endT = Integer.parseInt(data[2].trim());

                    TimeBlock block = new TimeBlock();
                    block.setDay(realDay);
                    block.setStartTime(startT);
                    block.setEndTime(endT);
                    block.setComments(description);
                    
                    Appointment apt = new Appointment();
                    apt.setTimeBlock(block);
                    apt.setDescription(block.getComments());
                    
                    fac.addAppointment(apt);

                }

                faculty.add(fac);
            }
            scan.close();

        } catch (FileNotFoundException e) {

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
    public String atAGlance(DaysOfWeek day, int time) {
        String result = "";
        ArrayList<TimeBlock> times;

        for (Faculty tempFaculty : faculty) {

            times = new ArrayList<>();

            for (int j = 0; j < tempFaculty.getCourseSize(); j++) {

                for (int i = 0; i < tempFaculty.getCourse(j).getTimeBlocksSize(); i++) {

                    if(isDuringTime(day,tempFaculty.getCourse(j).getTimeBlock(i),time)) {

                        times.add(tempFaculty.getCourse(j).getTimeBlock(i));

                    }

                }

            }

            for (int i = 0; i < tempFaculty.getAppointmentsize(); i++) {

                TimeBlock aptTimeBlock = tempFaculty.getAppointment(i).getTimeBlock();

                if (isDuringTime(day,aptTimeBlock,time)) {
                    
                    times.add(aptTimeBlock);
                }
            }

            for (int i = 0; i < tempFaculty.getOfficeHoursSize(); i++) {

                if (isDuringTime(day,tempFaculty.getOfficeHour(i), time)) {

                    times.add(tempFaculty.getOfficeHour(i));
                }

            }

            result += tempFaculty.getFirstName() + " " + tempFaculty.getLastName() + System.lineSeparator();
                   

            for (TimeBlock tempTime : times) {

                result += String.format("\t%-30s%d-%d\n",tempTime.getComments(),tempTime.getStartTime(),tempTime.getEndTime());
            }

        }

        return result;
    }
}
