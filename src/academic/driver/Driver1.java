package academic.driver;

import java.util.Scanner;
import academic.model.*;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */
public class Driver1 {

    public static void main(String[] _args) {
        
        Scanner input = new Scanner(System.in);
        Controller test = new Controller();
        
        while (input.hasNextLine()) {
                
                String masukan = input.nextLine();
                String tok[] = masukan.split("#");
                String command = tok[0];

                if(command.equals("course-add")){
                    test.addCourse(tok);
                } 
                if (masukan.equals("---")) {
                    test.print(tok);
                    break;
                }
                else if(command.equals("student-add")){
                    test.addStudent(tok);                    
                }
                else if(command.equals("enrollment-add")){
                    test.addEnrolment(tok);
                }
                else if (command.equals("lecturer-add")) {
                    test.addLecture(tok);
                }
                else if (command.equals("enrollment-grade")){
                    test.enrlGrade(tok);
                }
                else if(command.equals("student-details")){
                    test.details(tok);        
                }
                else if(command.equals("enrollment-remedial")){
                    test.remed(tok);
                }
                else if(command.equals("course-open")){
                    test.openCourse(tok);
                }
                else if(command.equals("course-history")){
                    test.history(tok);
                }
        }

    input.close();
    }

}