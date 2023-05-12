package cards;

public class Coordinates {
    private final int line;
    private final int column;

    /**
     * @param l is the line coordinate
     * @param c is the column coordinate
     */
    public Coordinates(int l, int c){
        this.line=l;
        this.column=c;
    }
    public int getLine() {
        return line;
    }
    public int getColumn() {
        return column;
    }

}

