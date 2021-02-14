import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String raw[] = scn.nextLine().split(" ");
        int nums[] = new int[raw.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(raw[i]);
        }

        System.out.println(maxSumSubArrayExcludeOne(nums));

        scn.close();
    }

    static int maxSumSubArrayExcludeOne(int nums[]) {
        int n = nums.length;
        int fMax[] = new int[n];
        int bMax[] = new int[n];
        int max, curr;

        max = curr = fMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
            fMax[i] = curr;
        }

        max = curr = bMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
            bMax[i] = curr;
        }

        int result = max;
        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, fMax[i - 1] + bMax[i + 1]);
        }

        return result;
    }
}
