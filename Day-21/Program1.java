import java.util.*;

public class Program1 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(getMaxScore(nums));

        scn.close();
    }

    static int getMaxScore(int nums[]) {
        int count[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] += nums[i];
        }

        for (int i = 2; i <= 100; i++) {
            count[i] = Math.max(count[i - 1], count[i - 2] + count[i]);
        }

        return count[100];
    }
}