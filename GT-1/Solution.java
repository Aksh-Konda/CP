import java.util.Scanner;

class Solution {

    public int chocolate(int[] grade) {
        int n = grade.length;
        int chocos[] = new int[n];

        for (int i = 0; i < n; i++) {
            chocos[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (grade[i] < grade[i + 1])
                chocos[i + 1] = chocos[i] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (grade[i] > grade[i + 1] && chocos[i] < chocos[i + 1] + 1)
                chocos[i] = chocos[i + 1] + 1;
        }

        int total = 0;
        for (int choc : chocos) {
            total += choc;
        }

        return total;
    }

    public boolean isMatch(String word, String pattern) {

        char wchars[] = word.toCharArray();
        char pchars[] = pattern.toCharArray();
        int m = wchars.length, n = pchars.length;
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 1; i <= n; i++)
            if (dp[i - 1] && pchars[i - 1] == '%')
                dp[i] = true;

        for (int i = 1; i <= m; i++) {

            boolean prev = dp[0];

            for (int j = 1; j <= n; j++) {
                boolean temp = dp[j];
                if (wchars[i - 1] == pchars[j - 1] || (pchars[j - 1] == '_'))
                    dp[j] = prev;
                else if (pchars[j - 1] == '%')
                    dp[j] = dp[j] || dp[j - 1];
                else
                    dp[j] = false;

                prev = temp;
            }

            dp[0] = false;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println(new Solution().isMatch("", "%%%%%%") + " : true");
        System.out.println(new Solution().isMatch("aa", "%") + " : true");
        System.out.println(new Solution().isMatch("cb", "_a") + " : false");
        System.out.println(new Solution().isMatch("adceb", "%a%b") + " : true");
        System.out.println(new Solution().isMatch("acdcb", "a%c_b") + " : false");
        scn.close();
    }
}

class test {
    boolean visited[][];

    public boolean isMatch(String word, String pattern) {
        char wordC[] = word.toCharArray();
        char patternC[] = pattern.toCharArray();

        visited = new boolean[wordC.length][patternC.length];

        return compare(wordC, patternC, 0, 0);
    }

    public boolean compare(char[] word, char[] pattern, int i, int j) {
        if (i == word.length && j == pattern.length)
            return true;

        if (word.length == i && pattern[j] == '%') {
            return compare(word, pattern, i, j + 1);
        }

        if (i < word.length && j < pattern.length) {
            if (visited[i][j])
                return false;
            visited[i][j] = true;
        }

        if (i < word.length && j < pattern.length && (pattern[j] == '_' || pattern[j] == word[i])) {
            return compare(word, pattern, i + 1, j + 1);
        }

        if (j < pattern.length && pattern[j] == '%') {
            return compare(word, pattern, i + 1, j) || compare(word, pattern, i + 1, j + 1)
                    || compare(word, pattern, i, j + 1);
        }

        return false;
    }
}