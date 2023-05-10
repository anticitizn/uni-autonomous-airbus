import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Airbus airbus = new Airbus();
        airbus.CountPassengers();
        Thread.sleep(2000);
        System.out.println(airbus.totalNumberOfPassengers);
    }
}