package cpclub.weekthree;

public class NumberOfPeopleSecrets {

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        long mod = (long) 1e9 + 7;

        long noPeopleSharingSecret = 0;
        long ans = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long noOfNewPeopleSharing = dp[Math.max(i - delay, 0)];
            long noOfPeopleForgetting = dp[Math.max(i - forget, 0)];
            noPeopleSharingSecret += (noOfNewPeopleSharing - noOfPeopleForgetting + mod) % mod;

            dp[i] = noPeopleSharingSecret;
        }

        for (int i = n - forget + 1; i <= n; i++)
            ans = (ans + dp[i]) % mod;
        return (int) ans;
    }
}
