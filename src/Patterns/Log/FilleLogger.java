package Patterns.Log;

import java.io.IOException;

public class FilleLogger extends AbstractLogger{
    @Override
    protected void toFile(String stringToLog)  {
        super.toFile(stringToLog);
    }
    @Override
    protected void doLogging(String stringToLog) { }
}


