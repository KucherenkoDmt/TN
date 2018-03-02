package Patterns.Log;

import java.io.IOException;

public class TextAndFileLogger extends AbstractLogger{
    @Override
    public void doLogging(String stringToLog) throws IOException {
        System.out.println(stringToLog);
        toFile(stringToLog);
    }
}
