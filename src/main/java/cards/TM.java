package cards;
import java.util.Random;

public class TM extends UV{
    public TM(){
        super(generateName(),generateCredits());
    }

    private static int generateCredits(){
        Random rand=new Random();
        if(rand.nextInt(2)==0){
            return 6;
        }else{
            return 4;
        }
    }
    private static String generateName() {
        Random rand = new Random();
        String[] lettres = {"D", "T", "A"};
        String lettre = lettres[rand.nextInt(3)];
        String name = lettre + String.valueOf((char)(rand.nextInt(26)+65)) + String.format("%02d", rand.nextInt(30));
        return name;
    }

}
