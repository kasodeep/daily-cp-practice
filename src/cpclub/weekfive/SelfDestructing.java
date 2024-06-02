package cpclub.weekfive;

import java.util.Scanner;

public class SelfDestructing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String s = sc.nextLine();

            if ((s.length() & 1) == 1) {
                System.out.println(-1);
                continue;
            }

            int o = 0, z = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') z++;
                else o++;
            }

            if (o == 0 || z == 0) {
                System.out.println(-1);
                continue;
            }
            System.out.println(Math.abs(z - o) / 2);
        }
    }
}
