import java.util.Random;

public class RandomizedSelect {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        int i = 6; // Find the 6th smallest element
        int result = randomizedSelect(arr, 0, arr.length - 1, i);

        System.out.println("The " + i + "th smallest element is: " + result);
    }

    public static int randomizedSelect(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }

        // Randomized Partition
        int q = randomizedPartition(arr, p, r);

        // Calculate the position of the pivot
        int k = q - p + 1;

        if (i == k) {
            return arr[q];
        } else if (i < k) {
            return randomizedSelect(arr, p, q - 1, i);
        } else {
            return randomizedSelect(arr, q + 1, r, i - k);
        }
    }

    public static int randomizedPartition(int[] arr, int p, int r) {
        // Randomly choose a pivot index and swap with the last element
        int randomIndex = new Random().nextInt(r - p + 1) + p;
        swap(arr, randomIndex, r);

        return partition(arr, p, r);
    }

    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap pivot to its correct position
        swap(arr, i + 1, r);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
