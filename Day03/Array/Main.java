package Day03.Array;

import java.util.Scanner;

public class Main {
    public void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] removeEven(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] %2 != 0){
                count++;
            }
        }
        int index = 0;
        int[] newArr = new int[count];
        for(int i=0; i<arr.length; i++){
            if(arr[i] %2 != 0){
                newArr[index] = arr[i];
                index++;
            }
        }
        return newArr;
    }

    public int[] reverseArr(int[] arr){
        int start = 0;
        int end = arr.length-1;
        for(int i=0; i<arr.length; i++){
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return arr;
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
        System.out.println("Enter the length of array");
        int len = input.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter the elements of the array");
        for(int i=0; i<len; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Printing the array: ");
        obj.display(arr);

        // System.out.println("Printing after removin even integers5");
        // int[] even = obj.removeEven(arr);
        // obj.display(even);

        // System.out.println("Revrsed array is:");

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
