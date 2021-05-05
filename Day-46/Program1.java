import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        int scores[] = new int[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scn.nextInt();
        }
        System.out.println(maxEqualAfterModify(scores, p));
        scn.close();
    }

    static int maxEqualAfterModify(int scores[], int p) {
        Arrays.sort(scores);
        int n = scores.length;
        int i = 0, sum = 0, len = 0, res = 0;
        for (int j = 0; j < n; j++) {
            sum += scores[j];
            len++;
            while (scores[j] * len - sum > p) {
                sum -= scores[i];
                i++;
                len--;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}