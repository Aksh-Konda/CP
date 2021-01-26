import java.util.*;

class Solution {
    static boolean adj[][], visited[];
    static int edgeTravel[][];
    static int totalPaths = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int edges[][] = new int[scn.nextInt()][2];
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = scn.nextInt();
            edges[i][1] = scn.nextInt();
        }
        int p = scn.nextInt();

        System.out.println(markArtcPoints(p, n, edges));

        scn.close();
    }

    static int markArtcPoints(int p, int n, int[][] edges) {
        if (p == n)
            return -1;
        visited = new boolean[n];
        adj = new boolean[n][n];
        edgeTravel = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj[u][v] = adj[v][u] = true;
        }

        dfs(p - 1, n - 1);

        int streets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edgeTravel[i][j] == totalPaths) {
                    streets++;
                }
            }
        }

        return streets > 0 ? streets : -1;
    }

    static int dfs(int v, int p) {
        visited[v] = true;
        if (v == p) {
            visited[v] = false;
            totalPaths += 1;
            return 1;
        }

        int total = 0;
        for (int u = 0; u < adj[v].length; u++) {
            if (adj[v][u] && !visited[u]) {
                int count = dfs(u, p);
                if (count > 0) {
                    edgeTravel[v][u] += count;
                    total += count;
                }
            }
        }

        visited[v] = false;

        return total;
    }
}