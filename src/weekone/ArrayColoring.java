package weekone;

import java.util.Scanner;

/**
 * Adding Even Elements doesn't affect the Parity.
 * However, Odd Elements do affect the Parity.
 */
public class ArrayColoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int oddCount = 0;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (temp % 2 != 0) oddCount++;
            }

            if (oddCount % 2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
