package players;

import cards.Coordinates;
import cards.UV;

public class Grid {
    UV[][] grid=new UV[3][4];
    public UV[][] getGrid() {
        return grid;
    }
    public void makeTheGridVisible(){
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                grid[i][j].makeVisible();
            }
        }
    }
    public void displayGrid(){
        for(int line=0;line<3;line++){
            System.out.println("| "+grid[line][0].toString()+" | "+grid[line][1].toString()+" | "+grid[line][2].toString()+" | "+grid[line][3].toString()+"|");
        }
    }

    /**
     * @brief browse the grid and check if all the cards are visible
     * @return true if the whole grid is visible, false if not
     */
    public boolean isGridVisible(){
        int line=0;
        int column;
        boolean visible;
        // we use a while loop because it permits to stop browsing at the time we find a hiden card
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
     * @brief exchange a card from the gird at a given position (line, column) with a card from a pile
     * "cardToDeck permits to store the card from the grid we want to throw
     * @param cardsFromPile
     * @param position
     * @return the UV which is going to deck
     */
    public UV swapCardsGrid(UV cardsFromPile, Coordinates position){
        UV cardToDeck=grid[position.getLine()-1][position.getColumn()-1];
        grid[position.getLine()-1][position.getColumn()-1]=cardsFromPile;
        return cardToDeck;
    }


}
