import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        System.out.println(getMaxConseqGold(grid, m, n));

        scn.close();
    }

    static int getMaxConseqGold(int[][] grid, int m, int n) {
        int max = 0;

        Cell cells[][] = new Cell[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cells[i][j] = new Cell(1);
                    if (isInLimit(m, n, i - 1, j)) {
                        cells[i][j].t += cells[i - 1][j].t;
                    }
                    if (isInLimit(m, n, i, j - 1)) {
                        cells[i][j].l += cells[i][j - 1].l;
                    }
                    if (isInLimit(m, n, i - 1, j - 1)) {
                        cells[i][j].dl += cells[i - 1][j - 1].dl;
                    }
                    if (isInLimit(m, n, i - 1, j + 1)) {
                        cells[i][j].dr += cells[i - 1][j + 1].dr;
                    }

                    max = Math.max(max, cells[i][j].max());
                } else {
                    cells[i][j] = new Cell(0);
                }
            }
        }

        return max;
    }

    static boolean isInLimit(int m, int n, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    static class Cell {
        int t;
        int l;
        int dl;
        int dr;

        Cell(int n) {
            t = l = dl = dr = n;
        }

        private int multiMax(Integer... nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = max > num ? max : num;
            }

            return max;
        }

        int max() {
            return multiMax(t, dl, dr, l);
        }
    }
}