import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int i = scn.nextInt();

        StringBuilder result = new StringBuilder();

        out: for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                int n = Character.getNumericValue(ch);
                if (n == 0) {
                    result = new StringBuilder();
                } else {
                    String temp = result.toString();
                    while (n > 1) {
                        result.append(temp);
                        if (result.length() >= i) {
                            System.out.println(result.charAt(i - 1));
                            break out;
                        }
                        n--;
                    }
                }
            } else {
                result.append(ch);
            }

            if (result.length() >= i) {
                System.out.println(result.charAt(i - 1));
                break out;
            }
            System.gc();
        }

        scn.close();
    }
}