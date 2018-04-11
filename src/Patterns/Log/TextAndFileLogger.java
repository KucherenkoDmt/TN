package Patterns.Log;

import java.io.FileWriter;
import java.io.IOException;

public class TextAndFileLogger extends AbstractLogger{
    @Override
    protected void toFile(String stringToLog){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Log", true);
            fileWriter.append(stringToLog+System.lineSeparator());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doLogging(String stringToLog){
        System.out.println(stringToLog);
    }

}
