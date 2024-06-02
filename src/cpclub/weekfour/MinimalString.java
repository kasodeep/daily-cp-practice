package cpclub.weekfour;

import java.util.Scanner;
import java.util.Stack;

public class MinimalString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder u = new StringBuilder();
        Stack<Character> temp = new Stack<>();

        for (char ch = 'a'; ch <= 'z' && s.length() > 0; ch++) {
            int firstIdx = s.indexOf(ch);
            int lastIdx = s.lastIndexOf(ch);
            while (!temp.isEmpty() && temp.peek() <= ch) u.append(temp.pop());

            if (firstIdx == -1) continue;
            for (int i = firstIdx; i <= lastIdx; i++)
                if (s.charAt(i) == ch) u.append(ch);

            for (int i = 0; i < firstIdx; i++)
                temp.push(s.charAt(i));

            for (int i = firstIdx + 1; i < lastIdx; i++)
                if (s.charAt(i) != ch) temp.push(s.charAt(i));

            if (lastIdx == s.length() - 1) break;
            s = s.substring(lastIdx + 1);
        }

        while (temp.size() > 0)
            u.append(temp.pop());
        System.out.println(u);
    }
}
