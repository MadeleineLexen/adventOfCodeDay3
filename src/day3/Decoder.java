package day3; /**
 * Created by madeleine on 2016-12-13.
 */import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by madeleine on 2016-12-08.
 */
public class Decoder {

    public String[] readFile(String fileName) {
        String fileContent = "";
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                fileContent = fileContent + i + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileContent.split("\n");
    }
}