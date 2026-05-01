import java.util.Random;

public class QuickSort {

    static int part(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[i + 1];
        a[i + 1] = a[high];
        a[high] = t;

        return i + 1;
    }

    static void sort(int[] a, int low, int high) {
        if (low < high) {
            int p = part(a, low, high);
            sort(a, low, p - 1);
            sort(a, p + 1, high);
        }
    }

    public static void main(String[] args) {

        int n = 10000;
        int[] a = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100000);
        }

        long start = System.nanoTime();

        sort(a, 0, n - 1);

        long end = System.nanoTime();

        double time = (end - start) / 1e6;

        System.out.println("Size: " + n);
        System.out.println("Time: " + time + " ms");

        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
