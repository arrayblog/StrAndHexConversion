import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            System.out.println(InternalCode.str2Hex(input,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
