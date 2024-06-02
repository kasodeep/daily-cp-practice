package cpclub.weekthree;

import java.util.Scanner;
import java.util.Stack;

public class AdjacentFlips {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (!st.isEmpty() && s.charAt(i) == st.peek()) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
            System.out.println(st.size() <= 1 ? "Yes" : "No");
        }
    }
}
