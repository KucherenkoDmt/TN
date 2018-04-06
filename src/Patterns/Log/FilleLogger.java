package Patterns.Log;

import java.io.IOException;

public class FilleLogger extends AbstractLogger{
    @Override
    protected void toFile(String stringToLog) throws IOException {
        super.toFile(stringToLog);
    }
    @Override
    protected void doLogging(String stringToLog) { }
}


