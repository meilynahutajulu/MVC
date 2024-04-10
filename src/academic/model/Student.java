package academic.model;

/**
 * @author 12S22039 Meilyna Silvia Anggreini Hutajulu
 * @author NIM Nama
 */
public class Student extends Heritance {
    private String angkatan;
    private String jurusan;

    public Student(String _id, String _nama, String _angkatan, String _jurusan) {
        this.id_ = _id;
        this.name_ = _nama;
        this.angkatan = _angkatan;
        this.jurusan = _jurusan;
    }

    public String getAngkatan() {
        return angkatan;
    }
    public String getJurusan() {
        return jurusan;
    }

    @Override
    public String toString() {
        return this.id_ + "|" + this.name_ + "|" + this.angkatan + "|" + this.jurusan;
    }

}