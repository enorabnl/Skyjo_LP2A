package main;

import cards.CardsPile;
import cards.TM;
import cards.UV;
import players.Game;
import players.Player;

public class Main {
    public static void main(String[] args) {
        Game game=new Game(2);
        game.getPile().displayPile();
        game.distributeCards();
        System.out.println("\n hands\n");
        game.displayHands();

        boolean teste=true;
        game.getListOfPlayers().get(0).getGrid().makeACardVisible(1,2);

        teste=game.getListOfPlayers().get(0).getGrid().isGridVisible();
        if (teste){
            System.out.println("True");
        }else{System.out.println("False");}
    }

}