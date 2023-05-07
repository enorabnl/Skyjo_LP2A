package players;

public class Player {
    private Student data;
    private Grid grid;

    // Constructors
    public Player(){
        this.data=new Student();
        this.grid=new Grid();
    }
    public Player(Student data){
        this.data=data;
        this.grid=new Grid();
    }
    public Player(String pseudo){
        this.data=new Student(pseudo);
        this.grid=new Grid();
    }

    //getters & setters
    public Grid getGrid() {
        return grid;
    }
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    // Methods



    public String toString() {
        return data.toString();
    }
}
