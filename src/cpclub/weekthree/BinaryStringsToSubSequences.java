package cpclub.weekthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryStringsToSubSequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int[] ans = new int[n];
            List<Integer> pos0 = new ArrayList<>();
            List<Integer> pos1 = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int newpos = pos0.size() + pos1.size();
                if (s.charAt(i) == '0') {
                    if (pos1.isEmpty()) {
                        pos0.add(newpos);
                    } else {
                        newpos = pos1.get(pos1.size() - 1);
                        pos1.remove(pos1.size() - 1);
                        pos0.add(newpos);
                    }
                } else {
                    if (pos0.isEmpty()) {
                        pos1.add(newpos);
                    } else {
                        newpos = pos0.get(pos0.size() - 1);
                        pos0.remove(pos0.size() - 1);
                        pos1.add(newpos);
                    }
                }
                ans[i] = newpos;
            }

            System.out.println(pos0.size() + pos1.size());
            for (int num : ans) {
                System.out.print((num + 1) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
