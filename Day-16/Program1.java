import java.util.*;

public class Program1 {

    static char B = 'B';
    static char E = '0';
    static char M = 'M';

    public static void main(String[] args) {

        // Arrays.stream(scn.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        char plane[][] = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                plane[i][j] = scn.next().charAt(0);
            }
        }

        System.out.println(getMaxMagnetsAttracted(plane, m, n));

        scn.close();
    }

    static int getMaxMagnetsAttracted(char plane[][], int m, int n) {
        int count[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (plane[i][j] == B) {
                    for (int k = j + 1; k < n; k++) {
                        if (plane[i][k] == M)
                            break;
                        if (plane[i][k] == E) {
                            count[i][k] += 1;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (plane[i][k] == M)
                            break;
                        if (plane[i][k] == E) {
                            count[i][k] += 1;
                        }
                    }
                    for (int k = i + 1; k < m; k++) {
                        if (plane[k][j] == M)
                            break;
                        if (plane[k][j] == E) {
                            count[k][j] += 1;
                        }
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (plane[k][j] == M)
                            break;
                        if (plane[k][j] == E) {
                            count[k][j] += 1;
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = max < count[i][j] ? count[i][j] : max;
            }
        }

        return max;
    }
}