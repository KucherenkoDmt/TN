package Patterns.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger {
    private static int counter = 1;
    private SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss.SSS");

    public void log(String text) {
        Date date = new Date();
        String stringToLog = counter + ") " + sf.format(date) + " " + "[" + Thread.currentThread().getName() + "] " + text;
        doLogging(stringToLog);
        toFile(stringToLog);
        counter++;
    }

    protected void toFile(String stringToLog) {
    }

    protected abstract void doLogging(String stringToLog);
}
