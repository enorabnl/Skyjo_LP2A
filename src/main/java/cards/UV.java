package cards;

public class UV {
    private final String name;
    private final int credits;
    private boolean visible;

    public UV (String name,int credits) {
        this.name=name;
        this.credits=credits;
        this.visible=false;
    }
    /*public String getName() {
        return this.name;
    }*/
    public int getCredits () {
        return this.credits;
    }
    public boolean isVisible() {
        return this.visible;
    }
    public void makeVisible() {
        this.visible=true;
    }
    public void hide() {
        this.visible=false;
    }
    public String toString() {
        if(isVisible()){
            return this.name+" ("+credits+" "+this.getClass().getSimpleName()+")";
        }else{
            return "XXXX";
        }
    }
}
