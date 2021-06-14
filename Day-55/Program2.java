import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        char[][] splits = new char[n][];
        String raw[] = scn.next().split(",");

        for (int i = 0; i < n; i++) {
            splits[i] = raw[i].toCharArray();
        }

        System.out.println(countRegions(splits, n));

        scn.close();
    }

    static int countRegions(char[][] splits, int n) {
        int parent[] = new int[n * n * 4];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getElement(i, j, n);

                if (splits[i][j] != 'L') {
                    union(parent, idx + 0, idx + 3);
                    union(parent, idx + 1, idx + 2);
                }

                if (splits[i][j] != 'R') {
                    union(parent, idx + 0, idx + 1);
                    union(parent, idx + 2, idx + 3);
                }

                if (i + 1 < n) {
                    union(parent, idx + 2, getElement(i + 1, j, n) + 0);
                }
                if (j + 1 < n) {
                    union(parent, idx + 1, getElement(i, j + 1, n) + 3);
                }
                if (i > 0) {
                    union(parent, idx + 0, getElement(i - 1, j, n) + 2);
                }
                if (j > 0) {
                    union(parent, idx + 3, getElement(i, j - 1, n) + 1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(parent, i) == i) {
                count++;
            }
        }

        return count;
    }

    static int getElement(int i, int j, int n) {
        return (i * n * 4) + (j * 4);
    }

    static int find(int parent[], int idx) {
        int root = idx;

        while (parent[root] != root) {
            root = parent[root];
        }

        while (parent[idx] != idx) {
            int temp = idx;
            idx = parent[idx];
            parent[temp] = root;
        }

        return root;
    }

    static void union(int parent[], int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}