import java.util.*;

public class Program1 {

    public static void main(String[] args) {

        // Arrays.stream(scn.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int d = scn.nextInt();

        int cards[] = new int[n];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = scn.nextInt();
        }

        System.out.println(findLongestArithematicSet(cards, d, n));

        scn.close();
    }

    static int findLongestArithematicSet(int cards[], int diff, int n) {
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int max = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (cards[i] == cards[j] + diff) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}

class testt {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    static int findLongestArithematicSet(int cards[], int diff, int i) {
        if (i >= cards.length)
            return 0;
        if (memo.containsKey(i))
            return memo.get(i);

        int max = 1;

        for (int j = i + 1; j < cards.length; j++) {
            if (cards[i] + diff == cards[j]) {
                max = Math.max(findLongestArithematicSet(cards, diff, j) + 1, max);
            }
        }

        memo.put(i, max);

        return max;
    }
}