package sorting;

public class QuickSort extends AbstractSort {
    protected void sortArray(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = this.partition(arr, low, high);
            this.quickSort(arr, low, pi - 1);
            this.quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                this.swap(arr, i, j);
            }
        }
        this.swap(arr, i + 1, high);
        return i + 1;
    }
}
