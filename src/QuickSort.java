import java.util.Arrays;

public class QuickSort {

    public static void sort(double[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(double[] arr, int from, int to) {
        if (to - from > 1) {
            int pivotIndex = setPivot(arr, from, to);
            sort(arr, from, pivotIndex);
            sort(arr, pivotIndex + 1, to);
        }
    }

    public static int setPivot(double[] arr, int from, int to) {
        double pivot = arr[to - 1];
        int smallerIndex = from;
        for (int i = from; i < to; ++i) {
            if (arr[i] <= pivot) {
                swap(arr, smallerIndex, i);
                smallerIndex += 1;
            }
        }
        return smallerIndex - 1; //index of pivot
    }

    static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void test(double[] arr) {
        double[] expected = arr.clone();
        double[] tmp = arr.clone();
        Arrays.sort(expected);
        sort(arr);
        if (!Arrays.equals(expected, arr)) {
            throw new IllegalArgumentException("Got: " + Arrays.toString(arr) + " for: " + Arrays.toString(tmp));
        }
    }

    public static void main(String[] args) {
        test(new double[]{});
        test(new double[]{5, 4, 3, 2, 1});
        test(new double[]{1, 2, 3, 4, 5});
        test(new double[]{1, 2, 3, 4, 3, 2, 1});
        test(new double[]{1, 1, 1, 1, 1});
        test(new double[]{2, 1, 1, 1, 1});
    }
}
