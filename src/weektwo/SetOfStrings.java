package weektwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SetOfStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();

        // Default Cases.
        if (k > s.length()) {
            System.out.println("NO");
            return;
        }

        if (k == 1) {
            System.out.println("YES");
            System.out.println(s);
            return;
        }

        HashSet<Character> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                count++;
                ans.add(i);
                set.add(ch);
            }

            if (count == k) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
            for (int i = 0; i < ans.size() - 1; i++) {
                System.out.println(s.substring(ans.get(i), ans.get((i + 1))));
            }
            System.out.println(s.substring(ans.get(ans.size() - 1)));
        } else {
            System.out.println("NO");
        }
    }
}
