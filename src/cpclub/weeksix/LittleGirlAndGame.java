package cpclub.weeksix;

import java.util.HashMap;
import java.util.Scanner;

public class LittleGirlAndGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int oddCount = 0;
        for (int value : map.values()) if (value % 2 != 0) oddCount++;
        if (oddCount != 0 && oddCount % 2 == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }

    }
}
