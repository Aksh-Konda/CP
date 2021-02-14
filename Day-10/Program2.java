import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int goldBags[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                goldBags[i][j] = scn.nextInt();
            }
        }

        System.out.println(getCommonGoldWeight(goldBags));

        scn.close();
    }

    static int getCommonGoldWeight(int[][] goldBags) {
        if (goldBags.length == 0)
            return -1;
        if (goldBags.length == 1)
            return goldBags[0][0];

        for (int i = 0, j; i < goldBags[0].length; i++) {
            for (j = 1; j < goldBags.length; j++) {
                if (Arrays.binarySearch(goldBags[j], goldBags[0][i]) < 0)
                    break;
            }
            if (j == goldBags.length)
                return goldBags[0][i];
        }

        return -1;
    }

    static int getAtleast(int[] nums, int k) {
        int i = Arrays.binarySearch(nums, k);

        if (i >= 0) {
            return nums[i];
        } else {
            i = -1 - i;
            return nums[i];
        }
    }
}
