package skyjo;

import cards.CardsPile;
import cards.Coordinates;
import cards.DiscardPile;
import cards.UV;
import players.Grid;
import players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class SetUp {
    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers;
    private final CardsPile deck;//not going to change after run time
    private DiscardPile discard=new DiscardPile();
    private Player currentPlayer;


    // CONTRUCTORS
    public SetUp(){
        Scanner scanner = new Scanner(System.in);
        this.deck=new CardsPile();
        deck.mixPile();
        this.listOfPlayers=new ArrayList<Player>();
        int nbPlayers=0;
        CardsPile discard=new DiscardPile();

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
        currentPlayer=getListOfPlayers().get(0);
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
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player p){
        currentPlayer=p;
    }

    public void start(){
        distributeCards();
        discard.addCard(getPile().drawACard());
        displayHands();
        int i =0;
        do{
            setCurrentPlayer(getListOfPlayers().get(i));
            currentPlayer.displayHand();
            System.out.println(discard.toString());
            chooseAction();
            currentPlayer.setQuotas();
            System.out.println("New grid-------------------");
            currentPlayer.displayHand();

            if(i== listOfPlayers.size()-1){
                i=0;
            }else{
                i++;
            }
        }while(!isAGridVisible());
        displayEnd();
    }
    // METHODS----------------------------------(display)
    public void displayHands(){
        for (Player p:listOfPlayers) {
            Grid grid=p.getGrid();
            p.displayHand();
            System.out.println("\n");
        }
    }
    public void displayEnd(){
        System.out.println("----------The game is done !----------\n");
        for (Player p:listOfPlayers) {
            p.getGrid().makeTheGridVisible();
            p.displayHand();
            displayWinners();
        }
    }
    public void displayWinners(){
        if(findWinners().size()>1){
            System.out.println("The winners are : ");
        }else{
            System.out.println("The winners is : ");
        }
        for (Player p:findWinners()) {
            System.out.println(p.getData().toString());
        }
    }
    //----------------------------------------------------
    public ArrayList<Player> findWinners(){
        Player winner=listOfPlayers.get(0);
        ArrayList<Player> listOfWinner=new ArrayList<>();
        for (int i=1;i<listOfPlayers.size();i++){
            int total=listOfPlayers.get(i).getQuotas().getTotal();
            if(winner.getQuotas().getTotal()<total){
                winner=listOfPlayers.get(i);
            } else if (winner.getQuotas().getTotal()==total) {
                listOfWinner.add(listOfPlayers.get(i));
            }
        }
        listOfPlayers.add(winner);
        return listOfWinner;
    }
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
    
    public boolean isAGridVisible(){
        boolean visible;
        int i=0;
        do{
            Grid grid=getListOfPlayers().get(i).getGrid();
            visible=grid.isGridVisible();
            i++;
        }while (!visible && i<getListOfPlayers().size());
        return visible;
    }
    public void chooseAction(){
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("\nPossible actions :\nDraw in the deck (Enter 1)\nDraw in the discard (Enter 2)");
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
        drawnCard.makeVisible();
        System.out.println("Drawn card : "+drawnCard);
        do{
            System.out.println("Possible actions :\nThrow the card (Enter 1)\nReplace a card of your grid (Enter 2)");
            choice=scanner.nextInt();
        }while(choice!=1 && choice!=2);

        if(choice==1){
            discard.addCard(drawnCard);
            makeACardVisible();
        }else {
            replaceACard(drawnCard);
        }
    }
    public void drawInDiscard(){
        UV drawnCard=discard.drawACard();
        drawnCard.makeVisible();
        System.out.println("You drawn : " + drawnCard);
        replaceACard(drawnCard);
    }
    public void replaceACard( UV card){
        System.out.println("You chose to replace a card of your grid.");
        discard.addCard(currentPlayer.getGrid().swapCardsGrid(card,chooseACard()));
    }
    public void makeACardVisible(){
        System.out.println("You chose to turn over a card of your grid");
        Coordinates coordinate=new Coordinates(chooseACard().getLine(), chooseACard().getColumn());

        while(currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].isVisible()){
            System.out.println("This card is already visible, enter new coordinates");
            coordinate=chooseACard();
        }
        currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].makeVisible();
    }
    public Coordinates chooseACard(){
        Scanner scanner=new Scanner(System.in);
        int line=0;
        int column=0;
        do{
            System.out.println("Enter the line of the card you want to turn over :");
            line= scanner.nextInt();
        }while(line<1 || line>3);
        do{
            System.out.println("Enter the column of the card you want to turn over :");
            column= scanner.nextInt();
        }while(column<1 || column>4);
        return new Coordinates(line-1,column-1);
    }
    
}
