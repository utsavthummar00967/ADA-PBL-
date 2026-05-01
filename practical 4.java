import java.util.Random;

public class MergeSort {

    static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
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
