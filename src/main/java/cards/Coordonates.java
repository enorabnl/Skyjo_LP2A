package cards;

public class Coordonates {
    private int line;
    private int column;
    public Coordonates(int l, int c){
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

