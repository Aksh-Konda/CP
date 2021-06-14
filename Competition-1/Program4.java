import java.util.*;

public class Program4 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] trees = new int[n][n];

        for (int i = 0; i < n; i++) {
            trees[i][0] = scn.nextInt();
            trees[i][1] = scn.nextInt();
        }

        System.out.println(getMaxTreesOnALine(trees, n));

        scn.close();
    }

    public static int getMaxTreesOnALine(int[][] trees, int n) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            int currMax = 0;
            HashMap<Float, Integer> treesOnSameLine = new HashMap<>();
            float slope;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    slope = ((float) trees[j][1] - trees[i][1]) / (trees[j][0] - trees[i][0]);
                    int temp = treesOnSameLine.getOrDefault(slope, 0) + 1;
                    treesOnSameLine.put(slope, temp);
                    currMax = Math.max(currMax, temp);
                }
            }

            max = Math.max(max, currMax + 1);
        }

        return max;
    }
}