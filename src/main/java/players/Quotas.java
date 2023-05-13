package players;

public class Quotas {
    private int CSCredits;
    private int TMCredits;
    private int ECCredits;
    private int T2SCredits;

    public Quotas(){
        this.CSCredits=0;
        this.TMCredits=0;
        this.ECCredits=0;
        this.T2SCredits=0;
    }
    public int getCSCredits() {
        return CSCredits;
    }
    public void setCSCredits(int CSCredits) {
        this.CSCredits = CSCredits;
    }
    public int getTMCredits() {
        return TMCredits;
    }
    public void setTMCredits(int TMCredits) {
        this.TMCredits = TMCredits;
    }
    public int getECCredits() {
        return ECCredits;
    }
    public void setECCredits(int ECCredits) {
        this.ECCredits = ECCredits;
    }
    public int getT2SCredits() {
        return T2SCredits;
    }
    public void setT2SCredits(int t2SCredits) {
        T2SCredits = t2SCredits;
    }
    public int getTotal(){
        return CSCredits+TMCredits+ECCredits+T2SCredits;
    }
    public String toString() {
        return "Quotas : \nCS : "+CSCredits+", TM : "+TMCredits+", EC : "+ECCredits+", T2S : "+T2SCredits+", Total :"+getTotal();
    }
}
