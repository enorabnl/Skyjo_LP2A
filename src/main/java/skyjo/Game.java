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
    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    private void setCurrentPlayer(Player p){
        currentPlayer=p;
    }

    /*
    The ACTIONS methods
     */
    public void chooseAction(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("--------------------");
        do{
            System.out.println("Possible actions :\nDraw in the deck (Enter 1)\nDraw in the discard (Enter 2)");
            choice=scanner.nextInt();
        }while(choice!=1 && choice!=2);
        System.out.println("--------------------");
        if(choice==1){
            drawInDeck();
        }else{
            drawInDiscard();
        }
    }
    private void drawInDeck(){
        Scanner scanner=new Scanner(System.in);
        int choice;
        UV drewCard=deck.drawACard();
        drewCard.makeVisible();
        System.out.println("--> You drew : "+drewCard);
        System.out.println("--------------------");
        do{
            System.out.println("Possible actions :\nThrow the card (Enter 1)\nReplace a card of your grid (Enter 2)");
            choice=scanner.nextInt();
        }while(choice!=1 && choice!=2);
        System.out.println("--------------------");

        if(choice==1){
            discard.addCard(drewCard);
            makeACardVisible();
        }else {
            replaceACard(drewCard);
        }
    }
    private void drawInDiscard(){
        UV drewCard=discard.drawACard();
        drewCard.makeVisible();
        System.out.println("--> You drew : " + drewCard);
        replaceACard(drewCard);
    }
    private void replaceACard( UV card){
        System.out.println("--> You have to replace a card of your grid");
        currentPlayer.displayHand();
        discard.addCard(currentPlayer.getGrid().swapCardsGrid(card,chooseACard()));
    }
    private void makeACardVisible(){
        System.out.println("--> You have to turn over a card of your grid");
        currentPlayer.displayHand();
        Coordinates coordinate=chooseACard();
        while(currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].isVisible()){
            System.out.println("WARNING : This card is already visible, enter new coordinates !");
            coordinate=chooseACard();
        }
        currentPlayer.getGrid().getGrid()[coordinate.getLine()][coordinate.getColumn()].makeVisible();
    }
    private Coordinates chooseACard(){
        Scanner scanner=new Scanner(System.in);
        int line;
        int column;
        System.out.println("--------------------");
        do{
            System.out.println("Enter the line of this card :");
            line= scanner.nextInt();
        }while(line<1 || line>3);
        do{
            System.out.println("Enter the column of this card :");
            column= scanner.nextInt();
        }while(column<1 || column>4);
        System.out.println("--------------------");
        return new Coordinates(line-1,column-1);
    }

    /*
    The DISPLAY methods
     */
    private void displayHands(){
        for (Player p:listOfPlayers) {
            p.displayHand();
            System.out.println("\n");
        }
    }
    private void displayEnd(){
        System.out.println("--------------------\nThe game is done !\n--------------------");
        for (Player p:listOfPlayers) {
            p.getGrid().makeTheGridVisible();
            p.displayHand();
        }
        displayWinners();
    }
    private void displayWinners(){
        if(findWinners().size()>1){
            System.out.println("--------------------\nThe winners are : ");
        }else{
            System.out.println("--------------------\nThe winner is : ");
        }
        for (Player p:findWinners()) {
            System.out.println(p.getData().toString());
        }
        System.out.println("--------------------");

    }

    /*
    The TEST and SETUP methods
     */
    private void distributeCards(){
        for(Player p: listOfPlayers){
            Grid grid=p.getGrid();
            for(int line=0;line< grid.getGrid().length;line++){
                for(int column=0;column<grid.getGrid()[line].length;column++){
                    grid.getGrid()[line][column]=deck.drawACard();
                }
            }
        }
        discard.addCard(deck.drawACard());
    }
    private ArrayList<Player> findWinners(){
        ArrayList<Player> listOfWinner=new ArrayList<>();
        listOfWinner.add(listOfPlayers.get(0));
        int totalWinner=listOfWinner.get(0).getQuotas().getTotal();
        for (int i=1;i<listOfPlayers.size();i++){
            int totalPlayer=listOfPlayers.get(i).getQuotas().getTotal();
            if(totalWinner<totalPlayer){
                listOfWinner.clear();
                listOfWinner.add(listOfPlayers.get(i));
                totalWinner=listOfWinner.get(0).getQuotas().getTotal();
            } else if (totalWinner==totalPlayer) {
                listOfWinner.add(listOfPlayers.get(i));
            }
        }
        return listOfWinner;
    }
    private boolean noGridVisible(){
        boolean visible;
        int i=0;
        do{
            Grid grid=listOfPlayers.get(i).getGrid();
            visible=grid.isGridVisible();
            i++;
        }while (!visible && i<listOfPlayers.size());
        return !visible;
    }
    private void putCardsBackToDeck(){
        if(!discard.getListOfCard().isEmpty()){
            for(int i=0;i<discard.getListOfCard().size();i++){
                UV card=discard.getListOfCard().get(i);
                card.hide();
                deck.getListOfCard().add(card);
                discard.getListOfCard().remove(card);
            }
        }
    }
    private void newPlayers(){
        Scanner scanner = new Scanner(System.in);
        listOfPlayers.clear();
        System.out.println("--------------------\nCreation of a game:");
        do{
            System.out.println("How many players ? (2 to 8 players)");
            setNumberOfPlayers(scanner.nextInt());
        }while (numberOfPlayers<2 || numberOfPlayers>8);
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter the name of the player n°"+(i+1)+" (Be carefull, only one word is required) :");
            listOfPlayers.add(new Player(scanner.next()));
        }
        System.out.println("--------------------");
    }
    private void play(){
        putCardsBackToDeck();
        deck.mixPile();
        distributeCards();
        displayHands();
        int i =0;
        do{
            setCurrentPlayer(listOfPlayers.get(i));
            System.out.println("--------------------\n"+currentPlayer.getData().getPseudo()+", it's your turn!");
            currentPlayer.displayHand();
            System.out.println(discard);
            chooseAction();
            currentPlayer.setQuotas();
            System.out.println("--------------------\nNew grid:");
            currentPlayer.displayHand();
            System.out.println("--------------------");

            if(i== listOfPlayers.size()-1){
                i=0;
            }else{
                i++;
            }
        }while(noGridVisible());
        displayEnd();
    }
    public void setup(){
        Scanner scanner = new Scanner(System.in);
        int playAgain=3;
        do{
            if(playAgain==3){
                newPlayers();
            }
            play();
            System.out.println("--------------------");
            do{
                System.out.println("Are you done playing ? (Enter 1)\nDo you want play again with the same players ? (Enter 2)\nDo you want to play again, btu with different players ? (Enter 3)\n");
                playAgain=scanner.nextInt();
            }while(playAgain<1 || playAgain>3);
            System.out.println("--------------------");
        }while(playAgain!=1);
    }
}
