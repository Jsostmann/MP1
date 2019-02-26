
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

        this(null, null, null);

    }
    public Department(String departmentName, String unitName, String universityName) {

        this.departmentName = departmentName;
        this.unitName = unitName;
        this.universityName = universityName;
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
    private boolean isDuringTime(TimeBlock t, int time) {

        return time >= t.getStartTime() && time <= t.getEndTime();

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

                    Course course = new Course(courseName, courseLocation);

                    int numMeetingDays = Integer.parseInt(scan.nextLine());

                    for (int j = 0; j < numMeetingDays; j++) {

                        String[] data = scan.nextLine().trim().split(",");

                        DaysOfWeek realDay = DaysOfWeek.valueOf(data[0].trim());
                        int startT = Integer.parseInt(data[1].trim());
                        int endT = Integer.parseInt(data[2].trim());
                        TimeBlock courseBlock = new TimeBlock(realDay, startT, endT);

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

                    TimeBlock officeHr = new TimeBlock(realDay, startT, endT);
                    fac.addOfficeHours(officeHr);

                }

                int apptHrs = Integer.parseInt(scan.nextLine());

                for (int j = 0; j < apptHrs; j++) {

                    String description = scan.nextLine();
                    String[] data = scan.nextLine().trim().split(",");

                    DaysOfWeek realDay = DaysOfWeek.valueOf(data[0].trim());
                    int startT = Integer.parseInt(data[1].trim());
                    int endT = Integer.parseInt(data[2].trim());

                    TimeBlock block = new TimeBlock(realDay, startT, endT, description);
                    Appointment apt = new Appointment(block);

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
    public String atAGlance(int time) {
        String result = "";
        ArrayList<TimeBlock> times;

        for (Faculty tempFaculty : faculty) {

            times = new ArrayList<>();

            for (Course tempCourse : tempFaculty.getCoursesList()) {

                for (TimeBlock tempTime : tempCourse.getTimeBlocks()) {

                    if (isDuringTime(tempTime, time)) {

                        times.add(tempTime);

                    }

                }

            }

            for (Appointment apt : tempFaculty.getAppointmentsList()) {

                TimeBlock aptTimeBlock = apt.getTimeBlock();

                if (isDuringTime(aptTimeBlock, time)) {

                    times.add(aptTimeBlock);
                }
            }

            for (TimeBlock officeHr : tempFaculty.getOfficeHoursList()) {

                if (isDuringTime(officeHr, time)) {

                    times.add(officeHr);
                }

            }

            result += tempFaculty.getFirstName() + System.lineSeparator()
                    + tempFaculty.getLastName() + System.lineSeparator();

            for (TimeBlock tempTime : times) {

                result += tempTime.toString();

            }

        }

        return result;
    }
}
