package cards;

import java.util.Random;

public class T2S extends UV{
    /**
     * Call the super type constructor
     * We use the generateName()method as String argument and the generateCredits() one as integer argument
     */
    public T2S(){
        super(generateName(),generateCredits());
    }

    /**
     * @brief Generate a name while respecting some conventions
     * @return the name which has been generated
     */
    private static String generateName() {
        Random rand = new Random();
         /*
        The two first letters are systematically "HI"
        Generate a random number between 0 and 29
        "%02d" specifies that the integer should be formatted with a minimum width of 2 characters
        and that if the integer has less than 2 digits, leading zeros should be added to make it two digits long
         */
        return "HI" + String.format("%02d", rand.nextInt(30));
    }
    /**
     * @brief Generate an integer randomly between 1 and 4
     * @return a number of credits
     */
    private static int generateCredits(){
        Random rand=new Random();
        return rand.nextInt(4)+1;
    }
}
