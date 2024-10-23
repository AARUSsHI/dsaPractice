package Day01.Array.Project01;
import java.util.Scanner;
public class Main {
    public int element(int[] arr){
        int n = arr.length + 1;
        int sum = n*(n+1)/2;
        for(int i=0; i<arr.length; i++){
            sum -= arr[i];
        }
        return sum;
    }

    public int[] resizeArr(int[] arr,int len){
        int[] resizedArr = new int[len];
        for(int i=0; i<arr.length; i++){
            resizedArr[i] = arr[i];
        }
        return resizedArr;
    }

    public int[] moveZeros(int[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0 && arr[j] == 0){
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

    public int maximum(int[] arr){
        if(arr.length == 0 || arr == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public int secondMax(int[] arr){
        if(arr.length == 0 || arr == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i]){
                secondMax = max;
                max = arr[i];
            }
            if(secondMax <= arr[i] && max != arr[i]){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int minimum(int[] arr){
        if(arr.length == 0 || arr == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public int[] removeEven(int[] arr){
        int count = 0;
        for(int i=0 ;i<arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
        }
        int[] newArr = new int[count];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                newArr[idx] = arr[i];
                idx++;
            }
        }
        return newArr;
    }

    public void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int len = input.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i<len; i++){
            arr[i] = input.nextInt();
        }
        Main obj = new Main();
        System.out.println("Printing the array");
        obj.printArr(arr);

        int[] removeEven = obj.removeEven(arr);
        System.out.println("Array after removing even elements");
        obj.printArr(removeEven);

        System.out.println("Revrsed array is");
        int[] reverse = obj.reverseArray(arr);
        obj.printArr(reverse);

        System.out.println("Minimum value in array");
        int min = obj.minimum(arr);
        System.out.println(min);

        System.out.println("Second Maximum value in array");
        int secondMax = obj.secondMax(arr);
        System.out.println(secondMax);

        System.out.println("Maximum value in array");
        int max = obj.maximum(arr);
        System.out.println(max);

        System.out.println("move all zeroes in an array to the end of the array");
        int[] move = obj.moveZeros(arr);
        obj.printArr(move);

        System.out.println("resized array");
        int[] resize = obj.resizeArr(arr,10);
        obj.printArr(resize);

        System.out.println("Missing value in array");
        int missing = obj.element(arr);
        System.out.println(missing);
        input.close();
    }
}
