package tle.rating1100;

import java.io.*;
import java.util.*;

public class MaximumSum {

    final static long mod = 1000000007;

    public static void main(String[] args) {
        try {

            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                long[] a = in.nextLongArray(n);

                Arrays.sort(a);
                long[] pr = new long[n + 1];
                for (int i = 0; i < n; i++) pr[i + 1] = pr[i] + a[i];

                long ans = 0;
                for (int i = 0; i <= k; i++) {
                    ans = Math.max(ans, pr[n - (k - i)] - pr[2 * i]);
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
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