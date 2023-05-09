package cards;
import players.Grid;
import players.Player;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class CardsPile {
    private ArrayList<UV> listOfCard;

    /**
     * @brief the default constructor generate 152 cards with the quantity of each category
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
        ArrayList<UV> newListOfCards=new ArrayList<UV>();
        Random rand=new Random();
        int position;

        while(listOfCard.size()>0){
            position=rand.nextInt(listOfCard.size());
            newListOfCards.add(listOfCard.get(position));
            listOfCard.remove(listOfCard.get(position));
        }
        listOfCard=newListOfCards;
    }

    /**
     *
     * @return the drawn UV
     */
    public UV drawACard(){
        UV topCard=listOfCard.get(listOfCard.size()-1);
        listOfCard.remove(listOfCard.get(listOfCard.size()-1));
        return topCard;
    }


}