package cpclub.weekthree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings("DataFlowIssue")
public class ChefTeams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long y_R = 0, o_R = 0;

        PriorityQueue<int[]> old = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> yng = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        old.add(new int[]{Integer.MAX_VALUE, 0});
        yng.add(new int[]{Integer.MIN_VALUE, 0});

        for (int i = 0; i < n; i++) {
            int age = scanner.nextInt();
            int rating = scanner.nextInt();

            if (i % 2 == 0) {
                int[] min_old = old.peek();
                if (min_old[0] < age) {
                    y_R += min_old[1];
                    yng.add(min_old);
                    old.poll();

                    old.add(new int[]{age, rating});
                    o_R = o_R + rating - min_old[1];
                } else {
                    y_R += rating;
                    yng.add(new int[]{age, rating});
                }
            } else {
                int[] max_yng = yng.peek();
                if (max_yng[0] > age) {
                    o_R += max_yng[1];
                    old.add(max_yng);
                    yng.poll();

                    yng.add(new int[]{age, rating});
                    y_R = y_R + rating - max_yng[1];
                } else {
                    o_R += rating;
                    old.add(new int[]{age, rating});
                }
            }
            System.out.println(Math.abs(y_R - o_R));
        }

        scanner.close();
    }
}
