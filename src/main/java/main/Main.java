package main;

import cards.CardsPile;
import cards.TM;
import cards.UV;
import players.Game;
import players.Player;

public class Main {
    public static void main(String[] args) {
        Game game=new Game(2);
        game.displayPile();
        game.distributeCards();
        System.out.println("\n hands\n");
        game.displayHands();

    }

}