import java.util.*;

public class Program1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int prices[] = new int[n];
        int combos[][] = new int[k][n + 1];

        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                combos[i][j] = scn.nextInt();
            }
        }

        int count[] = new int[n];

        for (int i = 0; i < n; i++) {
            count[i] = scn.nextInt();
        }

        System.out.println(getMinPrice(prices, combos, count, 0, 0));

        scn.close();
    }

    static int getMinPrice(int prices[], int combos[][], int count[], int cost, int d) {
        int n = prices.length;
        int k = combos.length;

        boolean noCombo = true;

        int minCost = Integer.MAX_VALUE;

        for (int i = d; i < k; i++) {
            boolean allZero = true;
            boolean possible = true;
            for (int j = 0; j < n; j++) {
                count[j] -= combos[i][j];
                if (count[j] < 0)
                    possible = false;
                if (count[j] != 0)
                    allZero = false;
            }

            int temp;

            if (allZero) {
                temp = combos[i][n];
            } else if (possible) {
                temp = getMinPrice(prices, combos, count, combos[i][n], i);
            } else {
                temp = Integer.MAX_VALUE;
            }

            if (temp < minCost) {
                noCombo = false;
                minCost = temp;
            }

            for (int j = 0; j < n; j++) {
                count[j] += combos[i][j];
            }
        }

        if (noCombo) {
            minCost = 0;
            for (int i = 0; i < n; i++) {
                minCost += count[i] * prices[i];
            }
        }

        return minCost + cost;
    }
}