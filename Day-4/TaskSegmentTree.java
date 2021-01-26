import java.util.Arrays;
import java.util.Comparator;

public class TaskSegmentTree {
    boolean t[];
    int minL, maxR;

    public int getMaxCount(int[][] tasks) {
        minL = Integer.MAX_VALUE;
        maxR = Integer.MIN_VALUE;

        for (int i = 0; i < tasks.length; i++) {
            if (maxR < tasks[i][1])
                maxR = tasks[i][1];
            if (minL > tasks[i][0])
                minL = tasks[i][0];
        }

        t = new boolean[4 * (maxR - minL)];

        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        int count = 0;
        for (int[] task : tasks) {
            if (query(0, minL, maxR, task[0], task[1])) {
                count++;
            }
        }

        return count;
    }

    boolean query(int v, int l, int r, int start, int end) {
        if (start > end)
            return false;
        if (l == r) {
            if (t[v])
                return false;
            t[v] = true;
            return true;
        }
        int m = (l + r) / 2;
        int tl = 2 * v + 1;
        int tr = 2 * v + 2;

        boolean result = query(tl, l, m, start, m < end ? m : end)
                || query(tl, m + 1, l, m + 1 > start ? m + 1 : start, end);
        t[v] = t[tl] && t[tr];

        return result;
    }
}
