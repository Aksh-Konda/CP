import java.util.*;

public class Program5 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        boolean[][] grid = new boolean[r][c];

        List<Pair> zones = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scn.nextInt() == 1;
                if (grid[i][j])
                    zones.add(new Pair(i, j));
            }
        }

        int minTotalDist = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int totalDist = 0;
                for (Pair z : zones) {
                    totalDist += Math.abs(z.x - i) + Math.abs(z.y - j);
                }

                if (minTotalDist > totalDist) {
                    minTotalDist = totalDist;
                }
            }
        }

        System.out.println(minTotalDist);

        scn.close();
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}