package weektwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * When working with subsequences, we need to go as right as possible.
 */
public class StrongPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            char[] s = reader.readLine().toCharArray();
            int n = s.length;

            int m = Integer.parseInt(reader.readLine());
            char[] l = reader.readLine().toCharArray();
            char[] r = reader.readLine().toCharArray();
            int mx = 0;

            for (int i = 0; i < m; i++) {
                int li = Character.getNumericValue(l[i]);
                int ri = Character.getNumericValue(r[i]);
                int nmx = mx;

                for (int c = li; c <= ri; c++) {
                    int cur = mx;
                    while (cur < n && s[cur] - '0' != c) cur++;
                    nmx = Math.max(nmx, cur);
                }
                mx = nmx + 1;
            }

            System.out.println(mx > n ? "YES" : "NO");
        }
        reader.close();
    }
}
