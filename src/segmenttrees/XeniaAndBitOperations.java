package segmenttrees;

import java.util.Scanner;

public class XeniaAndBitOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int el = (int) Math.pow(2, n);
        int[] arr = new int[el];
        for (int i = 0; i < el; i++) arr[i] = sc.nextInt();

        SegmentTree tree = new SegmentTree(el);
        if (n % 2 != 0) tree.build(0, 0, el - 1, arr, 1);
        else tree.build(0, 0, el - 1, arr, 0);

        while (m-- > 0) {
            int i = sc.nextInt() - 1;
            int val = sc.nextInt();

            if (n % 2 != 0) tree.update(0, 0, el - 1, i, val, 1);
            else tree.update(0, 0, el - 1, i, val, 0);
            System.out.println(tree.seg[0]);
        }
    }

    static class SegmentTree {

        int[] seg;

        int n;

        // Constructor.
        public SegmentTree(int n) {
            seg = new int[4 * n];
        }

        public void build(int idx, int low, int high, int[] arr, int or) {
            if (low == high) {
                seg[idx] = arr[low];
                return;
            }

            int mid = low + (high - low) / 2;
            build(2 * idx + 1, low, mid, arr, 1 - or);
            build(2 * idx + 2, mid + 1, high, arr, 1 - or);

            if (or == 1) seg[idx] = seg[2 * idx + 1] | seg[2 * idx + 2];
            else seg[idx] = seg[2 * idx + 1] ^ seg[2 * idx + 2];
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

        public void update(int idx, int low, int high, int i, int val, int or) {
            if (low == high) {
                seg[idx] = val;
                return;
            }

            int mid = low + (high - low) / 2;
            if (i <= mid) update(2 * idx + 1, low, mid, i, val, 1 - or);
            else update(2 * idx + 2, mid + 1, high, i, val, 1 - or);

            if (or == 1) seg[idx] = seg[2 * idx + 1] | seg[2 * idx + 2];
            else seg[idx] = seg[2 * idx + 1] ^ seg[2 * idx + 2];
        }
    }
}
