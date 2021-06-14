import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int max = n * n;
        int board[] = new int[max + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 1; j <= n; j++) {
                    board[i * n + j] = scn.nextInt();
                }
            } else {
                for (int j = n; j >= 1; j--) {
                    board[i * n + j] = scn.nextInt();
                }
            }
        }

        System.out.println(getMinSteps(board));

        scn.close();
    }

    static int getMinSteps(int[] board) {
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        int max = board.length - 1;

        boolean visited[] = new boolean[board.length];
        q.offer(1);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                int curr = q.poll();

                if (curr == max)
                    return steps;
                for (int j = 1; j <= 6; j++) {
                    curr++;
                    if (curr > max)
                        break;
                    int next = board[curr] == -1 ? curr : board[curr];
                    if (!visited[curr]) {
                        q.offer(next);
                        visited[curr] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}