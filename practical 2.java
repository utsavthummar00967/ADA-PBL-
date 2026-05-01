import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        int n = 10000;
        int[] a = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        long end = System.nanoTime();

        double time = (end - start) / 1e6;

        System.out.println("Size: " + n);
        System.out.println("Time: " + time + " ms");

        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
