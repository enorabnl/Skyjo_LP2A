package players;

import java.util.Random;

public class Student {
    final private int studentId;
    private String pseudo;

    // Constructors
    public Student() {
        Random id=new Random();
        this.studentId=id.nextInt(1000);
        this.pseudo=null;
    }
    public Student(String pseudo) {
        Random id=new Random();
        this.studentId=id.nextInt(1000);
        this.pseudo=pseudo;
    }

    // getters & setters
    public int getStudentId() {
        return this.studentId;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo=pseudo;
    }
    // Methods
    public String toString() {
        return "ID : "+getStudentId()+" Pseudo : "+getPseudo()+"\n";
    }

}
