package cards;

import java.util.ArrayList;

public class Deck extends CardsPile{

    // CONSTRUCTOR
    public Deck(){
        super();
    }

    /**
     *
     * @param uv to add to the deck
     */
    public void addCard(UV uv){
        if (!uv.isVisible()){
            uv.makeVisible();
        }
        getListOfCard().add(uv);
    }

}