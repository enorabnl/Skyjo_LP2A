package skyjo;

import cards.CardsPile;
import cards.Discard;
import cards.UV;
import players.Grid;
import players.Player;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class SetUp {
    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers;
    private final CardsPile deck;//not going to change after run time
    private Discard discard=new Discard();
    private Player curentPlayer;


    // CONTRUCTORS
    public SetUp(){
        Scanner scanner = new Scanner(System.in);
        this.deck=new CardsPile();
        deck.mixPile();
        this.listOfPlayers=new ArrayList<Player>();
        int nbPlayers=0;
        CardsPile discard=new Discard();

        do{
            System.out.println("How many players ? (2 to 8 players)");
            nbPlayers=scanner.nextInt();
            this.numberOfPlayers=nbPlayers;
        }while (nbPlayers<2 || nbPlayers>8);

        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter the name of the player n°"+(i+1)+" (Be carefull, only one word is required) :");
            String playerName= scanner.next();
            listOfPlayers.add(new Player(playerName));
        }
        curentPlayer=getListOfPlayers().get(0);
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
        return deck;
    }


    // METHODS
    public void distributeCards(){
        for(Player p: listOfPlayers){
            Grid grid=p.getGrid();
            for(int line=0;line< grid.getGrid().length;line++){
                for(int column=0;column<grid.getGrid()[line].length;column++){
                    grid.getGrid()[line][column]=deck.drawACard();
                }
            }
        }
    }
    public void displayHands(){
        for (Player p:listOfPlayers) {
            Grid grid=p.getGrid();
            System.out.println(p.getData().toString());
            grid.displayGrid();
            System.out.println("\n");
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
        Random rand = new Random();

        distributeCards();
        discard.addCard(getPile().drawACard());


        //Player startingPlayer = getListOfPlayers().get(i.nextInt(getNumberOfPlayers())-1);
        /*
        piocher dans deck -echanger-jeter la carte de la grille que l'on a échangé
        piocher dans deck -jeter-retourner une carte de la grille
         */
        /*
        piocher dans Discard - echanger - jeter la carte de la grille que l'on a échangé
        piocher dans deck - echanger - jeter la carte de la grille que l'on a échangé
        piocher dans deck - jeter - retourner une carte de la grille
         */


    }
    public void gameBoard(){
        displayHands();
        discard.displayDiscard();
        System.out.println("deck :"+ deck.getACard(1).toString());

    }
    public void chooseAction(){
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("Possible actions :\nDraw in the deck (Enter 1)\nDraw in the discard (Enter2)");
            choice=scanner.nextInt();
        }while(choice!=1 && choice!=2);

        if(choice==1){
            drawInDeck();
        }else{
            drawInDiscard();
        }
    }
    public void drawInDeck(){
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        UV drawnCard=deck.drawACard();
        System.out.println(drawnCard);
        do{
            System.out.println("Possible actions :\nThrow the card (Enter 1)\nReplace a card of your grid (Enter2)");
            choice=scanner.nextInt();
        }while(choice!=1 && choice!=2);

        if(choice==1){
            discard.addCard(drawnCard);
        }else {
            replaceACard(drawnCard);
        }
    }
    public void drawInDiscard(){
        UV drawnCard=discard.drawACard();
        System.out.println(drawnCard);
        replaceACard(drawnCard);
    }
    public void replaceACard( UV card){
        Scanner scanner=new Scanner(System.in);
        int line=0;
        int column=0;
        do{
            System.out.println("Enter the line of the card you want to replace :");
            line= scanner.nextInt();
        }while(line<1 || line>3);
        do{
            System.out.println("Enter the column of the card you want to replace :");
            column= scanner.nextInt();
        }while(column<1 || column>4);
        curentPlayer.getGrid().swapCardsGrid(card,line,column);
    }



}
