package cards;

public class Discard extends CardsPile{

    // CONSTRUCTOR
    public Discard(){
        super();
    }

    /**
     *
     * @param uv to add to the discard
     */
    public void addCard(UV uv){
        if (!uv.isVisible()){
            uv.makeVisible();
        }
        getListOfCard().add(uv);
    }
    public void displayDiscard(){
        System.out.println("\nDiscard : "+getACard(getListOfCard().size()));
    }

}