package cpclub.weektwo;

import java.util.Scanner;

public class PerfectTeam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q-- > 0){
            int c = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();

            int st = 0, end = (c + m + x) / 3;
            int ans = 0;

            while (st <= end){
                int mid = st + (end - st) / 2;
                if(isValid(c, m, x, mid)){
                    ans = Math.max(ans, mid);
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }

    private static boolean isValid(int c, int m, int x, int teams) {
        if(c < teams || m < teams) return false;
        int sum = Math.abs(c - teams) + Math.abs(m - teams) + x;
        return sum >= teams;
    }
}
