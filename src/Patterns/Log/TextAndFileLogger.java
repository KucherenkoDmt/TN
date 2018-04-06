package Patterns.Log;

import java.io.IOException;

public class TextAndFileLogger extends AbstractLogger{
    protected void toFile(String stringToLog) throws IOException {
        super.toFile(stringToLog);
    }
    @Override
    public void doLogging(String stringToLog){
        System.out.println(stringToLog);
    }

}
