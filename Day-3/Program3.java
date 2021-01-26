import java.util.HashMap;
import java.util.Scanner;

public class Program3 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String word1 = scn.next();
        String word2 = scn.next();

        System.out.println(lcs(word1.toCharArray(), word2.toCharArray(), 0, 0));

        scn.close();
    }

    public static int lcs(char word1[], char word2[], int i, int j) {
        if (i >= word1.length || j >= word2.length)
            return 0;
        String key = i + ":" + j;
        if (memo.containsKey(key))
            return memo.get(key);

        if (word1[i] == word2[j]) {
            memo.put(key, lcs(word1, word2, i + 1, j + 1) + 1);
        } else {
            memo.put(key, Math.max(lcs(word1, word2, i + 1, j), lcs(word1, word2, i, j + 1)));
        }

        return memo.get(key);
    }

    static int lcsTab(char word1[], char word2[]) {
        int n = word1.length;
        int m = word2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1[i] == word2[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
