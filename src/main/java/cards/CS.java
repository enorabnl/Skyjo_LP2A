package cards;
import java.util.Random;

public class CS extends UV{
    public CS(){
        super(generateName(),6);
    }

    /**
     * Generate a name while respecting some conventions
     * @return the name which has been generated
     */
    private static String generateName() {
        Random rand = new Random();
        String[] letters = {"M", "P", "R"};
        String letter = letters[rand.nextInt(3)];
        return letter + (char) (rand.nextInt(26) + 65) + String.format("%02d", rand.nextInt(30));
    }
}
