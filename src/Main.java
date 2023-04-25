import Cards.CardsPile;
import Cards.CS;
import Cards.UV;
import Players.Player;

public class Main {
    public static void main(String[] args) {
        CardsPile pile=new CardsPile(24);
        pile.mixPile();

        Player player1=new Player(3847355,"enobnl");
        Player player2=new Player(3847377,"carstar");
        pile.distribute(player1,player2);
        System.out.println("\n");
        player1.getGrid().displayGrid();
        System.out.println("\n");
        player2.getGrid().displayGrid();
    }

}