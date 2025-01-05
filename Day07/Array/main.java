package Day07.Array;

import java.util.Scanner;

public class Main {
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

    public static int [] moveZeroes(int [] arr){
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] !=0 && arr[j] != 0){
                j++;
            }
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }

    public int [] resize(int [] arr, int n){
        int arr1[] = new int[n];
        for(int i=0; i<arr.length; i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public int findMissingValue(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for(int i=0; i<arr.length; i++){
            sum -= arr[i];
        }
        return sum;
    }

    public boolean isPalendrome(String words){
        char [] arr = words.toCharArray();
        int start = 0;
        int end = words.length() -1;
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner input = new Scanner(System.in);
        String words = input.next();
        System.out.println(obj.isPalendrome(words));
        input.close();
        // int [] arr = {2,4,1,8,6,3,7};

        // int missingValue = obj.findMissingValue(arr);
        // System.out.println(missingValue);

        // moveZeroes(arr);
        // printArr(arr);

        // int []arr1 = obj.resize(arr, 10);
        // printArr(arr1);

        // Scanner input = new Scanner(System.in);
        // Main obj = new Main();
        // int len = input.nextInt();
        // int[] arr = new int[len];
        // for(int i=0; i<arr.length; i++){
        //     arr[i] = input.nextInt();
        // }

        // printArr(arr);

        // int[] result = obj.removeEven(arr);
        // printArr(result);

        // reverseArr(arr, 0, arr.length - 1);
        // printArr(arr);

        // int minimum = obj.min(arr);
        // System.out.println("minimum value " + minimum);

        // int secondMax = obj.secondMax(arr);
        // System.out.println("second maximum value " + secondMax);

        // int maximum = obj.max(arr);
        // System.out.println("maximum value " + maximum);

        // input.close();
    }
}
