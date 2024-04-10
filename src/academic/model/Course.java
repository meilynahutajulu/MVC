package academic.model;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */
public class Course extends Heritance {

    private int credits;
    private String passingGrade;

    public Course(String _code, String _name, int _credits, String _passingGrade) {
        this.id_ = _code;
        this.name_ = _name;
        this.credits = _credits;
        this.passingGrade = _passingGrade;
    }

    public int getCredit(){
        return credits;
    }

    public String getPassingGrade(){
        return passingGrade;
    }

    @Override
    public String toString() {
        return this.id_ + "|" + this.name_ + "|" + this.credits + "|" + this.passingGrade ;
    }

}