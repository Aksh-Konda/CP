import java.util.*;

public class Program1 {
    static int[][] distances;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int h = scn.nextInt();

        distances = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], -1);
            distances[i][i] = 0;
        }

        for (int i = 0; i < k; i++) {
            int v = scn.nextInt();
            int u = scn.nextInt();
            int d = scn.nextInt();
            distances[u][v] = d;
            distances[v][u] = d;
        }

        System.out.println(getMinReachable(n, h));

        scn.close();
    }

    static int getMinReachable(int n, int h) {
        int minCount = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            int temp[] = dijkstra(i, n);
            System.out.println(Arrays.toString(temp));
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && temp[j] <= h) {
                    count++;
                }
            }

            if (count <= minCount) {
                result = i;
                minCount = count;
            }
        }

        return result;
    }

    static int[] dijkstra(int v, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[v] = 0;

        Queue<Integer> q = new PriorityQueue<>();
        q.offer(v);

        while (!q.isEmpty()) {
            int v1 = q.poll();

            for (int i = 0; i < n; i++) {
                if (distances[v1][i] >= 0 && (dist[i] > dist[v1] + distances[v1][i])) {
                    dist[i] = dist[v1] + distances[v1][i];
                    q.offer(i);
                }
            }
        }

        return dist;
    }
}