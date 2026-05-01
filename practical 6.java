import java.util.Scanner;

public class SearchTest {
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60, 70, 80};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

       // Linear Search
        int pos1 = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                pos1 = i;
                break;
            }
        }

        if (pos1 != -1)
            System.out.println("Linear Search Found at index: " + pos1);
        else
            System.out.println("Linear Search Not Found");

      //Binary Search 
        int low = 0, high = a.length - 1;
        int pos2 = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                pos2 = mid;
                break;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (pos2 != -1)
            System.out.println("Binary Search Found at index: " + pos2);
        else
            System.out.println("Binary Search Not Found");
    }
}
