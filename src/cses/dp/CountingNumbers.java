package cses.dp;

import java.io.*;
import java.util.*;

public class CountingNumbers {
    final static int mod = 1000000007;
    static long[][][][] dp = new long[20][10][2][2];

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            long a = in.nextLong();
            long b = in.nextLong();

            initialize();
            long countA = 0;
            String strA = Long.toString(a - 1);
            if (a != 0) countA = solve(strA, 0, 0, 1, 1);

            initialize();
            String strB = Long.toString(b);
            long countB = solve(strB, 0, 0, 1, 1);

            out.println(countB - countA);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static long solve(String s, int curr, int prev_digit, int leading_zero, int tight) {
        if (curr == s.length()) return 1;

        if (dp[curr][prev_digit][leading_zero][tight] != -1)
            return dp[curr][prev_digit][leading_zero][tight];

        int limit = tight == 0 ? 9 : s.charAt(curr) - '0';
        long countNumbers = 0;

        for (int curr_digit = 0; curr_digit <= limit; curr_digit++) {
            if (leading_zero == 0 && (curr_digit == prev_digit)) continue;

            int new_leading_zero = (leading_zero == 1 && curr_digit == 0) ? 1 : 0;
            int new_tight = (curr_digit == limit && tight == 1) ? 1 : 0;

            countNumbers += solve(s, curr + 1, curr_digit, new_leading_zero, new_tight);
        }

        return dp[curr][prev_digit][leading_zero][tight] = countNumbers;
    }

    public static void initialize() {
        for (long[][][] outer : dp) {
            for (long[][] inner : outer) {
                for (long[] temp : inner) {
                    Arrays.fill(temp, -1);
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(BufferedReader br) {
            this.br = br;
        }

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
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

        int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter(BufferedWriter bw) {
            this.bw = bw;
        }

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

        public void printDouble(double num, int precision) throws IOException {
            String formatted = String.format("%." + precision + "f", num);
            bw.append(formatted);
        }

        public void close() throws IOException {
            bw.close();
        }

        public void printIntArray(int[] array) throws IOException {
            for (int i = 0; i < array.length - 1; i++) {
                bw.append(String.valueOf(array[i])).append(" ");
            }
            bw.append(String.valueOf(array[array.length - 1])).append("\n");
        }

        public void printLongArray(long[] array) throws IOException {
            for (int i = 0; i < array.length - 1; i++) {
                bw.append(String.valueOf(array[i])).append(" ");
            }
            bw.append(String.valueOf(array[array.length - 1])).append("\n");
        }

        public void printDoubleArray(double[] array) throws IOException {
            for (int i = 0; i < array.length - 1; i++) {
                bw.append(String.valueOf(array[i])).append(" ");
            }
            bw.append(String.valueOf(array[array.length - 1])).append("\n");
        }

        public void printCharArray(char[] array) throws IOException {
            for (int i = 0; i < array.length - 1; i++) {
                bw.append(array[i]);
            }
            bw.append(String.valueOf(array[array.length - 1])).append("\n");
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}