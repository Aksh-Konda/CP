import java.util.*;

public class Program3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        int row[] = new int[n];

        for (int i = 0; i < n; i++)
            row[i] = scn.nextInt();

        System.out.println(longestContineousOnes(row, r));

        scn.close();
    }

    static int longestContineousOnes(int[] row, int r) {
        int max = 0;

        int i = 0, j = 0;
        while (j < row.length) {
            if (row[j] == 0) {
                r--;
            }

            if (r < 0) {
                while (i < row.length && row[i] != 0)
                    i++;

                if (i < row.length && row[i] == 0) {
                    i++;
                    r++;
                } else
                    break;
            }

            max = Math.max(j - i + 1, max);
            j++;
        }

        return max;
    }
}
