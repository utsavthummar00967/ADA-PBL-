public class PrimTest {
    public static void main(String[] args) {

        int n = 5;

        int[][] g = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        boolean[] v = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            key[i] = 9999;
            v[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {

            int min = 9999;
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!v[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            v[u] = true;

            for (int j = 0; j < n; j++) {
                if (g[u][j] != 0 && !v[j] && g[u][j] < key[j]) {
                    parent[j] = u;
                    key[j] = g[u][j];
                }
            }
        }

        int total = 0;

        System.out.println("Edge   Weight");

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "    " + g[i][parent[i]]);
            total += g[i][parent[i]];
        }

        System.out.println("Total cost: " + total);
    }
}
