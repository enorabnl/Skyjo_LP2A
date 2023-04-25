package Cards;

public class UV {
    private String name;
    private int credits;
    private boolean visible;
    public UV(){
        this.name=null;
        this.credits=0;
        this.visible=false;
    }
    public UV (String name,int credits) {
        this.name=name;
        this.credits=credits;
        this.visible=false;

    }

    public String getName() {
        return this.name;
    }
    public int getCredits () {
        return this.credits;
    }
    public boolean isVisible() {
        return this.visible;
    }
    public void makeVisible() {
        this.visible=true;
    }
    @Override
    public String toString() {
        return "Name : "+ this.getName()+" Category : "+ this.getClass().getSimpleName()+" Credits : "+getCredits();
    }

}
