package segmenttrees;

import java.util.Scanner;

public class SerejaAndBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        SegmentTree tree = new SegmentTree(s.length());
        tree.build(0, 0, s.length() - 1, s);

        int m = sc.nextInt();
        while (m-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            Info query = tree.query(0, 0, s.length() - 1, l - 1, r - 1);
            System.out.println(2 * query.full);
        }
    }

    static class SegmentTree {

        Info[] seg;

        int n;

        // Constructor.
        public SegmentTree(int n) {
            seg = new Info[4 * n];
        }

        public Info merge(Info left, Info right) {
            Info ans = new Info(0, 0, 0);
            ans.full = left.full + right.full + Math.min(left.open, right.close);
            ans.open = left.open + right.open - Math.min(left.open, right.close);
            ans.close = left.close + right.close - Math.min(left.open, right.close);
            return ans;
        }

        public void build(int idx, int low, int high, String s) {
            if (low == high) {
                seg[idx] = new Info(s.charAt(low) == '(' ? 1 : 0,
                        s.charAt(low) == ')' ? 1 : 0,
                        0);
                return;
            }

            int mid = low + (high - low) / 2;
            build(2 * idx + 1, low, mid, s);
            build(2 * idx + 2, mid + 1, high, s);

            seg[idx] = merge(seg[2 * idx + 1], seg[2 * idx + 2]);
        }

        public Info query(int idx, int low, int high, int l, int r) {
            // No Overlap.
            if (r < low || high < l) return new Info(0, 0, 0);

            // Complete Overlap.
            if (low >= l && high <= r) return seg[idx];

            // Partial Overlap.
            int mid = low + (high - low) / 2;
            Info left = query(2 * idx + 1, low, mid, l, r);
            Info right = query(2 * idx + 2, mid + 1, high, l, r);
            return merge(left, right);
        }
    }

    static class Info {
        int open;
        int close;
        int full;

        public Info(int open, int close, int full) {
            this.open = open;
            this.close = close;
            this.full = full;
        }
    }
}
