import java.util.*;

public class GoldBlocks {
    static int gold = 1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int p = scn.nextInt();
        int points[][] = new int[p][2];

        for (int i = 0; i < p; i++) {
            points[i][0] = scn.nextInt();
            points[i][1] = scn.nextInt();
        }

        System.out.println(getGoldBlocks(m, n, points));

        scn.close();
    }

    static List<Integer> getGoldBlocks(int m, int n, int[][] points) {
        int roots[] = new int[m * n];
        Arrays.fill(roots, -1);

        List<Integer> result = new ArrayList<>(points.length);
        int count = 0;

        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, -1, 0, 1 };

        for (int[] point : points) {
            int i = point[0];
            int j = point[1];

            count++;
            int idx = n * i + j;

            if (roots[idx] == -1)
                roots[idx] = idx;

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                int nb = n * x + y;
                if (x >= 0 && y >= 0 && x < m && y < n && roots[nb] != -1) {
                    int rootNb = getRoot(roots, nb);

                    if (roots[rootNb] != idx) {
                        roots[rootNb] = idx;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    static int getRoot(int roots[], int idx) {
        while (idx != roots[idx]) {
            idx = roots[idx];
        }
        return idx;
    }
}
