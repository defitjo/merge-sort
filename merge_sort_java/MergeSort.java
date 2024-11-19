import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 9, 10, 8, 3, 7, 2, 6, 4 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr_alt) {
        if (arr_alt.length > 1) {
            int mid = arr_alt.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr_alt.length - mid];

            System.arraycopy(arr_alt, 0, left, 0, mid);
            System.arraycopy(arr_alt, mid, right, 0, arr_alt.length - mid);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr_alt[k] = left[i];
                    i += 1;
                } else {
                    arr_alt[k] = right[j];
                    j += 1;
                }
                k += 1;
            }

            while (i < left.length) {
                arr_alt[k] = left[i];
                i += 1;
                k += 1;
            }

            while (j < right.length) {
                arr_alt[k] = right[j];
                j += 1;
                k += 1;
            }
        }
    }
}