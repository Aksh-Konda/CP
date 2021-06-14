import java.util.*;

public class Program3 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] adj = new boolean[n][n];

        for (int i = 1; i < n; i++) {
            int v = scn.nextInt();
            int u = scn.nextInt();
            adj[u][v] = true;
        }

        int[] patience = new int[n];

        for (int i = 0; i < n; i++) {
            patience[i] = scn.nextInt();
        }

        List<Integer> result = new ArrayList<>(n);
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            getUpperNodes(adj, nodes, i);
            result.add(getMinPatientIndex(nodes, patience));
            nodes.clear();
        }

        System.out.println(result);

        scn.close();
    }

    static int getMinPatientIndex(Set<Integer> nodes, int patience[]) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i : nodes) {
            if (patience[i] < min) {
                idx = i;
                min = patience[i];
            }
        }
        return idx;
    }

    public static void getUpperNodes(boolean[][] adj, Set<Integer> nodes, int v) {
        if (nodes.contains(v))
            return;
        nodes.add(v);

        for (int i = 0; i < adj.length; i++) {
            if (adj[v][i] && !nodes.contains(i)) {
                getUpperNodes(adj, nodes, i);
            }
        }
    }
}