package Patterns.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger implements Logger{
    private int counter = 1;
    private SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
        public  String log(String text) throws IOException {

        Date date = new Date();
        Thread.currentThread().getName();
        String stringToLog = counter + ") " + sf.format(date) + " " + "[" + Thread.currentThread().getName() + "] " + text;
        doLogging(stringToLog);
        counter++;
        return stringToLog;
    }

    protected void toFile(String stringToLog) throws IOException {
        String log = log(stringToLog);
        FileWriter fileWriter = new FileWriter("Log", true);
        fileWriter.append(log+System.lineSeparator());
        fileWriter.close();
    }

    protected abstract void doLogging(String stringToLog) throws IOException;
}
