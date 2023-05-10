import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Radar {
    private final Random rand = new Random();
    private final Exchanger exchanger;
    private final char[][] picture = new char[100][100];
    private int countAcknowledged = 0;

    public Radar(Exchanger exchanger)
    {
        this.exchanger = exchanger;
        generateImage();
    }

    public int getCountAcknowledged() {
        return countAcknowledged;
    }

    public void StartScanning()
    {
        while (true) {
            try {
                generateImage();
                String result = (String) exchanger.exchange(picture);
                if (Objects.equals(result, "ack")) {
                    countAcknowledged++;
                    Logger.log("Received ack");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void generateImage()
    {
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                picture[i][j] = '.';
            }
        }

        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (rand.nextInt(100) < 10)
                {
                    picture[i][j] = 'c';
                }
            }
        }

        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (rand.nextInt(100) < 3)
                {
                    picture[i][j] = 'b';
                }
            }
        }

        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (rand.nextInt(100) < 3)
                {
                    picture[i][j] = 't';
                }
            }
        }
    }
}
