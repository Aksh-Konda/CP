import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        char p[] = scn.nextLine().toCharArray();
        System.out.println(Arrays.toString(getList(p)));

        scn.close();
    }

    static int[] getList(char[] p) {
        int n = p.length + 1;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int j = i;
            while (j < n - 1 && p[j] == 'D') {
                j++;
            }

            if (i != j) {
                reverse(result, i, j);
                i = j - 1;
            }
        }

        return result;
    }

    static void reverse(int[] nums, int i, int j) {
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}