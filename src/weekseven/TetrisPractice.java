package weekseven;

import java.util.*;
import java.io.*;

public class TetrisPractice {

    static final int MOD = 1000000007;
    static long[][][] dp = new long[100005][2][5];

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int testCases = in.nextInt();
            for (long[][] layer : dp) for (long[] row : layer) Arrays.fill(row, -1);

            while (testCases-- > 0) {
                int n = in.nextInt();
                out.println(solve(n, 0, 0));
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static long solve(int n, int p, int last) {
        if (n <= 0) {
            if (p == 0 && last == 4) return 1;
            else return 0;
        }

        if (dp[n][p][last] != -1) return dp[n][p][last];

        long sum = 0;
        sum = (sum + solve(n - 1, p ^ 1, 1)) % MOD;
        sum = (sum + solve(n - 2, p, 2)) % MOD;
        sum = (sum + solve(n - 3, p, 3)) % MOD;
        sum = (sum + solve(n - 4, p, 4)) % MOD;

        return dp[n][p][last] = sum;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}
