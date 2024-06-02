package cpclub.weekone;

import java.util.Scanner;

/**
 * Got the trick, select first k from A and last m from B.
 */
public class SelectKSelectM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[a];
        int[] brr = new int[b];
        for (int i = 0; i < a; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < b; i++) brr[i] = sc.nextInt();

        if (arr[k - 1] < brr[b - m]) System.out.println("YES");
        else System.out.println("NO");
    }
}

