package academic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    Course course;
    Student student;
    Enrollment enrollment;
    Lecture lecture;
    CourseOpening courseOpening;
    
    
    private ArrayList <Course> courses;
    private ArrayList <Student> students;
    private ArrayList <Enrollment> enrollments;
    private ArrayList <Lecture>  daftarDosen;
    private ArrayList <Enrollment> remedial;
    private ArrayList <CourseOpening> courseOpen;

    public Controller() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        enrollments = new ArrayList<Enrollment>();
        daftarDosen = new ArrayList<Lecture>();
        remedial = new ArrayList<Enrollment>();
        courseOpen = new ArrayList<CourseOpening>();
    }
    public void addCourse(String tok[]) {
        if(courses.isEmpty()){
            Course course = new Course(tok[1], tok[2], Integer.parseInt(tok[3]), tok[4]);
            courses.add(course);
        }else {
            boolean courseExist = false;
            for (Course c : courses) {
                if(c.getID().equals(tok[1])){
                    courseExist = true;
                    break;
                }
            }
            if(!courseExist){
                course = new Course(tok[1], tok[2], Integer.parseInt(tok[3]), tok[4]);
                courses.add(course);
            }   
        }
    }

    public void addStudent(String tok[]){
        if(students.isEmpty()){
            student = new Student(tok[1], tok[2], tok[3], tok[4]);
            students.add(student);
        }else {
            boolean studentExist = false;
            for (Student s : students) {
                if(s.getID().equals(tok[1])){
                    studentExist = true;
                    break;
                }
            }
            if(!studentExist){
                student = new Student(tok[1], tok[2], tok[3], tok[4]);
                students.add(student);
            }
        }
    }

    public void addEnrolment(String tok[]){
        boolean checkCourse = false;
        for (Course c : courses) {
            if(c.getID().equals(tok[1])){
                checkCourse = true;
                break;
            }
        }
        boolean checkStudent = false;
        for (Student s : students) {
            if(s.getID().equals(tok[2])){
                checkStudent = true;
                break;
            }
        }
        if(!checkCourse){
            System.out.println("invalid course|" + tok[1]);
        }else if(!checkStudent){
            System.out.println("invalid student|" + tok[2]);
        }

        if(checkCourse && checkStudent){
            if(enrollments.isEmpty()){
                enrollment= new Enrollment(tok[1], tok[2], tok[3], tok[4]);
                enrollments.add(enrollment);
            }else {
                boolean enrollmentExist = false;
                for (Enrollment e : enrollments) {
                    if(e.getCourseId().equals(tok[1]) && e.getID().equals(tok[2]) && e.getYear().equals(tok[3]) && e.getSemester().equals(tok[4])){
                        enrollmentExist = true;
                        break;
                    }
                }
                if (!enrollmentExist){
                    enrollment= new Enrollment(tok[1], tok[2], tok[3], tok[4]);
                    enrollments.add(enrollment);
                }
            }
        }
    }

    public void addLecture(String tok[]){
        if(daftarDosen.isEmpty()){
            lecture = new Lecture(tok[1], tok[2], tok[3], tok[4], tok[5]);
            daftarDosen.add(lecture);
        }else {
            boolean dosenExist = false;
            for (Lecture d : daftarDosen) {
                if(d.getID().equals(tok[1])){
                    dosenExist = true;
                    break;
                }
            }
            if(!dosenExist){
                lecture = new Lecture(tok[1], tok[2], tok[3], tok[4], tok[5]);
                daftarDosen.add(lecture);
            }
        }
    }

    public void enrlGrade(String tok[]){
        for(Enrollment E : enrollments){
            if(E.getCourseId().equals(tok[1]) && E.getID().equals(tok[2]) && E.getYear().equals(tok[3]) && E.getSemester().equals(tok[4])){
                E.setGrade(tok[5]);
            }
        }        
    }

    public void details(String tok[]){
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

    public void remed(String tok[]){
        String prevGrade = "";

        if(remedial.isEmpty()){
            for(Enrollment e : enrollments){
                if(e.getCourseId().equals(tok[1]) && e.getID().equals(tok[2]) && e.getYear().equals(tok[3]) && e.getSemester().equals(tok[4]) && !e.getGrade().equals("None")){
                    prevGrade = "(" + e.getGrade() + ")";
                    e.setPrevGrade(prevGrade);
                    e.setGrade(tok[5]);
                    enrollment = new Enrollment(tok[1], tok[2], tok[3], tok[4]);
                    remedial.add(enrollment);
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
                                        rem.setGrade(tok[5]);
                                        enrollment = new Enrollment(tok[1], tok[2], tok[3], tok[4]);
                                        remedial.add(enrollment);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void openCourse(String tok[]){
        String courseName = "";
        int sks = 0;
        String psGrade = "";

        for(Course c : courses){
            if(c.getID().equals(tok[1])){
                for(Lecture d : daftarDosen){
                    if(d.getIntial().equals(tok[4])){
                        String pengampu = tok[4] + " (" + d.getEmail() + ")";
                        courseName = c.getName();
                        sks = c.getCredit();
                        psGrade = c.getPassingGrade();
                        courseOpening = new CourseOpening(tok[1], courseName, sks, psGrade, tok[2], tok[3], pengampu);
                        courseOpen.add(courseOpening);
                    }
                }
            }
        }
    }

    public void history(String tok[]){
        Collections.sort(courseOpen, new Comparator<CourseOpening>(){
            public int compare(CourseOpening c1, CourseOpening c2){
                return c2.semester().compareTo(c1.semester());                                
            }
        });

        for(CourseOpening c : courseOpen){
            if(c.courseCode().equals(tok[1])){
                System.out.println(c.toString());
                for(Enrollment e : enrollments){
                    if(e.getCourseId().equals(c.courseCode()) && e.getYear().equals(c.acYear()) && e.getSemester().equals(c.semester())){
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public void print(String tok[]){
        for(Lecture d : daftarDosen){
            System.out.println(d.toString());
        }

        for (Course c : courses) {
            System.out.println(c );
        }

        for(Student s : students){
            System.out.println(s);
        }

        for(Enrollment e : enrollments){
            System.out.println(e);
        }
    }
}   