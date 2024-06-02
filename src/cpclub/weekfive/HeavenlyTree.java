package cpclub.weekfive;

import java.util.Scanner;

public class HeavenlyTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean[] check = new boolean[n + 1];
            while (m-- > 0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                check[b] = true;
            }

            int common = -1;
            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    common = i;
                    break;
                }
            }

            for (int i = 1; i <= n; i++){
                if(common == i) continue;
                System.out.println(common + " " + i);
            }
        }
    }
}
