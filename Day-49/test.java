import java.util.*;

public class test {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = "abcd";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.substring(i, i));
            System.out.println(str.substring(i, i + 1));
        }
        scn.close();
    }
}