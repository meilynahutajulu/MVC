package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;
import academic.model.Course;
import academic.model.CourseOpening;
import academic.model.Enrollment;
import academic.model.Lecture;
import academic.model.Student;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */
public class Driver1 {

    public static void main(String[] _args) {
        
        Scanner input = new Scanner(System.in);
        Course course;
        Student mahasiswa;
        Enrollment enroll;
        Lecture dosen;
        CourseOpening _openCourse;


        ArrayList <Course> courses = new ArrayList<Course>();
        ArrayList <Student> students = new ArrayList<Student>();
        ArrayList <Enrollment> enrollments = new ArrayList<Enrollment>();
        ArrayList <Lecture>  daftarDosen = new ArrayList<Lecture>();
        ArrayList <Enrollment> remedial = new ArrayList<Enrollment>();
        ArrayList <CourseOpening> courseOpen = new ArrayList<CourseOpening>();

        // cara print list of object

        while (input.hasNextLine()) {
                
                String masukan = input.nextLine();

                String tok[] = masukan.split("#");

                String command = tok[0];

                if(command.equals("course-add")){
                    String code = tok[1];
                    String name = tok[2];
                    int credits = Integer.parseInt(tok[3]);
                    String passingGrade = tok[4];
                    
                    
                    if(courses.isEmpty()){
                        course = new Course(code, name, credits, passingGrade);
                        courses.add(course);
                    }else {
                        boolean courseExist = false;
                        for (Course c : courses) {
                            if(c.getID().equals(code)){
                                courseExist = true;
                                break;
                            }
                        }
                        if(!courseExist){
                            course = new Course(code, name, credits, passingGrade);
                            courses.add(course);
                        }
                    }
                } 
                if (masukan.equals("---")) {
                    for(Lecture d : daftarDosen){
                        System.out.println(d.toString());
                    }

                    for (Course c : courses) {
                        System.out.println(c );
                    }
                    //System.out.println(out);

                    for(Student s : students){
                        System.out.println(s);
                    }

                    for(Enrollment e : enrollments){
                        System.out.println(e);
                    }

                    break;
                }
                else if(command.equals("student-add")){
                    String nim = tok[1];
                    String name = tok[2];
                    String year = tok[3];
                    String prodi = tok[4];
                    
                    if(students.isEmpty()){
                        mahasiswa = new Student(nim, name, year, prodi);
                        students.add(mahasiswa);
                    }else {
                        boolean studentExist = false;
                        for (Student s : students) {
                            if(s.getID().equals(nim)){
                                studentExist = true;
                                break;
                            }
                        }
                        if(!studentExist){
                            mahasiswa = new Student(nim, name, year, prodi);
                            students.add(mahasiswa);
                        }
                    }
                    
                }
                else if(command.equals("enrollment-add")){
                    String courseId = tok[1];
                    String student = tok[2];
                    String year = tok[3];
                    String semester = tok[4];

                    boolean checkCourse = false;
                    for (Course c : courses) {
                        if(c.getID().equals(courseId)){
                            checkCourse = true;
                            break;
                        }
                    }
                    boolean checkStudent = false;
                    for (Student s : students) {
                        if(s.getID().equals(student)){
                            checkStudent = true;
                            break;
                        }
                    }
                    if(!checkCourse){
                        System.out.println("invalid course|" + courseId);
                    }else if(!checkStudent){
                        System.out.println("invalid student|" + student);
                    }

                    if(checkCourse && checkStudent){
                        if(enrollments.isEmpty()){
                            enroll = new Enrollment(courseId, student, year, semester);
                            enrollments.add(enroll);
                        }else {
                            boolean enrollmentExist = false;
                            for (Enrollment e : enrollments) {
                                if(e.getCourseId().equals(courseId) && e.getID().equals(student) && e.getYear().equals(year) && e.getSemester().equals(semester)){
                                    enrollmentExist = true;
                                    break;
                                }
                            }
                            if (!enrollmentExist){
                                enroll = new Enrollment(courseId, student, year, semester);
                                enrollments.add(enroll);
                            }
                        }
                    }
                }
                else if (command.equals("lecturer-add")) {
                    String nID = tok[1];
                    String name = tok[2];
                    String intial = tok[3];
                    String email = tok[4];
                    String studyProgram = tok[5];

                    if(daftarDosen.isEmpty()){
                        dosen = new Lecture(nID, name, intial, email, studyProgram);
                        daftarDosen.add(dosen);
                    }else {
                        boolean dosenExist = false;
                        for (Lecture d : daftarDosen) {
                            if(d.getID().equals(nID)){
                                dosenExist = true;
                                break;
                            }
                        }
                        if(!dosenExist){
                            dosen = new Lecture(nID, name, intial, email, studyProgram);
                            daftarDosen.add(dosen);
                        }
                    }
                }
                else if (command.equals("enrollment-grade")){
                    String courseId = tok[1];
                    String student = tok[2];
                    String year = tok[3];
                    String semester = tok[4];
                    String grade = tok[5];
                    for(Enrollment E : enrollments){
                        if(E.getCourseId().equals(courseId)){
                            if(E.getID().equals(student)){
                                if(E.getYear().equals(year)){
                                    if(E.getSemester().equals(semester)){
                                        E.setGrade(grade);
                                    }
                                }
                            }
                        }
                    }
                }
                else if(command.equals("student-details")){
                    int index = 0;
                    String[] nilai = new String[10];
                    int[] sks = new int[10];
                    String[] matkul = new String[10];

                

                    for(Student S : students){
                        if(S.getID().equals(tok[1])){
                            for(Enrollment E : enrollments){
                                if(E.getID().equals(tok[1])){
                                       
                                            matkul[index] = E.getCourseId();
                                            nilai[index] = E.getGrade();
                                        
                                    for(Course C : courses){
                                        if(C.getID().equals(matkul[index])){
                                            sks[index] = C.getCredit();
                                        }
                                    }
                                    index++;
                                }
                            }
                        }
                    }
                    
                    Double totalNilai = 0.00;
                    Double IPK = 0.00;
                    int totalSKS = 0;

                    for (int a = 0; a < index; a++){
                        for (int j = a+1; j < index; j++){                        
                            if(matkul[a].equals(matkul[j])){
                                nilai[a] = "None";
                            }
                        }
                    }
                    
                    for(int i = 0; i < index; i++){
                        if(nilai[i].equals("A")){
                            totalNilai = totalNilai + (sks[i] * 4.00);
                        }
                        if(nilai[i].equals("AB")){
                            totalNilai = totalNilai + (sks[i] * 3.50);
                        }
                        if(nilai[i].equals("B")){
                            totalNilai = totalNilai + (sks[i] * 3.00);
                        }
                        if(nilai[i].equals("BC")){
                            totalNilai = totalNilai + (sks[i] * 2.50);
                        }
                        if(nilai[i].equals("C")){
                            totalNilai = totalNilai + (sks[i] * 2.00);
                        }
                        if(nilai[i].equals("D")){
                            totalNilai = totalNilai + (sks[i] * 1.00);
                        }
                        if(nilai[i].equals("E")){
                            totalNilai = totalNilai + (sks[i] * 0.00);
                        }
                        if(nilai[i].equals("None")){
                            totalNilai = totalNilai + (sks[i] * 0.00);
                            sks[i] = 0;
                        }
                        totalSKS = totalSKS + sks[i];
                    }
                    if(totalSKS == 0){
                        IPK = 0.00;
                    } else {
                        IPK = totalNilai / totalSKS;   
                    }   
        
                    for(Student Stdnt : students){
                        if(Stdnt.getID().equals(tok[1])){
                            System.out.print(Stdnt.toString()+"|");
                            System.out.print(String.format(("%.2f"), IPK));
                            System.out.println("|" + totalSKS);
                        }
                    }
        
                }
                else if(command.equals("enrollment-remedial")){
                    String courseId = tok[1];
                    String student = tok[2];
                    String year = tok[3];
                    String semester = tok[4];
                    String grade = tok[5];
                    String prevGrade = "";

                    if(remedial.isEmpty()){
                        for(Enrollment e : enrollments){
                            if(e.getCourseId().equals(tok[1])){
                                if(e.getID().equals(tok[2])){
                                    if(e.getYear().equals(tok[3])){
                                        if(e.getSemester().equals(tok[4])){
                                            if(!e.getGrade().equals("None")){
                                                prevGrade = "(" + e.getGrade() + ")";
                                                e.setPrevGrade(prevGrade);
                                                e.setGrade(grade);
                                                enroll = new Enrollment(courseId, student, year, semester);
                                                remedial.add(enroll);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        boolean remedialExist = false;
                        for(Enrollment e : remedial){
                            if(e.getCourseId().equals(tok[1])){
                                if(e.getID().equals(tok[2])){
                                    if(e.getYear().equals(tok[3])){
                                        if(e.getSemester().equals(tok[4])){
                                            remedialExist = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        } if(!remedialExist){
                            for(Enrollment rem : enrollments){
                                if(rem.getCourseId().equals(tok[1])){
                                    if(rem.getID().equals(tok[2])){
                                        if(rem.getYear().equals(tok[3])){
                                            if(rem.getSemester().equals(tok[4])){
                                                if(!rem.getGrade().equals("None")){
                                                    prevGrade = "(" +rem.getGrade() + ")";
                                                    rem.setPrevGrade(prevGrade);
                                                    rem.setGrade(grade);
                                                    enroll = new Enrollment(courseId, student, year, semester);
                                                    remedial.add(enroll);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                }
                else if(command.equals("course-open")){
                    String courseId = tok[1];
                    String year = tok[2];
                    String semester = tok[3];
                    String lecturer = tok[4];
                    String courseName = "";
                    int sks = 0;
                    String psGrade = "";

                    for(Course c : courses){
                        if(c.getID().equals(courseId)){
                            for(Lecture d : daftarDosen){
                                if(d.getIntial().equals(lecturer)){
                                    String pengampu = lecturer + " (" + d.getEmail() + ")";
                                    courseName = c.getName();
                                    sks = c.getCredit();
                                    psGrade = c.getPassingGrade();
                                    _openCourse = new CourseOpening(courseId, courseName, sks, psGrade, year, semester, pengampu);
                                    courseOpen.add(_openCourse);
                                }
                            }
                        }
                    }
                }
                else if(command.equals("course-history")){
                    String codeMatkul = tok[1];

                    Collections.sort(courseOpen, new Comparator<CourseOpening>(){
                        public int compare(CourseOpening c1, CourseOpening c2){
                                return c2.semester().compareTo(c1.semester());                                
                        }
                    });

                    for(CourseOpening c : courseOpen){
                        if(c.courseCode().equals(codeMatkul)){
                            System.out.println(c.toString());
                            for(Enrollment e : enrollments){
                                if(e.getCourseId().equals(c.courseCode()) && e.getYear().equals(c.acYear()) && e.getSemester().equals(c.semester())){
                                    System.out.println(e);
                                }
                            }
                        }
                    }
                }
        }

    input.close();
    }

}