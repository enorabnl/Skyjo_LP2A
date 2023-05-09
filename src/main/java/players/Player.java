package players;

public class Player {
    private Student data;
    private Grid grid;
    private Quotas quotas;

    // Constructors
    public Player(){
        this.data=new Student();
        this.grid=new Grid();
        this.quotas=new Quotas();
    }
    public Player(Student data){
        this.data=data;
        this.grid=new Grid();
        this.quotas=new Quotas();
    }
    public Player(String pseudo){
        this.data=new Student(pseudo);
        this.grid=new Grid();
        this.quotas=new Quotas();
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

    public Quotas getQuotas() {
        return quotas;
    }
    public void setQuotas(Quotas quotas) {
        this.quotas = quotas;
    }
// Methods



    public String toString() {
        return data.toString();
    }
}
