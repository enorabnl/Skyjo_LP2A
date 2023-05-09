package cards;

public class DiscardPile extends CardsPile{

    public DiscardPile(){
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
    public String toString(){
        return "\nDiscard : "+getListOfCard().get(getListOfCard().size()-1)+"\n";
    }

}