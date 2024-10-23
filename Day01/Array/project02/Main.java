package Day01.Array.project02;
import java.util.Scanner;

public class Main {
    public boolean isPalindrome(String words){
        char[] arr = words.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main obj = new Main();

        String words = input.next();
        System.out.println(obj.isPalindrome(words));
        input.close();
    }
}
