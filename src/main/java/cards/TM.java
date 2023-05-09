package cards;
import java.util.Random;

public class TM extends UV{
    public TM(){
        super(generateName(),generateCredits());
    }
    private static String generateName() {
        Random rand = new Random();
        String[] letters = {"D", "T", "A"};
        String letter = letters[rand.nextInt(3)];
        return letter + (char) (rand.nextInt(26) + 65) + String.format("%02d", rand.nextInt(30));
    }
    private static int generateCredits(){
        Random rand=new Random();
        if(rand.nextInt(2)==0){
            return 6;
        }else{
            return 4;
        }
    }

}
