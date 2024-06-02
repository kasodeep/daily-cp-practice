package cpclub.weektwo;

import java.util.Arrays;
import java.util.Scanner;

public class BasketballTogether {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();
        Arrays.sort(array);

        int count = 0;
        int pointer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = array[i];
            while (sum <= d && pointer < i) {
                sum += array[i];
                pointer++;
            }

            if (sum > d) count++;
        }
        System.out.println(count);
    }
}
    

