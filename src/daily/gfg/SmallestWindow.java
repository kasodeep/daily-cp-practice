package daily.gfg;

public class SmallestWindow {

    public static int smallestSubstring(String S) {
        int[] a = new int[3];
        int j = 0, ans = Integer.MAX_VALUE, cnt = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            int num = S.charAt(i) - '0';
            if (a[num] == 0) cnt++;
            a[num]++;

            while (cnt == 3) {
                ans = Math.min(ans, i - j + 1);
                a[num]--;

                if (a[num] == 0) cnt--;
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
