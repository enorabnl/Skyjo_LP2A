package cards;

public class DiscardPile extends CardsPile{

    /**
     * @brief Call the super default constructor
     */
    public DiscardPile(){
        super();
    }

    /**
     * @brief This method makes sure the card given in argument is visible (and make it if it's not) before adding it to the pile
     * @param uv to add to the discard
     */
    public void addCard(UV uv){
        if (!uv.isVisible()){
            uv.makeVisible();
        }
        /*
        The cards are drawn at the beginning of the pile, so they must also be added at the beginning
        We add the card at the index 0
         */
        getListOfCard().add(0,uv);
    }

    /**
     * @return a String which contains the first card of the pile
     */
    public String toString(){
        return "Discard : "+getListOfCard().get(0);
    }

}