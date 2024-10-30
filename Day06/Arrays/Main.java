package Day06.Arrays;

import java.util.Scanner;

public class Main {
    public void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }

    public int[] removeEven(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
        }
        
        int[] arr1 = new int[count];
        int indx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] %2 != 0){
                arr1[indx] = arr[i];
                indx++;
            }
        }
        return arr1;
    }
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public int minimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public int secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if( max < arr[i]){
                secondMax = max;
                max = arr[i];
            }
            if(secondMax < arr[i] && max != arr[i]){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int maximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if( max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public int[] moveZeroesToEnd(int[] arr){
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != arr[j]  && arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        return arr;
    }

    public int[] resizeArr(int[] arr, int lent){
        int[] arr1 = new int[lent];
        for(int i=0; i<arr.length; i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public int findMissingNum(int[] arr){
        int n = arr.length + 1;
        int sum = n*(n+1)/2;
        for(int i=0;i<arr.length; i++){
            sum = sum-arr[i];
        }
        return sum;
    }

    public boolean isPalendrome(String word){
        char[] arr = word.toCharArray();
        int start = 0;
        int end = arr.length-1;
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
        Scanner input = new Scanner(System.in);
        Main obj = new Main();

        int len = input.nextInt();
        int [] arr = new int[len];

        for(int i=0; i<len; i++){
            arr[i] = input.nextInt();
        }

        obj.display(arr);
        int[] arr1 = obj.removeEven(arr);
        obj.display(arr1);
        reverse(arr, 0, arr.length-1);
        obj.display(arr);

        int min = obj.minimum(arr);
        System.out.println("Minimum element is: " + min);

        int secMax = obj.secondMax(arr);
        System.out.println("Second Maximum element is: " + secMax);

        int max = obj.maximum(arr);
        System.out.println("Maximum element is: " + max);

        System.out.println("move all zeroes:");
        int[] move = obj.moveZeroesToEnd(arr);
        obj.display(move);

        System.out.println("resizing:");
        int[] resize = obj.resizeArr(arr, 10);
        obj.display(resize);

        int missing = obj.findMissingNum(arr);
        System.out.println("Missing element is: " + missing);

        String word = input.next();
        System.out.println(obj.isPalendrome(word));

        input.close();
    }
}
