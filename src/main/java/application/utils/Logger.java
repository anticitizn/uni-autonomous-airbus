package application.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd ");
    private static FileWriter fileWriter;
    private static String filename;

    public static void setFilename(String filename) {
        Logger.filename = filename;
        try {
            Logger.fileWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing logger", e);
        }
    }

    public Logger() {
        try {
            fileWriter = new FileWriter("log.txt", true);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing logger", e);
        }
    }

    public static void log(String message) {
        try {
            String timestamp = dateFormat.format(new Date());
            String formattedMessage = String.format("[%s] %s", timestamp, message);
            fileWriter.write(formattedMessage + System.lineSeparator());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to log file", e);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing logger", e);
        }
    }

}
