import java.util.Random;

// This Java program demonstrates the Randomized Select algorithm, which efficiently finds the ith smallest element in an array.

public class RandomizedSelect {

    public static void main(String[] args) {
        // Sample array
        int[] inputArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        // Find the 6th smallest element
        int targetPosition = 7;
        int result = randomizedSelect(inputArray, 0, inputArray.length - 1, targetPosition);

        // Print the result
        System.out.println("The " + targetPosition + "th smallest element is: " + result);
    }

    // Randomized Select algorithm
    public static int randomizedSelect(int[] arr, int startIndex, int endIndex, int targetPosition) {
        // Base case: If there's only one element
        if (startIndex == endIndex) {
            return arr[startIndex];
        }

        // Randomized Partition: Choose a random pivot and partition the array
        int pivotIndex = randomizedPartition(arr, startIndex, endIndex);

        // Calculate the position of the pivot
        int pivotRelativePosition = pivotIndex - startIndex + 1;

        // Compare the position of the pivot with the desired position
        if (targetPosition == pivotRelativePosition) {
            return arr[pivotIndex]; // The pivot is the ith smallest element
        } else if (targetPosition < pivotRelativePosition) {
            return randomizedSelect(arr, startIndex, pivotIndex - 1, targetPosition); // Recursively search in the left subarray
        } else {
            return randomizedSelect(arr, pivotIndex + 1, endIndex, targetPosition - pivotRelativePosition); // Recursively search in the right subarray
        }
    }

    // Randomized Partition: Randomly choose a pivot index and swap with the last element
    public static int randomizedPartition(int[] arr, int startIndex, int endIndex) {
        int randomIndex = new Random().nextInt(endIndex - startIndex + 1) + startIndex; // Random pivot index
        swap(arr, randomIndex, endIndex); // Swap the pivot with the last element

        return partition(arr, startIndex, endIndex); // Call the regular partition function
    }

    // Partition the array around a pivot
    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex]; // Choose the last element as the pivot
        int i = startIndex - 1; // Index of smaller element

        // Traverse the array and rearrange elements around the pivot
        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot to its correct position
        swap(arr, i + 1, endIndex);

        return i + 1; // Return the index of the pivot
    }

    // Swap two elements in the array
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
