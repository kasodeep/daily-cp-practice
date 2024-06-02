package cpclub.weektwo;

import java.util.Scanner;
import java.util.Stack;

public class MoveBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int count = 0;
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    st.push(ch);
                } else {
                    if (st.size() != 0 && st.peek() == '(') st.pop();
                    else count++;
                }
            }

            System.out.println(count);
        }
    }
}
