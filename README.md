# Major Program 1
## COMP 167 Spring 2019
### Due 2/27/2019 at 6:00 pm

## Introduction

This program will require you to create a program that will allow faculty members to post their course and office hour schedules.

## Git and GitHub

You will submit this project using GitHub pull requests. You **must** create a GitHub pull request for each level to receive credit. You should request your assigned reviewer on your pull request. Review the following resource on git and GitHub for major programs _before_ you start work:

- [Written Explanation](https://gist.github.com/ccannon94/511115be821a873ae9ec5f4db9cfdda0)
- [YouTube Video](https://www.youtube.com/watch?v=l2bP9JKQkdA)

You **must** complete all work on a separate branch. You CAN NOT push code to the master branch. Review the above git and GitHub resources to learn about branching.

You **must** add your assigned TA as a reviewer for your pull requests. You can find your assigned reviewer [here](./assigned-reviewers.csv).

## Enumeration

First of all, this project utilizes enumerated types which help your program’s readability. Here is an example:

```java
public enum DaysOfWeek {
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```

The code above would appear in a separate file named **DaysOfWeek.java** and would serve as the data type for variables that could only have the values: `SUNDAY`, `MONDAY`, `TUESDAY`, `WEDNESDAY`, `THURSDAY`, `FRIDAY`, `SATURDAY`. Notice, these are not Strings! Internally, `SUNDAY=0`, `MONDAY=1`, `TUESDAY=2`, `WEDNESDAY=3`, `THURSDAY=4`, `FRIDAY=5`, `SATURDAY=6`. However, the enumerated type is more elegant way of representing these values. The following examples should also prove helpful to you:

```java
DaysOfWeek firstDayOfWeek = DaysOfWeek.SUNDAY;
```

You can also retrieve the String value of an enumeration. The following example would give the String `value` the value `"SUNDAY"`:

```java
String value = firstDayOfWeek.name();
```

## UML Class Diagrams

Here are the UML Class Diagrams for the classes you must implement in Java. You are free to add additional private methods if needed.

![TimeBlock UML Diagram](https://github.com/NCATCS/Spring2019-MP1/blob/master/images/TimeBlock.png)

The method `getFormatedTimeBlock()` should return a string in the following format:
```
startTime - endTime comments location (e.g. 1200 - 1300 COMP167 ACB 207 )
```

![Appointment UML Diagram](https://github.com/NCATCS/Spring2019-MP1/blob/master/images/Appointment.png)

![Course UML Diagram](https://github.com/NCATCS/Spring2019-MP1/blob/master/images/Course.png)

![Faculty UML Diagram](https://github.com/NCATCS/Spring2019-MP1/blob/master/images/Faculty.png)

The method `getCalendar()` should return all course items, office hour items and appointment items. Each item (i.e. formatted `TimeBlock`) should be listed under a heading with the day of the week. Within a particular day, the items should be listed in sorted order by time (Hint: Sorting is not necessary -- use a loop that goes from 5 to 2400 by 5's.).

![Department UML Diagram](https://github.com/NCATCS/Spring2019-MP1/blob/master/images/Department.png)

## The toString() method

The toString method should return a String formatted as in the input file. Notice that `TimeBlock.toString()` will not include the `location` or `comment` properties. Most classes will have each property on a new line, `TimeBlock` properties will be separated by a comma.

## Hanlding ArrayLists

Each `ArrayList` should have five associated methods to perform: getNum, add, get, set and remove. So if you have an `ArrayList` named `widgets` that stored items of type `Widget`, then the associated UML would be:

```
+getNumWidgets() : int //Return the number of items in the ArrayList widgets.
+getWidget(index:int) : Widget //get the Widget at location index in ArrayList widgets
+setWidget(index:int, item:Widget):void //store item at location index in the ArrayList widgets. +addWidget(item:Widget):void //Append the Widget to the ArrayList.
+removeWidget(index:int):Widget //remove the Widget stored at the given index and return it
```

## Input File

The input file will be supplied to your `main()` method using command-line arguments. Your labs have covered how to use command-line arguments to pass information to your program. Your `main()` method should check to see if a file is passed to it. If there is no supplied input file, your program should present the user with the `JFileChooser` to allow them to select one. The format for the input file is shown below:

```
Department Name
College Name
University Name
Faculty0 First Name
Faculty0 Last Name
Faculty0 Office Location
Faculty0 Number of Courses
Course0 Name
Course0 Location
Course0 Number of meeting days
Course0 Day of the week, Start_Time, End_Time
* repeat for other days
* repeat for other courses
Faculty0 Number of office hour sessions
Office Hours0 Day of the week, Start_Time, End_Time
* Repeat for other office hours.
Faculty0 Number of Appointments
Appointments0 Description
Appointments0 Day of the week, Start_Time, End_Time
* Repeat for other appointments.
* Repeat for other faculty

The file will end when there are no more faculty.
```

You should also reference the input file provided in this repository.

## Notes

- When outputting office hour information, use the string `“Office Hours”` as a description.
- All start and end times will be a multiple of 5.

## Output File

The format of the output file is the same as the input file. If you have created the `toString()` method for the `Department` class correctly, the produced `String` should match the input/output format. This should make this method trivial to write.

## Grading

You must create a driver program (`main()` method) for each level that demonstrates that the all the functionality of that level works correctly. You must push your work to GitHub and open a GitHub pull request for EACH level.

### Level 1: 25 points
Complete the `DaysOfWeek` enumerated type, the `TimeBlock` class, the `Course` class and the `Appointment` class. Write a simple driver program that will instantiate an object of each class type, populate the data fields and test the other methods of the classes. Display your output in a `JavaFX Dialog`.

### Level 2: 10 points
Complete all of the `Faculty` class except for the `getCalendar()` and `atAGlance()` methods.

### Level 3: 20 points
Complete all of the `Department` class except for the `loadDepartmentData()` and `saveDepartmentData()`
classes.

### Level 4: 30 points
Implement the `loadDepartmentData()` and `saveDepartmentData()` methods. Your `main()` method should obtain the input file name from the command-line arguments. Also, your `main()` should prompt the user for an input file name if no command-line argument is passed.

### Level 5: 15 points
Implement the `getCalender()` and `atAGlance()` methods.
