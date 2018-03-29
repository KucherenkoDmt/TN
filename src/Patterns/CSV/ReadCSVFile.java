package Patterns.CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {
    public static void main(String[] args) throws FileNotFoundException {
        String csvFile = "make_user.csv";
        File file = new File(csvFile);
         try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();
        }catch(FileNotFoundException e){
            //TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}
