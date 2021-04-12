import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(unsortedSubsetLen(nums));
        scn.close();
    }

    static int unsortedSubsetLen(int[] nums) {
        int minArr[] = new int[nums.length];
        int maxArr[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (minArr[i] != maxArr[i]) {
                if (start == -1)
                    start = i;
                end = i;
            }
        }
        if (start == -1)
            return 0;
        return end - start + 1;
    }
}