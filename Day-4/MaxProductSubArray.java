import java.util.*;

public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(maxProductContn(nums));

        scn.close();
    }

    static int maxProductContn(int nums[]) {

        if (nums == null || nums.length == 0)
            return 0;

        int[][] dp = new int[2][];
        dp[0] = new int[nums.length];
        dp[1] = new int[nums.length];

        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        int maxProduct = dp[0][0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i] * dp[0][i - 1])
                dp[0][i] = nums[i];
            else
                dp[0][i] = nums[i] * dp[0][i - 1];

            if (nums[i] < nums[i] * dp[1][i - 1])
                dp[1][i] = nums[i];
            else
                dp[1][i] = nums[i] * dp[1][i - 1];

            if (nums[i] * dp[1][i - 1] > dp[0][i])
                dp[0][i] = nums[i] * dp[1][i - 1];

            if (nums[i] * dp[0][i - 1] < dp[1][i])
                dp[1][i] = nums[i] * dp[0][i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (dp[0][i] > maxProduct)
                maxProduct = dp[0][i];
        }

        return maxProduct;
    }
}
