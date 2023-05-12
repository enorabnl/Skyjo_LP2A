package cards;
import java.util.Random;

public class CS extends UV{
    /**
     * Call the super type constructor
     * We use the generateName()method as String argument and 6 as integer argument
     */
    public CS(){
        super(generateName(),6);
    }

    /**
     * @brief Generate a name while respecting some conventions
     * @return the name which has been generated
     */
    private static String generateName() {
        Random rand = new Random();
        /*
        Choose randomly a letter in the letters array
        Choose randomly a letter in the alphabet
        Generate a random number between 0 and 29
        "%02d" specifies that the integer should be formatted with a minimum width of 2 characters
        and that if the integer has less than 2 digits, leading zeros should be added to make it two digits long
         */
        String[] letters = {"M", "P", "R"};
        String letter = letters[rand.nextInt(3)];
        return letter + (char) (rand.nextInt(26) + 65) + String.format("%02d", rand.nextInt(30));
    }
}
