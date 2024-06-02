package cpclub.weeksix;

import java.util.*;
import java.io.*;

/**
 * Using the common mathematics and getting into the rhythm.
 */
public class NotAssigning {

    public static void main(String[] args) {
        var io = new Kattio(System.in, System.out);
        int t = io.nextInt();

        for (int i = 0; i < t; i++) solve(io);
        io.close();
    }

    public static void solve(Kattio io) {
        int n = io.nextInt();

        var graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = io.nextInt();
            int v = io.nextInt();
            u--;
            v--;

            graph.get(u).add(new Edge(v, i));
            graph.get(v).add(new Edge(u, i));
        }

        int start = 0;
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() > 2) {
                io.println("-1");
                return;
            } else if (graph.get(i).size() == 1) {
                start = i;
            }
        }

        int[] weight = new int[n - 1];

        int prevNode = -1;
        int curNode = start;
        int curWeight = 2;

        while (true) {
            var edges = graph.get(curNode);
            var next = edges.get(0);

            if (next.node == prevNode) {
                if (edges.size() == 1) break;
                else next = edges.get(1);
            }

            weight[next.index] = curWeight;
            prevNode = curNode;
            curNode = next.node;
            curWeight = 5 - curWeight;
        }

        for (int i = 0; i < n - 1; i++) {
            io.print(weight[i]);
            io.print(" ");
        }
        io.println();
    }

    static class Edge {
        public int node;
        public int index;

        Edge(int node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;
        private String token;

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public String next() {
            return nextToken();
        }

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        String line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException ignored) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}


