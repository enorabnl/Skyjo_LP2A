package players;

import cards.CardsPile;

import java.util.ArrayList;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers;
    private CardsPile pile;

    public Game(){
        this.numberOfPlayers=2;
        this.pile=new CardsPile();
        this.listOfPlayers=new ArrayList<Player>();
    }
    public Game(int nbPlayers){
        this.numberOfPlayers=nbPlayers;
        this.pile=new CardsPile();
        this.listOfPlayers=new ArrayList<Player>();
        for(int i=0;i<nbPlayers;i++){
            //System.out.println("Entrez le pseudo du joueur "+(i+1)+"\n");
            listOfPlayers.add(new Player(4433,"player"+i));
        }
    }

    public void displayPile(){
        this.pile.displayPile();
    }
    public void distributeCards(){
        for(Player p: listOfPlayers){
            Grid grid=p.getGrid();
            for(int line=0;line< grid.getGrid().length;line++){
                for(int column=0;column<grid.getGrid()[line].length;column++){
                    grid.getGrid()[line][column]=pile.drawACard();
                }
            }
        }
    }
    public void displayHands(){
        for (Player p:listOfPlayers) {
            Grid grid=p.getGrid();
            System.out.println("\n");
            for(int line=0;line< grid.getGrid().length;line++){
                for(int column=0;column<grid.getGrid()[line].length;column++){
                    System.out.println(grid.getGrid()[line][column].toString());
                }
            }
        }
    }



}
