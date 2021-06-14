import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String[] traps = scn.nextLine().split(" ");
        String key = scn.next();

        System.out.println(getMinRotations(traps, key));
        scn.close();
    }

    static int getNumber(int[] arr) {
        return (1000 * arr[0]) + (100 * arr[1]) + (10 * arr[2]) + arr[3];
    }

    static int getMinRotations(String[] traps, String key) {
        boolean[] visited = new boolean[10000];
        for (String trap : traps)
            visited[Integer.parseInt(trap)] = true;

        int target = Integer.parseInt(key);
        if (visited[0] || visited[target])
            return -1;
        if (target == 0)
            return 0;

        Queue<Integer> q = new LinkedList<>();
        int count = 0, temp;
        visited[0] = true;
        q.offer(0);
        int[] curr = new int[4];

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int num = q.poll();
                curr[3] = num % 10;
                curr[2] = (num / 10) % 10;
                curr[1] = (num / 100) % 10;
                curr[0] = (num / 1000) % 10;
                for (int i = 0; i < 4; i++) {
                    int d = curr[i];
                    for (int j = -1; j <= 1; j += 2) {
                        curr[i] = d + j;
                        if (curr[i] < 0) {
                            curr[i] = 9;
                        } else if (curr[i] > 9) {
                            curr[i] = 0;
                        }
                        temp = getNumber(curr);
                        if (temp == target)
                            return count;
                        if (!visited[temp]) {
                            q.add(temp);
                            visited[temp] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}