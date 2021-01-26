import java.util.*;

public class Program2 {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String raw[] = scn.nextLine().split(" ");

        int nums[] = new int[raw.length];

        for (int i = 0; i < raw.length; i++) {
            nums[i] = Integer.parseInt(raw[i]);
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(longestDecrSubSeq(nums, i), max);
        }

        System.out.println(max);

        scn.close();
    }

    static int longestDecrSubSeq(int nums[], int i) {
        if (i >= nums.length)
            return 0;
        if (memo.containsKey(i))
            return memo.get(i);

        int max = 0;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(longestDecrSubSeq(nums, j), max);
            }
        }

        memo.put(i, max + 1);
        return max + 1;
    }
}
