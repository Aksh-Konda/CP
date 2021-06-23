import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        int pairs[][] = new int[p][2];

        for (int i = 0; i < p; i++) {
            pairs[i][0] = scn.nextInt();
            pairs[i][1] = scn.nextInt();
        }

        System.out.println(canDivide(n, pairs));

        scn.close();
    }

    static boolean canDivide(int n, int[][] pairs) {
        boolean[][] graph = new boolean[n][n];
        for (int[] d : pairs) {
            graph[d[0] - 1][d[1] - 1] = true;
            graph[d[1] - 1][d[0] - 1] = true;
        }
        int[] colour = new int[n];
        for (int i = 0; i < n; i++) {
            if (colour[i] == 0 && !dfs(i, 1, colour, graph))
                return false;
        }
        return true;
    }

    static boolean dfs(int index, int c, int[] colour, boolean[][] graph) {
        if (colour[index] != 0)
            return colour[index] == c;
        colour[index] = c;
        for (int i = 0; i < colour.length; i++) {
            if (graph[index][i] && !dfs(i, -c, colour, graph))
                return false;
        }
        return true;
    }
}