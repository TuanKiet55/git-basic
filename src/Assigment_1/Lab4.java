package Assigment_1;

public class Lab4 {
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = partition(arr, begin, end);
            quickSort(arr, begin, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int temp = arr[end];
        int count = begin - 1;
        for (int i = begin; i < end; i++) {
            if (arr[i] <= temp) {
                count++;
                int q = arr[count];
                arr[count] = arr[i];
                arr[i] = q;
            }
        }
        int q = arr[count + 1];
        arr[count + 1] = arr[end];
        arr[end] = q;
        return count + 1;
    }
}
