package cpclub.weektwo;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Used the Classic Two Pointer Approach!
 */
public class KuroniAndStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int i = 0, j = s.length() - 1;
        Vector<Integer> vector = new Vector<>();
        while (i < j) {
            if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                vector.add(i + 1);
                vector.add(j + 1);
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) == ')') i++;
            if (s.charAt(j) == '(') j--;
        }

        vector.sort(Comparator.comparingInt(a -> a));
        System.out.println(vector.size() == 0 ? 0 : 1);
        if (vector.size() > 0) {
            System.out.println(vector.size());
            for (Integer integer : vector) System.out.print(integer + " ");
            System.out.println();
        }
    }
}
