package Cards;
import java.util.ArrayList;

public class CardsPile {
    private int numberOfCards;
    private ArrayList<UV> listOfCard=new ArrayList<UV>() ;

    public CardsPile(){
        this.numberOfCards=0;
        this.listOfCard=null;
    }

    public CardsPile (int numberOfCards){
        this.numberOfCards=numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }
    public UV getFirstCard(){
        return listOfCard.get(0);
    }
}