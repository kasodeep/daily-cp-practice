package numbertheory;

public class ExtendedEuclidean {

    public static int extendedGCD(int a, int b){
        int[] arr = new int[2];
        return gcd(a, b, arr);
    }

    public static int gcd(int a, int b, int[] arr) {
        if (b == 0) {
            arr[0] = 1;
            arr[1] = 0;
            return a;
        }

        int x1, y1;
        int[] temp = new int[2];
        int d = gcd(b, a % b, temp);

        arr[0] = temp[1];
        arr[1] = temp[0] - temp[1] * (a / b);
        return d;
    }
}
