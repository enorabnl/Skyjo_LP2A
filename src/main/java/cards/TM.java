package cards;
import java.util.Random;

public class TM extends UV{
    /**
     * Call the super type constructor
     * We use the generateName()method as String argument and the generateCredits() one as integer argument
     */
    public TM(){
        super(generateName(),generateCredits());
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
        String[] letters = {"D", "T", "A"};
        String letter = letters[rand.nextInt(3)];
        return letter + (char) (rand.nextInt(26) + 65) + String.format("%02d", rand.nextInt(30));
    }
    /**
     * @brief Generate a number of credits
     * generate an integer randomly between 0 and 1
     * if it is 0 : the number of credits is equals to 6
     * if it is 1 : the number of credits is equals to 4
     * @return a number of credits
     */
    private static int generateCredits(){
        Random rand=new Random();
        if(rand.nextInt(2)==0){
            return 6;
        }else{
            return 4;
        }
    }

}
