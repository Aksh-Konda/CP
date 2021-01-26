public class SegmentTree {
    Pair t[];

    SegmentTree(int nums[]) {
        t = new Pair[nums.length * 4];
        create(0, nums, 0, nums.length - 1);
    }

    private Pair combine(Pair a, Pair b) {
        if (a.max > b.max)
            return a;
        if (a.max < b.max)
            return b;
        return new Pair(a.max, a.freq + b.freq);
    }

    private void create(int v, int[] nums, int l, int r) {
        if (l == r) {
            t[v] = new Pair(nums[l], 1);
        } else {
            int m = (l + r) / 2;
            int tl = 2 * v + 1;
            int tr = 2 * v + 2;
            create(tl, nums, l, m);
            create(tr, nums, m + 1, r);
            t[v] = combine(t[tl], t[tr]);
        }
    }

    public void update(int v, int l, int r, int pos, int new_value) {
        if (l == r) {
            t[v] = new Pair(new_value, 1);
        } else {
            int m = (l + r) / 2;
            int tl = 2 * v + 1;
            int tr = 2 * v + 2;
            if (pos <= m) {
                update(tl, l, m, pos, new_value);
            } else {
                update(tr, m + 1, r, pos, new_value);
            }
            t[v] = combine(t[tl], t[tr]);
        }
    }

    public Pair getMax(int v, int l, int r, int start, int end) {
        if (start > end)
            return new Pair(Integer.MIN_VALUE, 0);
        if (l == start && r == end)
            return t[v];

        int m = (l + r) / 2;
        int tl = 2 * v + 1;
        int tr = 2 * v + 2;
        return combine(getMax(tl, l, m, start, Math.min(end, m)), getMax(tr, m + 1, r, Math.max(m + 1, start), end));
    }

}