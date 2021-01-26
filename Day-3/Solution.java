import java.util.*;

class Solution {
    static int t[];

    public static void build(int nums[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = nums[tl];
        else {
            int tm = (tl + tr) / 2;
            build(nums, v * 2 + 1, tl, tm);
            build(nums, v * 2 + 2, tm + 1, tr);
            t[v] = t[v * 2 + 1] < t[v & 2 + 2] ? t[v * 2 + 1] : t[v * 2 + 2];
        }
    }

    public static int getMinimum(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return Integer.MAX_VALUE;
        if (tl == l && tr == r)
            return t[v];
        else {
            int tm = (tl + tr) / 2;
            int x = getMinimum(v * 2 + 1, tl, tm, l, r < tm ? r : tm);
            int y = getMinimum(v * 2 + 2, tm + 1, tr, tm + 1 > l ? tm + 1 : l, r);
            return x < y ? x : y;
        }
    }

    // method to implement segment tree
    void segmentTree(int nums[], int n) {
        t = new int[4 * n];
        Arrays.fill(t, Integer.MAX_VALUE);
        build(nums, 1, 0, n - 1);
    }

    // method to find the minimum value in the range
    int findMinimum(int n, int s1, int s2) {
        return getMinimum(1, 0, n - 1, s1, s2);
    }

}