import java.util.*;

public class Program2 {
    static int[][] memo;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int gates[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            gates[i] = scn.nextInt();
        }

        memo = new int[n + 1][4];

        System.out.println(getMinJumps(gates, 2, 0));

        scn.close();
    }

    static int getMinJumps(int[] gates, int currLane, int step) {
        if (step == gates.length - 1)
            return 0;

        if (memo[step][currLane] != 0)
            return memo[step][currLane];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (gates[step + 1] != i && gates[step] != i) {
                if (i == currLane) {
                    min = Math.min(min, getMinJumps(gates, currLane, step + 1));
                } else {
                    min = Math.min(min, getMinJumps(gates, currLane, step + 1) + 1);
                }
            }
        }
        memo[step][currLane] = min;
        return min;
    }
}