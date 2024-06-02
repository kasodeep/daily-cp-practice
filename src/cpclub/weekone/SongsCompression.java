package cpclub.weekone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The idea is to sort them on the basis of difference in compression.
 */
public class SongsCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();

        Pair[] songs = new Pair[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long or = sc.nextLong();
            long com = sc.nextLong();

            sum += or;
            songs[i] = new Pair(or, com);
        }

        if (sum <= m) {
            System.out.println(0);
            return;
        }

        Arrays.sort(songs, new MyComparator());
        boolean ans = false;

        int count = 0;
        for (int i = 0; i < n; i++) {
            sum = sum - songs[i].getOriginal() + songs[i].getCompressed();
            count++;

            if (sum <= m) {
                ans = true;
                break;
            }
        }

        if (ans) System.out.println(count);
        else System.out.println(-1);
    }

    static class Pair {
        long original;
        long compressed;

        public Pair(long original, long compressed) {
            this.original = original;
            this.compressed = compressed;
        }

        public long getOriginal() {
            return original;
        }

        public long getCompressed() {
            return compressed;
        }
    }

    public static class MyComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            long one = p1.getOriginal() - p1.getCompressed();
            long two = p2.getOriginal() - p2.getCompressed();
            return (int) (two - one);
        }
    }
}
