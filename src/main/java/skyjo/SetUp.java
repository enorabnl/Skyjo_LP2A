package skyjo;

import cards.CardsPile;
import cards.Deck;
import players.Grid;
import players.Player;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class SetUp {
    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers;
    private final CardsPile pile;//not going to change after run time


    // CONTRUCTORS
    public SetUp(){
        Scanner scanner = new Scanner(System.in);
        this.pile=new CardsPile();
        this.listOfPlayers=new ArrayList<Player>();
        System.out.println("How many players ?");
        int numberOfPlayers= scanner.nextInt();
        this.numberOfPlayers=numberOfPlayers;
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter the name of the player n°"+(i+1)+" :");
            String playerName= scanner.nextLine();
            listOfPlayers.add(new Player(playerName));
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
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        for (Player p:listOfPlayers) {
            System.out.println(p);
        }
        //set listOf Players
        distributeCards();
        displayHands();
        /*
        Creation of the deck. We put the on top card of the pile in the deck.
         */
        CardsPile deck=new Deck();
        deck.getListOfCard().add(getPile().drawACard());

        //We choose randomly the player who is going to start
        //Player startingPlayer = getListOfPlayers().get(i.nextInt(getNumberOfPlayers())-1);
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
