package players;

import cards.UV;

public class Player {
    private final Student data;
    private final Grid grid;
    private final Quotas quotas;

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
                UV card=grid.getGrid()[i][j];
                int credits= card.getCredits();
                switch (card.getClass().getSimpleName()) {
                    case "CS" -> {
                        if (card.isVisible()) {
                            quotas.setCSCredits(quotas.getCSCredits() + credits);
                        }
                    }
                    case "TM" -> {
                        if (card.isVisible()) {
                            quotas.setTMCredits(quotas.getTMCredits() + credits);
                        }
                    }
                    case "EC" -> {
                        if (card.isVisible()) {
                            quotas.setECCredits(quotas.getECCredits() + credits);
                        }
                    }
                    case "T2S" -> {
                        if (card.isVisible()) {
                            quotas.setT2SCredits(quotas.getT2SCredits() + credits);
                        }
                    }
                    default -> {
                    }
                }
            }
        }
    }
    public String toString() {
        return data+quotas.toString();
    }
    public void displayHand(){
        System.out.println("\nPlayer : "+ this);
        grid.displayGrid();
    }
}
