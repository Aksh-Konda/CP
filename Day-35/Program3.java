import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s1 = scn.next();
        String s2 = scn.next();

        System.out.println(canFormSubSeq(s1.toCharArray(), s2.toCharArray()));

        scn.close();
    }

    static int canFormSubSeq(char[] s1, char[] s2) {
        if (!hasChars(s1, s2))
            return -1;

        int i = 0, j = 0, count = 1;
        while (j < s2.length) {
            if (i == s1.length) {
                i = 0;
                count++;
            }
            if (s1[i] == s2[j]) {
                j++;
            }
            i++;
        }

        return count;
    }

    static boolean hasChars(char[] s1, char[] s2) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : s1) {
            set.add(ch);
        }
        for (char ch : s2) {
            if (!set.contains(ch))
                return false;
        }
        return true;
    }
}
