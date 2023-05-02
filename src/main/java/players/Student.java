package players;

public class Student {
    private int studentId;
    private String pseudo;

    public Student(int id, String pseudo) {
        this.studentId=id;
        this.pseudo=pseudo;

    }
    public Student() {
        this.studentId=0;
        this.pseudo=null;
    }
    public Student(int id) {
        this.studentId=id;
        this.pseudo=null;
    }
    public Student(String pseudo) {
        this.studentId=0;
        this.pseudo=pseudo;
    }


    public int getStudentId() {
        return this.studentId;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public void setStudentId(int id) {
        this.studentId=id;
    }
    public void setPseudo(String pseudo) {
        this.pseudo=pseudo;
    }


}
