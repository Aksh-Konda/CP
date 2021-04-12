import java.util.*;

public class Program1 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

        // Arrays.stream(scn.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int amount = scn.nextInt();
        int prices[] = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        System.out.println(numWays(amount, prices, 0));

        scn.close();
    }

    static int numWays(int amount, int[] prices, int start) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;

        String key = amount + "," + start;

        if (memo.containsKey(key))
            return memo.get(key);

        int count = 0;

        for (int i = start; i < prices.length; i++) {
            count += numWays(amount - prices[i], prices, i);
        }

        memo.put(key, count);

        return count;
    }
}