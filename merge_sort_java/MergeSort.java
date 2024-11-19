import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 9, 10, 8, 3, 7, 2, 6, 4 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k] = left[i];
                    i += 1;
                } else {
                    arr[k] = right[j];
                    j += 1;
                }
                k += 1;
            }

            while (i < left.length) {
                arr[k] = left[i];
                i += 1;
                k += 1;
            }

            while (j < right.length) {
                arr[k] = right[j];
                j += 1;
                k += 1;
            }
        }
    }
}