package Companies.Else;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(2));
        ThreadLocalRandom random1 = ThreadLocalRandom.current();
        System.out.println(random1.nextInt(0,2));
    }
}
