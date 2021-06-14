import java.util.*;

public class Program2 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        char[] s = scn.next().toCharArray();
        char[] t = scn.next().toCharArray();

        System.out.println(getMinChanges(s, t, s.length - 1, t.length - 1));

        scn.close();
    }

    static int getMinChanges(char[] s, char[] t) {
        int n = s.length;
        int m = s.length;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }

        return dp[n][m];
    }

    static int getMinChanges(char[] s, char[] t, int i, int j) {
        if (i < 0 && j < 0)
            return 0;
        if (i < 0 && j >= 0)
            return j + 1;
        if (i >= 0 && j < 0)
            return i + 1;

        String key = i + ":" + j;

        if (!memo.containsKey(key)) {
            int min = -1;
            if (s[i] == t[j])
                min = getMinChanges(s, t, i - 1, j - 1);
            else {
                int add = getMinChanges(s, t, i, j - 1) + 1;
                int rem = getMinChanges(s, t, i - 1, j) + 1;
                int sub = getMinChanges(s, t, i - 1, j - 1) + 1;

                min = Math.min(add, Math.min(rem, sub));
            }

            memo.put(key, min);
        }

        return memo.get(key);
    }
}