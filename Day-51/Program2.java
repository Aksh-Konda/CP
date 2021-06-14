import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(getMaxSumSubset(n, nums, sum));

        scn.close();
    }

    static int getMaxSumSubset(int n, int[] nums, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (currSum == sum)
                max = i + 1;

            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
            if (map.containsKey(currSum - sum)) {
                max = Math.max(max, i - map.get(currSum - sum));
            }
        }

        return max;
    }
}