package weeksix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DressInVests {

    static Pair[] equipSoldiers(int n, int m, int x, int y, int[] soldierSizes, int[] vestSizes) {
        List<Pair> assignments = new ArrayList<>();
        int soldierIndex = 0;
        int vestIndex = 0;

        while (soldierIndex < n && vestIndex < m) {
            while (vestIndex < m && vestSizes[vestIndex] < soldierSizes[soldierIndex] - x) {
                vestIndex++;
            }

            // If there's a valid vest for the current soldier, assign it
            if (vestIndex < m && vestSizes[vestIndex] <= soldierSizes[soldierIndex] + y) {
                assignments.add(new Pair(soldierIndex + 1, vestIndex + 1));
                soldierIndex++;
                vestIndex++;
            } else {
                soldierIndex++;
            }
        }

        return assignments.toArray(new Pair[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[] soldierSizes = new int[n];
        int[] vestSizes = new int[m];

        for (int i = 0; i < n; i++) {
            soldierSizes[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            vestSizes[i] = scanner.nextInt();
        }

        Pair[] assignments = equipSoldiers(n, m, x, y, soldierSizes, vestSizes);

        System.out.println(assignments.length);
        for (Pair assignment : assignments) {
            System.out.println(assignment.soldier + " " + assignment.vest);
        }
    }

    static class Pair {
        int soldier;
        int vest;

        Pair(int soldier, int vest) {
            this.soldier = soldier;
            this.vest = vest;
        }
    }
}

