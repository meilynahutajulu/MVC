package academic.model;

/**
 * @author 12S22039 - Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */

 public record CourseOpening(String courseCode, String courseName, int sks, String passGrade, String acYear, 
                                String semester, String lecturer) {
    @Override
    public String toString() {
        return courseCode + "|" + courseName + "|" + sks + "|" + passGrade + "|" + acYear + "|" + semester + "|" + lecturer;
    }
 }


 
// public class CourseOpening {
//     private String courseCode;
//     private String courseName;
//     private int sks;
//     private String passGrade;
//     private String acYear;
//     private String semester;
//     private String lecturer;

//     public CourseOpening(String _courseCode, String _courseName, int _sks, String _passGrade, String _acYear, String _semester, String _lecturer) {
//         this.courseCode = _courseCode;
//         this.courseName = _courseName;
//         this.sks = _sks;
//         this.passGrade = _passGrade;
//         this.acYear = _acYear;
//         this.semester = _semester;
//         this.lecturer = _lecturer;
//     }

//     public String getCourseCode() {
//         return courseCode;
//     }
//     public String getAcyear() {
//         return acYear;
//     }
//     public String getSemester() {
//         return semester;
//     }

//     public String toString(){
//         return courseCode +"|" + courseName + "|" + sks + "|" + passGrade + "|"+ acYear + "|" + semester + "|" + lecturer;
//     }

// }