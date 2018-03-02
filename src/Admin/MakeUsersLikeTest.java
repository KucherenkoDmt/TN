package Admin;

import Patterns.Reader;
import java.io.IOException;
import java.util.List;

public class MakeUsersLikeTest {
    public static void main(String[] args) throws IOException {
       List l = Reader.reader("FileForRead.txt");
        for (int i = 0; i <l.size() ; i++) {
            System.out.println(l.get(i));
        }
    }

}
