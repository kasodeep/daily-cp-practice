package cpclub.weekone;

import java.util.Scanner;
import java.util.Vector;

/**
 * Will try to remember to convert them to minimal values such as index.
 * Let's keep improving.
 */
public class ArraySharpening {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Vector<Integer> tab = new Vector<>(n);
            for (int i = 0; i < n; ++i) tab.add(sc.nextInt());

            int prefixEnd = -1, suffixEnd = n;
            for (int i = 0; i < n; ++i) {
                if (tab.get(i) < i) break;
                prefixEnd = i;
            }

            for (int i = n - 1; i >= 0; --i) {
                if (tab.get(i) < (n - 1) - i) break;
                suffixEnd = i;
            }

            if (suffixEnd <= prefixEnd)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
