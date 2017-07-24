import java.util.*;

public class Algorithm_HeapSort { // O(nlog(n))
    public static void heapSort(int[] arr) {
        // build heap
        buildHeap(arr); // O(n)

        for (int i = arr.length - 1; i >= 0; i--) { // O(n)
            swap(arr, 0, i);
            heapify(arr, i, 0); // O(log(n))
        }
    }
    public static void buildHeap(int[] arr) {
        // arr.length / 2 is the first node which is not leaf node
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }
    public static void heapify(int[] arr, int size, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, size, largest);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        /*
        // 这种交换有一个致命bug，就是当交换双方指向同一个内存地址时，会出错变成0
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
        */
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,8,1,9,2,5,4,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
