import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int mat[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        System.out.println(maxSizeSpecialMat(mat, m, n));

        scn.close();
    }

    static int maxSizeSpecialMat(int[][] mat, int m, int n) {
        int maxN = Math.min(m, n);

        int colSum[][] = new int[m][n + 1];
        int rowSum[][] = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[i][j + 1] = colSum[i][j] + mat[i][j];
                rowSum[i + 1][j] = rowSum[i][j] + mat[i][j];
            }
        }

        for (int k = maxN; k > 1; k--) {
            if (check(k, mat, colSum, rowSum)) {
                return k;
            }
        }

        return 1;
    }

    static boolean check(int k, int mat[][], int[][] rowSum, int[][] colSum) {
        int m = mat.length - k;
        int n = mat[0].length - k;

        for (int i = 0; i <= m; i++) {
            out: for (int j = 0; j <= n; j++) {
                int sum = rowSum[i][j + k] - rowSum[i][j];
                int d1 = 0;
                int d2 = 0;
                for (int p = 0; p < k; p++) {
                    d1 += mat[i + p][j + p];
                    d2 += mat[i + k - 1 - p][j + p];
                    if (rowSum[i + p][j + k] - rowSum[i + p][j] != sum
                            || colSum[i + k][j + p] - colSum[i][j + p] != sum)
                        continue out;
                }

                if (d1 == sum || d2 == sum)
                    return true;
            }
        }

        return false;
    }
}