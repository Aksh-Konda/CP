import java.util.Scanner;

public class Program3 {
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

        System.out.println(getLargestSquareArea(m, n, grid));

        scn.close();
    }

    static int getLargestSquareArea(int m, int n, int grid[][]) {
        int max = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] += Math.min(grid[i - 1][j - 1], Math.min(grid[i - 1][j], grid[i][j - 1]));
                    max = Math.max(grid[i][j], max);
                }
            }
        }

        return max * max;
    }
}