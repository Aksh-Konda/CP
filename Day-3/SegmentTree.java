public class SegmentTree {
    int t[];

    SegmentTree(int nums[]) {
        t = new int[nums.length * 4];
        create(0, nums, 0, nums.length - 1);
    }

    public void create(int v, int[] nums, int l, int r) {
        if (l == r) {
            t[v] = nums[l];
        } else {
            int m = (l + r) / 2;
            int tl = 2 * v + 1;
            int tr = 2 * v + 2;
            create(tl, nums, l, m);
            create(tr, nums, m + 1, r);
            t[v] = t[tl] + t[tr];
        }
        System.out.print("->t" + v);
    }

    public void update(int v, int l, int r, int pos, int new_value) {
        if (l == r) {
            t[v] = new_value;
        } else {
            int m = (l + r) / 2;
            int tl = 2 * v + 1;
            int tr = 2 * v + 2;
            if (pos <= m) {
                update(tl, l, m, pos, new_value);
            } else {
                update(tr, m + 1, r, pos, new_value);
            }
            t[v] = t[tl] + t[tr];
        }
    }

    public int getSum(int v, int l, int r, int start, int end) {
        if (start > end)
            return 0;
        if (l == start && r == end)
            return t[v];

        int m = (l + r) / 2;
        int tl = 2 * v + 1;
        int tr = 2 * v + 2;
        return getSum(tl, l, m, start, Math.min(end, m)) + getSum(tr, m + 1, r, Math.max(m, start), end);
    }
}