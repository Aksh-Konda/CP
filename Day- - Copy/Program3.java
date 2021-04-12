import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        System.out.println(getMaxDistTrapFromPerson(grid));

        scn.close();
    }

    public static int getMaxDistTrapFromPerson(int[][] grid) {
        int max = 0;

        ArrayList<Position> traps = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    traps.add(new Position(i, j));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Integer.MAX_VALUE;
                if (grid[i][j] == 0) {
                    for (Position trap : traps) {
                        int dist = Math.abs(trap.x - i) + Math.abs(trap.y - j);
                        min = dist < min ? dist : min;
                    }
                    max = min > max ? min : max;
                }
            }
        }

        return max;
    }
}

/**
 * 3 1 0 0 0 0 0 1 0 0
 */

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}