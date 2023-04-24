package Players;

public class Player {
    private Student data;
    private Grid grid;
    public Player(){
        this.data=new Student();
        this.grid=new Grid();
    }
    public Player(Student data){
        this.data=data;
        this.grid=new Grid();
    }
    public Player(int id, String pseudo){
        this.data=new Student(id,pseudo);
        this.grid=new Grid();
    }

    public Grid getGrid() {
        return grid;
    }
    public Student getData() {
        return data;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setData(Student data) {
        this.data = data;
    }
}
