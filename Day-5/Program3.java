import java.util.*;

public class Program3 {
    static boolean visited[];

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] adj = new boolean[n][n];
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = scn.nextInt();
            v = scn.nextInt();

            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(getLowestDepthTreeRoots(adj, n));

        scn.close();
    }

    static List<Integer> getLowestDepthTreeRoots(boolean[][] adj, int n) {
        List<Integer> roots = new ArrayList<>();
        int minDepth = Integer.MAX_VALUE;
        visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            int tempDepth = getDepth(adj, v);
            if (minDepth > tempDepth) {
                roots.clear();
                minDepth = tempDepth;
                roots.add(v);
            } else if (minDepth == tempDepth) {
                roots.add(v);
            }
        }

        return roots;
    }

    static int getDepth(boolean adj[][], int v) {
        int max = 0;
        visited[v] = true;

        for (int u = 0; u < adj[v].length; u++) {
            if (!visited[u] && adj[v][u])
                max = Math.max(getDepth(adj, u), max);
        }

        visited[v] = false;
        return max + 1;
    }
}
