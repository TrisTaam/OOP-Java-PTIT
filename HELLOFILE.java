import java.io.File;
import java.util.Scanner;

public class HELLOFILE {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("Hello.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {

        }
    }
}