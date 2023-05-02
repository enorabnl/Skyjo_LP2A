package cards;

import java.util.Random;

public class T2S extends UV{
    public T2S(){
        super(generateName(),generateCredits());
    }

    private static int generateCredits(){
        Random rand=new Random();
        return rand.nextInt(4)+1;
    }
    private static String generateName() {
        Random rand = new Random();
        return "HI" + String.format("%02d", rand.nextInt(30));
    }
}
