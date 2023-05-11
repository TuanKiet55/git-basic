package Assigment_1;

public class Lab6{
    public static int binarySearch(int[] arr, int value, int begin, int end){
        if(begin > end) return -1;
        else{
            int mid = (begin + end) / 2;
            if(value == arr[mid]) return mid;
            else if(value > arr[mid])return binarySearch(arr, value, mid+1, end);
            else return binarySearch(arr, value, begin, mid-1);
        }
    }
}
