import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        System.out.println(getCountRemovable(nums, n));

        scn.close();
    }

    static int getCountRemovable(int[] nums, int n) {
        int right[] = new int[2];
        int left[] = new int[2];

        for (int i = 0; i < n; i++) {
            right[i % 2] += nums[i];
        }

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            right[i % 2] -= nums[i];
            if ((left[0] + right[1]) == (left[1] + right[0]))
                count++;
            left[i % 2] -= nums[i];
        }

        return count;
    }
}