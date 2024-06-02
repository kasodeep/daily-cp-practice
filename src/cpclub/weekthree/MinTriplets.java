package cpclub.weekthree;

import java.util.*;

public class MinTriplets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < n; i++) vec.add(sc.nextInt());

            Collections.sort(vec);
            TreeMap<Long, Integer> mp = new TreeMap<>();
            long current = 0;

            for (int i = 0; i < n - 2; i++) {
                current += ((long) (n - i - 2) * (n - i - 1)) / 2;
                mp.put(current, vec.get(i));
            }

            for (int i = 0; i < q; i++) {
                long temp = sc.nextLong();
                System.out.println(mp.ceilingEntry(temp).getValue());
            }
        }
    }
}
