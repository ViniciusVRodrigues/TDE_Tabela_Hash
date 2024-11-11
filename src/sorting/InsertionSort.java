package sorting;

public class InsertionSort extends AbstractSort {
    protected void sortArray(int[] arr) {
        int totalNumbers = arr.length;
        int sortedNumbers = 0;
        while (sortedNumbers < totalNumbers) {
            for(int i = 0; i < (totalNumbers - sortedNumbers); i++) {
                if (i > 0 && arr[i] < arr[i - 1]) {
                    this.swap(arr, i, i - 1);
                }
            }
            sortedNumbers++;
        }
    }
}
