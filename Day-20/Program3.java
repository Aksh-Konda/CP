import java.util.*;

public class Program3 {
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int grid[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        findNearestSafeZones(grid, n, m);

        scn.close();
    }

    static void findNearestSafeZones(int[][] grid, int n, int m) {
        visited = new boolean[n][m];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    updateDist(grid, i, j, 0);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void updateDist(int[][] grid, int i, int j, int dist) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == -1 || visited[i][j])
            return;

        if (grid[i][j] == -2) {
            grid[i][j] = dist;
        } else {
            grid[i][j] = Math.min(grid[i][j], dist);
        }

        visited[i][j] = true;

        if (grid[i][j] == dist) {
            updateDist(grid, i - 1, j, dist + 1);
            updateDist(grid, i, j - 1, dist + 1);
            updateDist(grid, i + 1, j, dist + 1);
            updateDist(grid, i, j + 1, dist + 1);
        }

        visited[i][j] = false;
    }
}
