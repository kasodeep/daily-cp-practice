package daily.gfg;

public class ConstructBuildings {

    static final int MOD = 1000000007;

    public static int TotalWays(int N) {
        long buildingCount = 1;
        long emptySpace = 1;

        int i = 2;
        while (i <= N) {
            long temp = emptySpace;
            emptySpace = (emptySpace + buildingCount) % MOD;
            buildingCount = temp;
            i++;
        }

        return (int) ((buildingCount + emptySpace) * (buildingCount + emptySpace) % MOD);
    }

    public static void main(String[] args) {

    }
}
