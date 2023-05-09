package cards;

public class Coordinates {
    private int line;
    private int column;
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

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

