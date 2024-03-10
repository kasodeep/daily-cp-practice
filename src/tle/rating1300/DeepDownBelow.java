package tle.rating1300;

import java.io.*;
import java.util.*;

public class DeepDownBelow {

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();

                Pair[] pairs = new Pair[n];
                for (int i = 0; i < n; i++) {
                    int k = in.nextInt();
                    int max = Integer.MIN_VALUE;

                    for (int j = 0; j < k; j++) {
                        int temp = in.nextInt();
                        max = Math.max(max, temp - j);
                    }
                    pairs[i] = new Pair(k, max);
                }

                Arrays.sort(pairs, Comparator.comparingInt(p -> p.y));
                long sum = 0;
                long ans = 0;

                for (int i = 0; i < n; i++) {
                    if (pairs[i].y - sum > ans) ans = pairs[i].y - sum;
                    sum += pairs[i].x;
                }
                out.println(ans + 1);
            }
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
