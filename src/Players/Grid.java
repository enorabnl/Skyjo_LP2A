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
}
