package academic.model;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */
public class Enrollment extends Heritance {

    private String courseId;
    private String year;
    private String semester;
    private String grade = "None";
    private String prevGrade = "";

    public Enrollment(String _courseId, String _studentId, String _year, String _semester) {
        this.courseId = _courseId;
        this.id_ = _studentId;
        this.year = _year;
        this.semester = _semester;
    }
    public String getCourseId() {
        return courseId;
    }
    public String getYear() {
        return year;
    }
    public String getSemester() {
        return semester;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String _grade) {
        this.grade = _grade;
    }
    public void setPrevGrade(String _prevGrade) {
        this.prevGrade = _prevGrade;
    }

    @Override
    public String toString() {
        return this.courseId + "|" + this.id_ + "|" + this.year + "|" + this.semester + "|" + grade + prevGrade;
    }
}