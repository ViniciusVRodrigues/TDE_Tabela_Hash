package sorting;

public class BubbleSort extends AbstractSort{
    protected void sortArray(int[] arr) {
        this.bubbleSort(arr, arr.length);
    }

    private void bubbleSort(int[] arr, int currentLength) {
        if (currentLength == 1) {
            return;
        }
        for (int i = 0; i < currentLength - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                this.swap(arr, i, i + 1);
            }
        }
        bubbleSort(arr, currentLength - 1);
    }

}
