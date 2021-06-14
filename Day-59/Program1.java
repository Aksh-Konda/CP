import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int p = scn.nextInt();
        int[][] r = new int[p][p];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if (scn.nextInt() == 1) {
                    r[i][j] = 1;
                    r[j][i] = 1;
                }
            }
        }

        System.out.println(countRelationChains(r, p));

        scn.close();
    }

    static void dfs(int[][] r, int v, boolean[] visited) {
        if (visited[v])
            return;

        visited[v] = true;
        for (int i = 0; i < r[v].length; i++) {
            if (r[v][i] == 1) {
                dfs(r, i, visited);
            }
        }
    }

    static int countRelationChains(int[][] r, int p) {
        boolean visited[] = new boolean[p];

        int count = 0;
        for (int i = 0; i < p; i++) {
            if (!visited[i]) {
                dfs(r, i, visited);
                count++;
            }
        }

        return count;
    }
}