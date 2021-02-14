import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();
        int n = scn.nextInt();

        int grid[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        while (collapse(grid, m, n))
            ;

        printGrid(grid);

        scn.close();
    }

    static boolean collapse(int[][] grid, int m, int n) {
        int count[][][] = new int[m][n][2];
        int v = 0, h = 1;
        boolean collapsed = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && grid[i][j] == grid[i - 1][j] && grid[i][j] != 0)
                    count[i][j][v] = count[i - 1][j][v];
                if (j != 0 && grid[i][j] == grid[i][j - 1] && grid[i][j] != 0)
                    count[i][j][h] = count[i][j - 1][h];
                count[i][j][h] += 1;
                count[i][j][v] += 1;
                if (count[i][j][h] >= 3 || count[i][j][v] >= 3)
                    collapsed = true;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (count[i][j][h] >= 3) {
                    for (int k = 0; k < count[i][j][h]; k++) {
                        grid[i][j - k] = 0;
                    }
                    j = j - count[i][j][h];
                }
            }
        }

        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                if (count[i][j][v] >= 3) {
                    for (int k = 0; k < count[i][j][v]; k++) {
                        grid[i - k][j] = 0;
                    }
                    i = i - count[i][j][v];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    for (int k = i; k > 0 && grid[k - 1][j] != 0; k--) {
                        grid[k][j] = grid[k - 1][j];
                        grid[k - 1][j] = 0;
                    }
                }
            }
        }

        return collapsed;
    }

    static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}