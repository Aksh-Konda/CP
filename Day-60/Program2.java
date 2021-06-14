import java.util.*;

// abbabbabbabbabbabbabbabbabbabb
// vignesh

public class Program2 {
    static int m = 31;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        char[] s = scn.nextLine().toCharArray();
        System.out.println(getMaxSubLen(s));
        scn.close();
    }

    static int getMaxSubLen(char[] s) {
        int left = 1;
        int right = s.length;
        int len = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (hasDuplicatesOfLen(s, mid)) {
                len = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return len;
    }

    static boolean hasDuplicatesOfLen(char[] s, int len) {
        Set<Long> set = new HashSet<>();
        long h = 0;
        long mul = 1;
        for (int i = len - 1; i >= 0; i--) {
            h += s[i] * mul;
            mul *= m;
        }
        set.add(h);
        long pow = 1;
        for (int l = 1; l < len; l++)
            pow *= m;

        for (int i = 1; i <= s.length - len; i++) {
            h = (h - s[i - 1] * pow) * m + s[i + len - 1];
            if (set.contains(h)) {
                return true;
            }
            set.add(h);
        }

        return false;
    }
}