package cpclub.weekseven;

import java.io.*;
import java.util.*;

public class CutRibbon {
    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int n = in.nextInt();
            int[] cuts = in.nextIntArray(3);
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MIN_VALUE;
                for (int cut : cuts) {
                    if (i - cut >= 0) {
                        dp[i] = Math.max(dp[i], dp[i - cut] + 1);
                    }
                }
            }

            out.println(dp[n]);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static HashMap<Integer, Integer> primeFactorsWithCount(int n) {
        HashMap<Integer, Integer> factorsWithCount = new HashMap<>();

        while (n % 2 == 0) {
            factorsWithCount.put(2, factorsWithCount.getOrDefault(2, 0) + 1);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factorsWithCount.put(i, factorsWithCount.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        if (n > 2) factorsWithCount.put(n, factorsWithCount.getOrDefault(n, 0) + 1);
        return factorsWithCount;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

