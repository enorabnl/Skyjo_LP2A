package Cards;
import java.util.Random;

public class EC extends UV{
    public EC(){
        super(generateName(),generateCredits());
    }
    private static int generateCredits() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }
    private static String generateName() {
        Random rand = new Random();
        String[] letters = {"L", "X", "W"};
        String letter = letters[rand.nextInt(3)];
        return  letter + String.valueOf((char)(rand.nextInt(26)+65)) + String.format("%02d", rand.nextInt(10));
    }
}
