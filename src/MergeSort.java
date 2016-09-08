import java.util.Arrays;

public class MergeSort {

    static void sort(double[] arr) {
        sort(arr, new double[arr.length], 0, arr.length);
    }

    static void sort(double[] arr, double[] tmp, int from, int to) {
        if (to - from > 1) {
            int mid = (from + to) / 2;
            sort(arr, tmp, from, mid);
            sort(arr, tmp, mid, to);
            int l = from;
            int r = mid;
            for (int i = from; i < to; ++i) {
                if (l < mid && (r >= to || arr[l] <= arr[r])) {
                    tmp[i] = arr[l];
                    l += 1;
                } else {
                    tmp[i] = arr[r];
                    r += 1;
                }
            }
            System.arraycopy(tmp, from, arr, from, to - from);
        }
    }

    static void test(double[] arr) {
        double[] cpy = arr.clone();
        double[] cpy2 = arr.clone();
        sort(arr);
        Arrays.sort(cpy);
        if (!Arrays.equals(arr, cpy)) {
            throw new IllegalStateException("Sort is broken: " + Arrays.toString(cpy2) + " result: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        test(new double[]{5, 4, 3, 3, 7, 1});
        test(new double[]{1, 2, 3, 4, 5});
        test(new double[]{5, 4, 3, 2, 1});
        test(new double[]{1, 1, 1, 1, 1, 1});
        test(new double[]{});
        test(new double[]{1});
        test(new double[]{5, 4, 2, 4, 5});
    }
}
