import java.util.*;

public class Algorithm_QuickSort_QuickSelect {
    
    // quicksort
    // Time : O(nlogn)
    // Space : O(1)
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }
    public static void quicksort(int[] arr, int low, int high) {
       if (low < high) {
           int pivot = partition(arr, low, high);
           quicksort(arr, low, pivot - 1);
           quicksort(arr, pivot + 1, high);
       }
    }

    // quickselect
    // Time : Worst O(n^2) -> Shuffle -> Average O(n)
    // Space : O(1)
    public static int quickselect(int[] arr, int k) {
        k = arr.length - k;
        return quickselect(arr, k, 0, arr.length - 1);
    }
    public static int quickselect(int[] arr, int k, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            if (pivot < k) {
                return quickselect(arr, k, pivot + 1, high);
            } else if (pivot > k) {
                return quickselect(arr, k, low, pivot - 1);
            }
        }
        return arr[k];
    }

    public static int partition(int[] arr, int low, int high) {
       int pivot = arr[high];
       int i = low - 1;
       for (int j = low; j < high; j++) {
           if (arr[j] < pivot) {
               swap(arr, ++i, j);
           }
       }
       swap(arr, ++i, high);
       return i;
    }
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        int[] arr1 = {30,20,10,50,60,40};
        quicksort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {30,20,10,50,60,40};
        System.out.println(quickselect(arr2, 6));
    }
}