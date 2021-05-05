import java.util.*;

public class Program2 {
    static int m, n;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        m = scn.nextInt();
        n = scn.nextInt();

        int grid[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int[] result = new int[n];

        for (int k = 0; k < n; k++) {
            result[k] = getOutCell(grid, k);
        }

        System.out.println(Arrays.toString(result));

        scn.close();
    }

    static int getOutCell(int grid[][], int start) {
        int j = start;

        for (int i = 0; i < m; i++) {
            if (j + grid[i][j] < 0 || j + grid[i][j] >= n)
                return -1;
            if (grid[i][j] != grid[i][j + grid[i][j]])
                return -1;
            j += grid[i][j];
        }

        return j;
    }
}
