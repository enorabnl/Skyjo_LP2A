package Cards;
import java.util.ArrayList;

public class CardsPile {
    private ArrayList<UV> listOfCard=new ArrayList<UV>() ;

    public CardsPile(){
        this.listOfCard=null;
    }
    public CardsPile(int numberOfCards){
        this.listOfCard=null;

        for(int i=0;i<numberOfCards/4;i++){
            TS newCard = new TS("PM23",3);
            listOfCard.add(newCard);
        }

    }



    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }
    public UV getFirstCard(){
        return listOfCard.get(0);
    }
}