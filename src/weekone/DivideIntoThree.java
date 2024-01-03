package weekone;

import java.util.ArrayList;
import java.util.Scanner;

public class DivideIntoThree {

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> third = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a == 0)
                third.add(a);
            if (a > 0)
                second.add(a);
            if (a < 0)
                first.add(a);
        }

        if (second.size() == 0) {
            for (int i = 0; i < 2; i++) {
                second.add(first.get(first.size() - 1));
                first.remove(first.size() - 1);
            }
        }

        if (first.size() % 2 == 0) {
            third.add(first.get(first.size() - 1));
            first.remove(first.size() - 1);
        }

        System.out.printf("%d", first.size());
        for (Integer integer : first) {
            System.out.printf(" %d", integer);
        }

        System.out.printf("\n%d", second.size());
        for (Integer integer : second) {
            System.out.printf(" %d", integer);
        }

        System.out.printf("\n%d", third.size());
        for (Integer integer : third) {
            System.out.printf(" %d", integer);
        }
        System.out.println();
    }
}
