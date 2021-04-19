import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();

        System.out.println(getLargestSubString(input));

        scn.close();
    }

    static String getLargestSubString(String input) {
        char chars[] = input.toCharArray();

        int max = 0;
        String result = " ";

        for (int i = 0; i < chars.length; i++) {
            if (chars[max] < chars[i]) {
                result = input.substring(i);
                max = i;
            } else if (chars[max] == chars[i]) {
                String temp = input.substring(i);
                result = temp.compareTo(result) > 0 ? temp : result;
            }
        }

        return result;
    }
}
