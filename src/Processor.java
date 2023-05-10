import java.util.concurrent.Exchanger;

public class Processor {
    private final Exchanger exchanger;
    private int countBirds = 0;
    public Processor(Exchanger exchanger)
    {
        this.exchanger = exchanger;
    }

    public int getCountBirds() {
        return countBirds;
    }

    public void StartProcessing()
    {
        while (true) {
            try {
                var image = exchanger.exchange("ack");
                countBirdsInImage((char[][]) image);
                System.out.println("Bird count: " + countBirds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void countBirdsInImage(char[][] image) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (image[i][j] == 'b') {
                    countBirds++;
                }
            }
        }
    }
}
