package cpclub.weekthree;


import java.util.Scanner;
import java.util.Stack;

/**
 * Great Question, Got me crazy how to use stack!
 * */
public class GreatVovaWall {

    private static final int N = 200 * 1000 + 13;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            a[i] &= 1;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && a[i] == st.peek())
                st.pop();
            else
                st.push(a[i]);
        }

        System.out.println(st.size() <= 1 ? "YES" : "NO");
    }
}
