package application.humans;

import java.util.Random;

public class Passenger {
    private final Random rand = new Random();
    private final char[][] face = new char[10][10];

    public Passenger() {
        char[] chars = {'a', 'c', 'e', 'h', 'i', 'l', 'n', 'o', 'p', 's'};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                face[i][j] = chars[rand.nextInt(chars.length)];
            }
        }
    }

    public char[][] getFace() {
        return face;
    }
}
