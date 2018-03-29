package Patterns.CSV;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWrite {
    public static void main(String[] args) throws IOException {
        String CSV_PATH="Z:\\1Detail.csv";
        FileWriter writer = new FileWriter(CSV_PATH);

        writer.append("ID");
        writer.append(',');
        writer.append("name");
        writer.append(',');
        writer.append('\n');
        writer.append("ID");
        writer.append(',');
        writer.append("name");
        writer.append(',');
        writer.append("ID");
        writer.append(',');
        writer.append("name");
        writer.append(',');

        writer.flush();
        writer.close();
    }
}
