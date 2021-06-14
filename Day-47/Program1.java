import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int heights[] = new int[n];
        // for (int i = 0; i < n; i++) {
        // heights[i] = scn.nextInt();
        // }
        // System.out.println(minRemovableBuildings(heights));

        System.out.println((long) (1000000007 * 1000000007));

        scn.close();
    }

    static int minRemovableBuildings(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n - 1;

        while (l < r && heights[l + 1] >= heights[l])
            l++;

        while (r > l && heights[r - 1] <= heights[r])
            r--;

        int min = Math.min(n - 1 - l, r);

        if (min == 0)
            return 0;

        for (int i = 0; i <= l; i++) {
            if (heights[i] <= heights[r]) {
                min = Math.min(min, r - i - 1);
            } else if (r < n - 1) {
                r++;
            } else {
                break;
            }
        }

        return min;
    }
}