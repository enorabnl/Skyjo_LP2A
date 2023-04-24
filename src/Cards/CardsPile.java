package Cards;
import java.util.ArrayList;
import java.util.Random;

public class CardsPile {
    private ArrayList<UV> listOfCard=new ArrayList<UV>() ;

    public CardsPile(){
        this.listOfCard=null;
    }
    public CardsPile(int numberOfCards){
        this.listOfCard=null;
        for(int i=0;i<numberOfCards/4;i++){
            generateTS();
            generateTM();
            generateT2S();
            generateEC();
        }
    }
    public TS generateTS(){
        Random rand=new Random();
        String letters= String.valueOf((char)(rand.nextInt(26)+97)+(char)(rand.nextInt(26)+97));
        return new TS(letters + rand.nextInt(100),6);
    }
    public TM generateTM(){
        int credits=0;
        Random rand=new Random();
        if(rand.nextInt(2)==0){
            credits=6;
        }else{
            credits=4;
        }
        String letters= String.valueOf((char)(rand.nextInt(26)+97)+(char)(rand.nextInt(26)+97));
        return new TM(letters + rand.nextInt(100),credits);
    }
    public T2S generateT2S(){
        Random rand=new Random();
        String letters= String.valueOf((char)(rand.nextInt(26)+97)+(char)(rand.nextInt(26)+97));
        return new T2S(letters + rand.nextInt(100), rand.nextInt(5));

    }
    public EC generateEC(){
        Random rand=new Random();
        String letters= String.valueOf((char)(rand.nextInt(26)+97)+(char)(rand.nextInt(26)+97));
        return new EC(letters + rand.nextInt(100), rand.nextInt(5));

    }


    public ArrayList<UV> getListOfCard() {
        return listOfCard;
    }
    public UV getFirstCard(){
        return listOfCard.get(0);
    }
}