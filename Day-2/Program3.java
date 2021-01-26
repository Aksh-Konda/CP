import java.util.*;

public class Program3 {
    static HashMap<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        System.out.println(getLongest("abbbabbcbbacdb"));

        scn.close();
    }

    static String longestPalindromicSubString(String s) {
        if (s == null || s.length() < 1)
            return "";
        int maxI = 0, maxJ = 0;
        char chars[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int len1 = getPalindromeLen(chars, i, i);
            int len2 = getPalindromeLen(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxJ - maxI) {
                maxI = i - (len - 1) / 2;
                maxJ = i + len / 2;
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    static int getPalindromeLen(char[] s, int i, int j) {
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    static String getLongest(String str) {
        char s[] = str.toCharArray();
        int start = 0;
        int end = 0;

        boolean dp[][] = new boolean[s.length][s.length];

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }

        for (int i = 1; i < s.length; i++) {
            for (int j = i, k = 0; j < s.length; j++, k++) {
                dp[k][j] = s[k] == s[j] && dp[k + 1][j - 1];
                if (dp[k][j] && (end - start) < (j - k)) {
                    start = k;
                    end = j;
                }
            }
        }

        return str.substring(start, end + 1);
    }
}
