import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(getSmallestLinearSumArray(nums, sum, n));

        scn.close();
    }

    static int getSmallestLinearSumArray(int[] nums, int sum, int n) {
        int prefix[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] += nums[i - 1] + prefix[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int temp = prefix[j + i] - prefix[j];
                if (temp >= sum)
                    return i;
            }
        }

        return -1;
    }
}
