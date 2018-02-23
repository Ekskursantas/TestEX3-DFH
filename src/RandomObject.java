import java.util.Random;

public class RandomObject {

    public int Randomint;
    private Random r;

    public RandomObject(){
        r = new Random();
        Randomint = r.nextInt();
    }

    public void NewRandomValue(){
        Randomint = r.nextInt();
    }
}
