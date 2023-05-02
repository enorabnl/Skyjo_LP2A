package cards;

import java.util.ArrayList;

public class Deck extends CardsPile{
    private ArrayList<UV> listOfCard=null;

    public Deck(){
        listOfCard=new ArrayList<UV>();
    }
    public void addCard(UV uv){
        if (!uv.isVisible()){
            uv.makeVisible();
        }
        listOfCard.add(uv);
    }

}