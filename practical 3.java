import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {

        int n = 10000;
        int[] a = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
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
