package segmenttrees;

public class SegmentTree {

    int[] seg;

    int n;

    // Constructor.
    public SegmentTree(int n) {
        seg = new int[4 * n];
    }

    public void build(int idx, int low, int high, int[] arr) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);

        seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    public int query(int idx, int low, int high, int l, int r) {
        // No Overlap.
        if (r < low || high < l) return Integer.MAX_VALUE;

        // Complete Overlap.
        if (low >= l && high <= r) return seg[idx];

        // Partial Overlap.
        int mid = low + (high - low) / 2;
        int left = query(2 * idx + 1, low, mid, l, r);
        int right = query(2 * idx + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    public void update(int idx, int low, int high, int i, int val) {
        if (low == high) {
            seg[idx] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        if (i <= mid) update(2 * idx + 1, low, mid, i, val);
        else update(2 * idx + 2, mid + 1, high, i, val);

        seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
}
