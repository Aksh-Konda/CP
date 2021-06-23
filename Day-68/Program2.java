import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
        int a = scn.nextInt();
        boolean[][] concrete = new boolean[n][n];
        boolean[][] asphalt = new boolean[n][n];

        for (int i = 0; i < c; i++) {
            concrete[scn.nextInt()][scn.nextInt()] = true;
        }
        for (int i = 0; i < a; i++) {
            asphalt[scn.nextInt()][scn.nextInt()] = true;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        boolean[] cVis = new boolean[n], aVis = new boolean[n];
        cVis[0] = aVis[1] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, false));
        q.add(new Node(0, 0, true));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            boolean[][] graph = curr.isConc ? asphalt : concrete;
            boolean[] vis = curr.isConc ? aVis : cVis;

            for (int i = 0; i < n; i++) {
                if (graph[curr.i][i] && !vis[i]) {
                    if (ans[i] == -1)
                        ans[i] = curr.c + 1;
                    q.add(new Node(i, curr.c + 1, !curr.isConc));
                    vis[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        scn.close();
    }
}

class Node {
    int i, c;
    boolean isConc;

    Node(int i, int c, boolean isC) {
        this.i = i;
        this.c = c;
        this.isConc = isC;
    }
}