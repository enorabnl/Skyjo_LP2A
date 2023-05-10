package skyjo;

import cards.CardsPile;
import cards.Coordinates;
import cards.DiscardPile;
import cards.UV;
import players.Grid;
import players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int numberOfPlayers;
    private final ArrayList<Player> listOfPlayers;
    private final CardsPile deck;
    private final DiscardPile discard;
    private Player currentPlayer;

    public Game(){
        listOfPlayers=new ArrayList<>();
        deck=new CardsPile();
        discard=new DiscardPile();
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }
    public CardsPile getDeck() {
        return deck;
    }
    public DiscardPile getDiscard() {return discard;}
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player p){
        currentPlayer=p;
    }
    public void setup(){
        Scanner scanner = new Scanner(System.in);
        int playAgain=3;
        do{
            if(playAgain==3){
                newPlayers();
            }
            play();
            do{
                System.out.println("Are you done playing ? (Enter 1)\nDo you want play again with the same players ? (Enter 2)\nDo you want to play again, btu with different players ? (Enter 3)\n");
                playAgain=scanner.nextInt();
            }while(playAgain<1 || playAgain>3);
        }while(playAgain!=1);
    }
    public void newPlayers(){
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("How many players ? (2 to 8 players)");
            setNumberOfPlayers(scanner.nextInt());
        }while (getNumberOfPlayers()<2 || getNumberOfPlayers()>8);
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter the name of the player n°"+(i+1)+" (Be carefull, only one word is required) :");
            listOfPlayers.add(new Player(scanner.next()));
        }
    }
    public void play(){
        currentPlayer=getListOfPlayers().get(0);
        deck.mixPile();
        distributeCards();
        discard.addCard(getDeck().drawACard());
        displayHands();
        int i =0;
        do{
            setCurrentPlayer(getListOfPlayers().get(i));
            System.out.println(currentPlayer.getData().getPseudo()+", it's your turn!");
            currentPlayer.displayHand();
            System.out.println(discard);
            chooseAction();
            currentPlayer.setQuotas();
            System.out.println("New grid-------------------");
            currentPlayer.displayHand();
            if(i== listOfPlayers.size()-1){
                i=0;
            }else{
                i++;
            }
        }while(noGridVisible());
        displayEnd();
    }
    public void displayHands(){
        for (Player p:listOfPlayers) {
            p.displayHand();
            System.out.println("\n");
        }
    }
    public void displayEnd(){
        System.out.println("----------The game is done !----------\n");
        for (Player p:listOfPlayers) {
            p.getGrid().makeTheGridVisible();
            p.displayHand();
        }
        displayWinners();
    }
    public void displayWinners(){
        if(findWinners().size()>1){
            System.out.println("The winners are : ");
        }else{
            System.out.println("The winner is : ");
        }
        for (Player p:findWinners()) {
            System.out.println(p.getData().toString());
        }
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
    public boolean noGridVisible(){
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
        int choice;
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
        int choice;
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
        System.out.println("You have to replace a card of your grid.");
        discard.addCard(currentPlayer.getGrid().swapCardsGrid(card,chooseACard()));
    }
    public void makeACardVisible(){
        System.out.println("You have to turn over a card of your grid");
        Coordinates coordinate=chooseACard();
        while(currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].isVisible()){
            System.out.println("This card is already visible, enter new coordinates");
            coordinate=chooseACard();
        }
        currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].makeVisible();
    }
    public Coordinates chooseACard(){
        Scanner scanner=new Scanner(System.in);
        int line;
        int column;
        do{
            System.out.println("Enter the line of this card :");
            line= scanner.nextInt();
        }while(line<1 || line>3);
        do{
            System.out.println("Enter the column of this card :");
            column= scanner.nextInt();
        }while(column<1 || column>4);
        return new Coordinates(line-1,column-1);
    }
    public ArrayList<Player> findWinners(){
        ArrayList<Player> listOfWinner=new ArrayList<>();
        listOfWinner.add(getListOfPlayers().get(0));
        int totalWinner=listOfWinner.get(0).getQuotas().getTotal();
        for (int i=1;i<listOfPlayers.size();i++){
            int totalPlayer=listOfPlayers.get(i).getQuotas().getTotal();
            if(totalWinner<totalPlayer){
                listOfWinner.clear();
                listOfWinner.add(getListOfPlayers().get(i));
                totalWinner=listOfWinner.get(0).getQuotas().getTotal();
            } else if (totalWinner==totalPlayer) {
                listOfWinner.add(listOfPlayers.get(i));
            }
        }
        return listOfWinner;
    }
}
