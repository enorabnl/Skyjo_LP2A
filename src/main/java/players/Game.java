package players;

import cards.CardsPile;
import cards.Deck;

import java.util.Random;
import java.util.ArrayList;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers;
    private final CardsPile pile;//not going to change after run time


    // CONTRUCTORS
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


    // GETTERS & SETTERS
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }
    public void setListOfPlayers(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    public CardsPile getPile() {
        return pile;
    }


    // METHODS
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
    public boolean isAGridVisible(){
        boolean visible=false;
        int i=0;
        do{
            Grid grid=getListOfPlayers().get(i).getGrid();
            visible=grid.isGridVisible();
            i++;
        }while (!visible );
        return visible;
    }
    public void start(){
        /*
        Set up
        */
        Random i = new Random();
        //set listOf Players
        distributeCards();
        displayHands();
        /*
        Creation of the deck. We put the on top card of the pile in the deck.
         */
        CardsPile deck=new Deck();
        deck.getListOfCard().add(getPile().drawACard());

        //We choose randomly the player who is going to start
        Player startingPlayer = getListOfPlayers().get(i.nextInt(getNumberOfPlayers())-1);
        /*
        piocher dans PILE -echanger-jeter la carte de la grille que l'on a échangé
        piocher dans PILE -jeter-retourner une carte de la grille
         */
        /*
        piocher dans DECK - echanger - jeter la carte de la grille que l'on a échangé
        piocher dans PILE - echanger - jeter la carte de la grille que l'on a échangé
        piocher dans PILE - jeter - retourner une carte de la grille
         */


    }



}
