package cards;

import java.util.ArrayList;
import java.util.Random;

public class CardsPile {
    private ArrayList<UV> listOfCard;

    /**
     * @brief the default constructor generate 152 cards with the same quantity of each category
     */
    public CardsPile(){
        this.listOfCard= new ArrayList<>();
        for(int i=0;i<152/4;i++){
            listOfCard.add(new CS());
            listOfCard.add(new TM());
            listOfCard.add(new T2S());
            listOfCard.add(new EC());
        }
    }
    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }

    /**
     * @brief this method mix the pile by adding randomly each card of the initial pile to a new one
     */
    public void mixPile(){
        ArrayList<UV> newListOfCards=new ArrayList<>();
        Random rand=new Random();
        int position;
        /*
        The mixed pile is a new pile.
        Each element that is added to that new pile is removed from the initial one.
        We do this operation until the initial pile is not empty.
         */
        while(!listOfCard.isEmpty()){
            position=rand.nextInt(listOfCard.size());
            newListOfCards.add(listOfCard.get(position));
            listOfCard.remove(listOfCard.get(position));
        }
        listOfCard=newListOfCards;
    }

    /**
     * @brief This method draws the top card of the pile
     * @return the drawn UV / the top card of the pile
     */
    public UV drawACard(){
        UV topCard=listOfCard.get(0);
        listOfCard.remove(0);
        return topCard;
    }
}