import java.util.Arrays;

public class MinSegmentTree {
    int t[];

    // method to implement segment tree
    public MinSegmentTree(int nums[], int n) {
        t = new int[n * 4];
        Arrays.fill(t, Integer.MAX_VALUE);
        build(0, nums, 0, n - 1);
    }

    void build(int v, int[] nums, int l, int r) {
        if (l == r) {
            t[v] = nums[l];
        } else {
            int m = (l + r) / 2;
            int tl = 2 * v + 1;
            int tr = 2 * v + 2;
            build(tl, nums, l, m);
            build(tr, nums, m + 1, r);
            t[v] = Math.min(t[tl], t[tr]);
        }
    }

    // method to find the minimum value in the range
    int findMinimum(int n, int s1, int s2) {
        return getMin(0, 0, n - 1, s1, s2);
    }

    int getMin(int v, int l, int r, int s1, int s2) {
        if (s1 > s2)
            return Integer.MAX_VALUE;
        if (l == s1 && r == s2)
            return t[v];

        int m = (l + r) / 2;
        int tl = 2 * v + 1;
        int tr = 2 * v + 2;

        return Math.min(getMin(tl, l, m, s1, Math.min(m, s2)), getMin(tr, m + 1, r, Math.max(m + 1, s1), s2));
    }

}