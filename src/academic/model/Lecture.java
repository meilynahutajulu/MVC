package academic.model;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */

public class Lecture extends Heritance {
    private String intial;
    private String email;
    private String studyProgram;

    public Lecture (String _nID, String _name, String _intial, String _email, String _studyProgram){
        this.id_ = _nID;
        this.name_ = _name;
        this.intial = _intial;
        this.email = _email;
        this.studyProgram = _studyProgram;
    }

    public String getEmail(){
        return email;
    }
    public String getIntial(){
        return intial;
    }

    @Override
    public String toString(){
        return this.id_ + "|" + this.name_ + "|" + this.intial + "|" + this.email + "|" + this.studyProgram;
    }
}
