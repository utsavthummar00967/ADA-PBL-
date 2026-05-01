import java.util.Scanner;

public class KnapTest {
    public static void main(String[] args) {

        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        int n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    int a = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    int b = dp[i - 1][w];
                    dp[i][w] = Math.max(a, b);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum value: " + dp[n][W]);
    }
}
