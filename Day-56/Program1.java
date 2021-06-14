import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int actions[][] = new int[m][3];

        for (int i = 0; i < m; i++) {
            actions[i][0] = scn.nextInt();
            actions[i][1] = scn.nextInt();
            actions[i][2] = scn.nextInt();
        }

        System.out.println(getFinalResult(actions, n));

        scn.close();
    }

    static List<Integer> getFinalResult(int[][] actions, int n) {
        int[] memo = new int[n + 1];

        for (int action[] : actions) {
            memo[action[0]] += action[2];
            memo[action[1] + 1] -= action[2];
        }

        List<Integer> result = new ArrayList<>(n);
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += memo[i];
            result.add(curr);
        }

        return result;
    }
}