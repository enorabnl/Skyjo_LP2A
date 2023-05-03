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
        String[] lettres = {"M", "P", "R"};
        String lettre = lettres[rand.nextInt(3)];
        String name = lettre + String.valueOf((char)(rand.nextInt(26)+65)) + String.format("%02d", rand.nextInt(30));
        return name;
    }


}
