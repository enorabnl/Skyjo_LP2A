package players;

import cards.UV;

public class Player {
    private Student data;
    private Grid grid;
    private Quotas quotas;

    public Player(String pseudo){
        this.data=new Student(pseudo);
        this.grid=new Grid();
        this.quotas=new Quotas();
    }

    //getters & setters
    public Grid getGrid() {
        return grid;
    }
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Student getData() {
        return data;
    }
    public void setData(Student data) {
        this.data = data;
    }

    public Quotas getQuotas() {
        return quotas;
    }
    public void setQuotas() {
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                UV card=getGrid().getGrid()[i][j];
                int credits= card.getCredits();
                if(card.getClass().getSimpleName().equals("CS")){
                    if(card.isVisible()){
                        getQuotas().setCSCredits(getQuotas().getCSCredits()+credits);
                    }
                } else if (card.getClass().getSimpleName().equals("TM")) {
                    if(card.isVisible()){
                        getQuotas().setTMCredits(getQuotas().getTMCredits()+credits);                    }
                } else if (card.getClass().getSimpleName().equals("EC")) {
                    if(card.isVisible()){
                        getQuotas().setECCredits(getQuotas().getECCredits()+credits);                    }
                }else{
                    if(card.isVisible()){
                        getQuotas().setT2SCredits(getQuotas().getT2SCredits()+credits);                    }                }
            }
        }
    }
    public String toString() {
        return data.toString()+"\n"+getQuotas().toString();
    }
    public void displayHand(){
        System.out.println("\nPlayer : "+toString());
        getGrid().displayGrid();
    }

}
