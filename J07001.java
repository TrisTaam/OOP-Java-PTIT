import java.io.File;
import java.util.Scanner;

public class J07001 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {

        }
    }
}
