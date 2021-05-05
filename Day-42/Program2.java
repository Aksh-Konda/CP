import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scn.nextLine());

        System.out.println(doesCurrentPlayerWin(input));

        scn.close();
    }

    static boolean doesCurrentPlayerWin(StringBuilder input) {
        int i = input.indexOf("AA");
        while (i != -1) {
            input.replace(i, i + 2, "BB");
            if (!doesCurrentPlayerWin(input)) {
                input.replace(i, i + 2, "AA");
                return true;
            }

            input.replace(i, i + 2, "AA");
            i = input.indexOf("AA", i + 1);
        }

        return false;
    }
}
