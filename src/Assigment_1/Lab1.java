package Assigment_1;

public class Lab1{
    public static void bubbleSort(int[] arr){
        boolean finish;
        for(int i=0; i<arr.length-1; i++){
            finish = true;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    finish = false;
                }
            }
            if(finish)break;
        }
    }
}
