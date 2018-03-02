package Patterns;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

;

public class Reader {

    public static void main(String[] args) throws IOException {
    }

    public static List<String> reader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);

        }
        return lines;
    }

    public String reader3(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        String text = "";
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
            text += scan.nextLine();
        }
        fr.close();
        return text;
    }


    public String reader2(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            return ex.getMessage();
        }
        return "";
    }

}

