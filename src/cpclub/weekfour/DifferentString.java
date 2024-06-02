package cpclub.weekfour;

import java.util.Scanner;

public class DifferentString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = sc.next();

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) ans.append('1' - arr[i].charAt(i));
            System.out.println(ans);
        }
    }
}
