package Players;

import Cards.UV;

public class Grid {
    UV[][] grid=new UV[3][4];

    public UV[][] getGrid() {
        return grid;
    }
    public void displayGrid(){
        for(int line=0;line<getGrid().length;line++){
            for(int column=0;column<getGrid()[line].length;column++){
                System.out.println(getGrid()[line][column]);

            }
        }

    }

    /**
     * @brief browse the grid and check if all the cards are visible
     * @return true if the whole grid is visible, false if not
     */
    public boolean isGridVisible(){
        int line=0;
        int column=0;
        // we use a while loop because it permits to stop broswing at the time we find an hiden card
        while(line<getGrid().length){
            column=0;
            while(column<getGrid()[line].length && getGrid()[line][column].isVisible() ){
                column++;
            }
            line++;
        }
        return getGrid()[line][column].isVisible();
    }
    public UV getCardWithPosition(int line, int column){
        return getGrid()[line][column];
    }

    /**
     * @brief exchange a card from the gird at a given position (line, column) with a card from a pile
     * "cardToDeck permits to store the card from the grid we want to throw
     * @param cardsFromPile
     * @param line
     * @param column
     * @return the UV which is going to deck
     */
    public UV swapCardsGrid(UV cardsFromPile, int line, int column){
        UV cardToDeck=getGrid()[line][column];
        getGrid()[line][column]=cardsFromPile;
        return cardToDeck;

    }
}
