package cards;

public class Coordinates {
    private final int line;
    private final int column;
    public Coordinates(int l, int c){
        this.line=l;
        this.column=c;
    }
    public Coordinates(Coordinates coordinates){
        this.line= coordinates.getLine();
        this.column= coordinates.getColumn();
    }
    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}

