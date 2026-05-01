import java.util.Arrays;

public class KruskalTest {

    static int find(int[] parent, int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    static void union(int[] parent, int x, int y) {
        int a = find(parent, x);
        int b = find(parent, y);
        parent[a] = b;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        int i = 0;
        int total = 0;

        System.out.println("Edge   Weight");

        while (count < n - 1) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int x = find(parent, u);
            int y = find(parent, v);

            if (x != y) {
                System.out.println(u + " - " + v + "    " + w);
                total += w;
                union(parent, x, y);
                count++;
            }
            i++;
        }

        System.out.println("Total cost: " + total);
    }
}
