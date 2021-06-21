import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char mat[][] = new char[m][];

        for (int i = 0; i < m; i++) {
            mat[i] = scn.next().toCharArray();
        }

        rotatedMat(mat, m, n);

        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

        scn.close();
    }

    static void rotatedMat(char[][] mat, int m, int n) {
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'O') {
                    int k = j + 1;
                    while (!q.isEmpty()) {
                        mat[i][k] = q.pollFirst();
                        k++;
                    }
                } else if (mat[i][j] == 'S') {
                    q.addFirst('S');
                } else {
                    q.addLast('I');
                }
            }
            int k = 0;
            while (!q.isEmpty()) {
                mat[i][k] = q.pollFirst();
                k++;
            }
        }
    }
}