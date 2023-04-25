package Players;

import java.util.ArrayList;

public class Game {
    private int numberOfPlayers;
    private int numberOfCards;
    private ArrayList<Player> listOfPlayers=null;

    public Game(){
        this.numberOfPlayers=2;
        this.numberOfCards=150;
        this.listOfPlayers=new ArrayList<Player>();
    }
    public Game(int nbPlayers){
        this.numberOfPlayers=nbPlayers;
        this.numberOfCards=150;
        for(int i=0;i<nbPlayers;i++){
            System.out.println("Entrez le pseudo du joueur "+(i+1)+"\n");
            
        }
    }



}
