import java.util.*;

public class Program1 {
    static Position[] dirc = { new Position(1, 0), new Position(0, 1), new Position(-1, 0), new Position(0, -1) };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        Position curr = new Position(scn.nextInt(), scn.nextInt());
        Position safe = new Position(scn.nextInt(), scn.nextInt());

        System.out.println(minDistance(grid, curr, safe, new HashSet<>()));

        scn.close();
    }

    static int minDistance(int[][] grid, Position curr, Position safe, HashSet<Position> visited) {
        if (curr.equals(safe))
            return 0;

        int minDist = Integer.MAX_VALUE;

        visited.add(curr);

        for (Position inc : dirc) {
            Position ng = getNeighbour(grid, curr, inc);
            if (!visited.contains(ng)) {
                int temp = minDistance(grid, ng, safe, visited);

                if (temp >= 0) {
                    temp += Math.abs(ng.i - curr.i) + Math.abs(ng.j - curr.j);
                    minDist = Math.min(minDist, temp);
                }
            }
        }

        visited.remove(curr);

        return minDist != Integer.MAX_VALUE ? minDist : -1;
    }

    static Position getNeighbour(int[][] grid, Position curr, Position inc) {
        int i = curr.i;
        int j = curr.j;

        int n = grid.length;

        int ni = i + inc.i;
        int nj = j + inc.j;

        while (inLimits(ni, nj, n) && grid[ni][nj] != 1) {
            i = ni;
            j = nj;
            ni += inc.i;
            nj += inc.j;
        }

        return new Position(i, j);
    }

    static boolean inLimits(int i, int j, int n) {
        return i < n && j < n && i >= 0 && j >= 0;
    }
}

class Position {
    int i;
    int j;

    Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        Position p = (Position) obj;
        return i == p.i && j == p.j;
    }

    @Override
    public int hashCode() {
        return i * 100000000 + j;
    }
}