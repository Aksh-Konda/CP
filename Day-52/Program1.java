import java.util.*;

public class Program1 {
    static int[][] distances;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        System.out.println(canFormFib(s));

        scn.close();
    }

    static boolean canFormFib(String s) {
        char[] d = s.toCharArray();
        int n = d.length;
        int prev1 = 0, prev2 = 0;
        if (n > 0 && d[0] == '0')
            return false;

        for (int i = 0; i < n / 2; i++) {
            prev1 = prev1 * 10 + (d[i] - '0');

            if (d[i + 1] == '0')
                continue;

            for (int j = i + 1; j < n - 1; j++) {
                prev2 = prev2 * 10 + (d[j] - '0');

                if (check(prev1, prev2, d, j + 1))
                    return true;
            }

            prev2 = 0;
        }

        return false;
    }

    static boolean check(int prev1, int prev2, char[] s, int i) {
        int n = s.length;
        if (n == i)
            return true;

        int j = startsWith(s, prev1 + prev2, i);

        if (j != -1)
            return check(prev2, prev1 + prev2, s, j);

        return false;
    }

    static int startsWith(char s[], int num, int i) {
        char comp[] = Integer.toString(num).toCharArray();

        int n = s.length;
        if (comp.length > (n - i)) {
            return -1;
        }

        for (int j = 0; j < comp.length; j++, i++) {
            if (i >= n)
                return -1;
            if (comp[j] != s[i])
                return -1;
        }

        return i;
    }
}