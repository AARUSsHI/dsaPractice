package Day07.Array;

import java.util.Scanner;

public class main {
    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] removeEven(int[] arr){
        int count = 0;
        int indx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 != 0){
                count++;
            }
        }

        int[] arr1 = new int[count];

        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 != 0){
                arr1[indx] = arr[i];
                indx++;
            }
        }
        return arr1;
    }

    public static void reverseArr(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public int secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(max < arr[i]){
                secondMax =  max;
                max = arr[i];
            }
            else if(secondMax < arr[i] & max != arr[i]){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max  < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        main obj = new main();
        int len = input.nextInt();
        int[] arr = new int[len];
        for(int i=0; i<arr.length; i++){
            arr[i] = input.nextInt();
        }

        printArr(arr);

        int[] result = obj.removeEven(arr);
        printArr(result);

        reverseArr(arr, 0, arr.length - 1);
        printArr(arr);

        int minimum = obj.min(arr);
        System.out.println("minimum value" + minimum);

        int secondMax = obj.secondMax(arr);
        System.out.println("second maximum value" + secondMax);

        int maximum = obj.max(arr);
        System.out.println("maximum value" + maximum);

        input.close();
    }
}
