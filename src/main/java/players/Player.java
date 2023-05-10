package players;

import cards.UV;

public class Player {
    final private Student data;
    private Grid grid;
    private Quotas quotas;

    public Player(String pseudo){
        this.data=new Student(pseudo);
        this.grid=new Grid();
        this.quotas=new Quotas();
    }
    public Grid getGrid() {
        return grid;
    }
    public Student getData() {
        return data;
    }
    public Quotas getQuotas() {
        return quotas;
    }
    public void setQuotas() {
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                UV card=getGrid().getGrid()[i][j];
                int credits= card.getCredits();
                switch (card.getClass().getSimpleName()) {
                    case "CS" -> {
                        if (card.isVisible()) {
                            getQuotas().setCSCredits(getQuotas().getCSCredits() + credits);
                        }
                    }
                    case "TM" -> {
                        if (card.isVisible()) {
                            getQuotas().setTMCredits(getQuotas().getTMCredits() + credits);
                        }
                    }
                    case "EC" -> {
                        if (card.isVisible()) {
                            getQuotas().setECCredits(getQuotas().getECCredits() + credits);
                        }
                    }
                    case "T2S" -> {
                        if (card.isVisible()) {
                            getQuotas().setT2SCredits(getQuotas().getT2SCredits() + credits);
                        }
                    }
                    default -> {
                    }
                }
            }
        }
    }
    public String toString() {
        return data+"\n"+getQuotas().toString();
    }
    public void displayHand(){
        System.out.println("\nPlayer : "+ this);
        getGrid().displayGrid();
    }
}
