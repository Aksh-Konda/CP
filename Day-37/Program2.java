import java.util.HashMap;
import java.util.Scanner;

public class Program2 {

    static int[][] memo;
    static int LIMIT = 1000000007;

    static int[][] possibilities = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 },
            { 1, 3 }, { 2, 4 } };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int count = 0;

        memo = new int[n][10];

        for (int i = 0; i < 10; i++) {
            count = (count + getNumCombinations(n - 1, i)) % LIMIT;
        }

        System.out.println(count);

        scn.close();
    }

    public static int getNumCombinations(int n, int prev) {
        if (n == 0)
            return 1;

        if (memo[n][prev] != 0)
            return memo[n][prev];

        int count = 0;

        for (int num : possibilities[prev]) {
            count = (count + getNumCombinations(n - 1, num)) % LIMIT;
        }

        memo[n][prev] = count;

        return count;
    }
}

/// {04,06,16,18,27,29,34,38,40,43,49,60,61,67,72,76,81,83,92,94}