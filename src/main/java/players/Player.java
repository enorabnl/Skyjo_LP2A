package players;

import cards.UV;

public class Player {
    private final Student data;
    private final Grid grid;
    private final Quotas quotas;

    /**
     * Creates a new player with the specified pseudo, initializes their student data, grid, and quotas.
     * @param pseudo the player's pseudo
     */
    public Player(String pseudo){
        this.data=new Student(pseudo);
        this.grid=new Grid();
        this.quotas=new Quotas();
    }

    /**
     * Returns the player's grid.
     * @return the player's grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Returns the player's student data.
     * @return the player's student data
     */
    public Student getData() {
        return data;
    }

    /**
     * Returns the player's quotas.
     * @return the player's quotas
     */
    public Quotas getQuotas() {
        return quotas;
    }

    /**
     * Calculates the player's quotas based on the credits of the UVs in their grid.
     */
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

    /**
     * Returns a string representation of the player's data and quotas.
     * @return a string representation of the player's data and quotas
     */
    public String toString() {
        return data+quotas.toString();
    }

    /**
     * Displays the player's grid and data.
     */
    public void displayHand(){
        System.out.println("\nPlayer : "+ this);
        grid.displayGrid();
    }
}
