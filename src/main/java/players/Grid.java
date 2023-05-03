package players;

import cards.UV;

public class Grid {
    UV[][] grid=new UV[3][4];


    public UV[][] getGrid() {
        return grid;
    }
    public void makeACardVisible(int line, int column){
        grid[line][column].makeVisible();
    }
    public void displayGrid(){
        for(int line=0;line<3;line++){
            for(int column=0;column<4;column++){
                System.out.println(getGrid()[line][column].toString());
            }
        }

    }

    /**
     * @brief browse the grid and check if all the cards are visible
     * @return true if the whole grid is visible, false if not
     */
    public boolean isGridVisible(){
        int line=0;
        int column;
        // we use a while loop because it permits to stop broswing at the time we find a hiden card

        do{
            column=0;
            while(column<4 && getGrid()[line][column].isVisible()){
                column++;
            }
            line++;
        }while(line<3 && getGrid()[line-1][column].isVisible());
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
