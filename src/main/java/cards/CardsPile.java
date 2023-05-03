package cards;
import players.Grid;
import players.Player;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class CardsPile {
    private ArrayList<UV> listOfCard=null;


    // CONSTRUCTORS


    /**
     * @brief the default constructor generate 152 cards with the quantity of each category
     */
    public CardsPile(){
        this.listOfCard= new ArrayList<UV>();
        for(int i=0;i<152/4;i++){
            listOfCard.add(new CS());
            listOfCard.add(new TM());
            listOfCard.add(new T2S());
            listOfCard.add(new EC());
        }
    }


    // GETTERS & SETTERS
    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }
    public UV getACard(int position){
        if(position<1){
            return null;
        }else{
        return listOfCard.get(position-1);}
    }


    // METHODS

    /**
     * @brief this method mix the pile by adding randomly each card of the initial pile to a new one
     */
    public void mixPile(){
        ArrayList<UV> newListOfCards=new ArrayList<UV>();
        Random rand=new Random();
        int position=0;

        while(listOfCard.size()>0){
            position=rand.nextInt(listOfCard.size());
            newListOfCards.add(listOfCard.get(position));
            listOfCard.remove(listOfCard.get(position));
        }
        listOfCard=newListOfCards;
    }

    /**
     * TEEESSSSTTTTT
     */
    public void displayPile(){
        if(listOfCard.isEmpty()){
            System.out.println("The list is empty");
        }else{
            int i=0;
            for (UV c:listOfCard) {
                i++;
                System.out.println(i+ c.toString());

            }
        }
    }

    /**
     *
     * @return the drawn UV
     */
    public UV drawACard(){
       /* for (UV c:listOfCard) {
            System.out.println(c);
        }*/
        UV topCard=listOfCard.get(0);
        listOfCard.remove(listOfCard.get(0));
        return topCard;
    }


}