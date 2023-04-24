package Cards;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class CardsPile {
    private ArrayList<UV> listOfCard=null;

    public CardsPile(){
        this.listOfCard= new ArrayList<UV>();
    }
    public CardsPile(int numberOfCards){
        this.listOfCard= new ArrayList<UV>();
        for(int i=0;i<numberOfCards/4;i++){
            listOfCard.add(new CS());
            listOfCard.add(new TM());
            listOfCard.add(new T2S());
            listOfCard.add(new EC());
        }
    }


    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }
    public UV getACard(int position){
        return listOfCard.get(position-1);
    }
    public void mixPile(){
        ArrayList<UV> newListOfCards=new ArrayList<UV>();
        Random rand=new Random();
        int position=0;

        while(listOfCard.size()>0){
        position=rand.nextInt(listOfCard.size());
        newListOfCards.add(listOfCard.get(position));
        listOfCard.remove(listOfCard.get(position));
        }
        listOfCard=newListOfCards;// does this well tranfer one list in another one ?
    }
    public void displayPile(){
        if(listOfCard.isEmpty()){
            System.out.println("The list is empty");
        }else{
            ListIterator<UV> i=listOfCard.listIterator();
            while(i.hasNext()){
                System.out.println(i.next());
            }
        }
    }
}