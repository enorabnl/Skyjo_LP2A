package players;

import java.util.Random;

public class Student {
    final private int studentId;
    final private String pseudo;

    public Student(String pseudo) {
        Random id=new Random();
        this.studentId=id.nextInt(1000);
        this.pseudo=pseudo;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public String toString() {
        return "ID : "+studentId+" Pseudo : "+pseudo+"\n";
    }

}
