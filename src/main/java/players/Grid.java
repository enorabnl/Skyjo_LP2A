package players;

import cards.Coordinates;
import cards.UV;

public class Grid {
    /**
     * The grid is an array of UV that will contain the cards of the player
     */
    UV[][] grid=new UV[3][4];
    public UV[][] getGrid() {
        return grid;
    }

    /**
     * @brief Browse the grid using two for loops, and make the cards visible
     */
    public void makeTheGridVisible(){
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                grid[i][j].makeVisible();
            }
        }
    }

    /**
     * @brief Browse the lines of the grid and displays their cards
     */
    public void displayGrid(){
        for(int line=0;line<3;line++){
            System.out.println("| "+grid[line][0].toString()+" | "+grid[line][1].toString()+" | "+grid[line][2].toString()+" | "+grid[line][3].toString()+"|");
        }
    }

    /**
     * @brief Browse the grid and check if all the cards are visible
     * @return true if the whole grid is visible, false if not
     */
    public boolean isGridVisible(){
        int line=0;
        int column;
        boolean visible;
        /*
        We use do while loop because it permits to stop browsing at the time we find a hidden card
         */
        do{
            column=0;
            do{
                visible=grid[line][column].isVisible();
                column++;
            }while(column<4 && visible);
            line++;
        }while(line<3 && visible);
        return visible;
    }

    /**
     * @brief Exchange a card from the gird at a given position (line, column) with a card from a pile,
     * cardToDeck permits to store the card from the grid we want to throw
     * @param cardsFromPile
     * @param position
     * @return the UV which is going to deck
     */
    public UV swapCardsGrid(UV cardsFromPile, Coordinates position){
        UV cardToDeck=grid[position.getLine()][position.getColumn()];
        grid[position.getLine()][position.getColumn()]=cardsFromPile;
        return cardToDeck;
    }
}
