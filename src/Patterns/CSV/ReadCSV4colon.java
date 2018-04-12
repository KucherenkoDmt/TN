package Patterns.CSV;

import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadCSV4colon {
    public static void main(String[] args) throws InterruptedException, IOException {
        ReadCSV4colon readCSV4colon = new ReadCSV4colon();
        readCSV4colon.csvDataRead();
    }


    public static List<CsvCell> csvDataRead() throws IOException, InterruptedException {
        // String csv_path = "C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\TN\\InfoForTesting.csv";
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\dmitrii.kucherenko\\IdeaProjects\\TN\\InfoForTesting.csv"));
        String[] csvCell;
        List<CsvCell> list = new ArrayList<>();
        while ((csvCell = reader.readNext()) != null) {
            CsvCell csvCell1 = new CsvCell(csvCell[0], csvCell[1], csvCell[2], csvCell[3], csvCell[4]);
            list.add(csvCell1);
        }
      return list;
    }
}
