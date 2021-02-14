import java.util.*;

class Program2 {
    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String raw[] = scn.nextLine().split(" ");
        int costs[] = new int[raw.length];

        for (int i = 0; i < raw.length; i++) {
            costs[i] = Integer.parseInt(raw[i]);
        }

        System.out.println(maxProfit(costs, 0));

        scn.close();
    }

    static int maxProfit(int costs[], int i) {
        if (i >= costs.length)
            return 0;
        if (memo.containsKey(i))
            return memo.get(i);

        int maxProfit = Integer.MIN_VALUE;
        int min = costs[i];
        for (int j = i + 1; j < costs.length; j++) {
            int curr = costs[j] - min;
            maxProfit = Math.max(maxProfit, Math.max(curr + maxProfit(costs, j + 2), maxProfit(costs, j + 1)));
            min = Math.min(min, costs[j]);
        }

        memo.put(i, maxProfit < 0 ? 0 : maxProfit);

        return memo.get(i);
    }

}