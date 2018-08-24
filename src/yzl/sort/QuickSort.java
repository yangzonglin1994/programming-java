package yzl.sort;

public class QuickSort {
    public static double[] sort(double[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    private static void sort(double[] arr, int low, int high) {
        if (low >= high) return;
        int j = partition(arr, low, high);
        sort(arr, low, j-1);
        sort(arr, j+1, high);
    }

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[low];
        int i = low;
        int j = high+1;
        while (true) {
            while (arr[++i] < pivot) {
                // Avoid array out of bounds.
                if (i == high) break;
            }
            while (pivot < arr[--j])
                if (j == low) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        arr = QuickSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
