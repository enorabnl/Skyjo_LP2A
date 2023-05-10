package skyjo;

public class Play {
    public void startGame(){
        Game game=new Game();

        game.distributeCards();
        game.getDiscard().addCard(game.getDeck().drawACard());
        game.displayHands();
        int i =0;
        do{
            game.setCurrentPlayer(game.getListOfPlayers().get(i));
            game.getCurrentPlayer().displayHand();
            System.out.println(game.getDiscard().toString());
            game.chooseAction();
            game.getCurrentPlayer().setQuotas();
            System.out.println("New grid-------------------");
            game.getCurrentPlayer().displayHand();

            if(i== game.getListOfPlayers().size()-1){
                i=0;
            }else{
                i++;
            }
        }while(!game.isAGridVisible());
        game.displayEnd();
    }

}
