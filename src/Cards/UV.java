package Cards;

public class UV {
    private String name;
    private String category;
    private int credits;
    private boolean visible;

    public UV (String name,String category,int credits) {
        this.name=name;
        this.category=category;
        this.credits=credits;
        this.visible=false;

    }

    public String getName() {
        return this.name;
    }
    public String getCategory() {
        return this.category;
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
}
