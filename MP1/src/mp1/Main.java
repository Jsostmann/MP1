/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jamesostmann
 */
public class Main {
    
    public static void start() {
    
    
    }
    
    
    public static void main(String[] args) {
      
        Department d = new Department();
        
        if (args.length == 0) {

            JFileChooser j = new JFileChooser();
            
            
            int r = j.showOpenDialog(null);
            int g = JFileChooser.APPROVE_OPTION;

            if (r == g) {
                
                String fName = j.getSelectedFile().getAbsolutePath();
                d.loadDepartmentData(fName);
                
                System.out.println("Department toString Method: ");
                System.out.println(d);
                
                System.out.println("getCalendar Method for: " + d.getFaculty(0).getFirstName() + " " + d.getFaculty(0).getLastName());
                System.out.println(d.getFaculty(0).getCalendar());
                
                System.out.println("atAGlance Method: ");
                System.out.println(d.atAGlance(DaysOfWeek.Monday,1305));
                
                JOptionPane.showMessageDialog(null, d.getFaculty(0).getCalendar(), d.getUniversityName() + " Output", JOptionPane.PLAIN_MESSAGE);
              
            }
            
        } else if (args.length == 1) {

            d.loadDepartmentData(args[0]);

        }

    }

}
