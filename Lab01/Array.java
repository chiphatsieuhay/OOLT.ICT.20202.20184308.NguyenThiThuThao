import java.util.Scanner;
import java.util.Arrays;
public class Array{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n;
        double sum=0;
        System.out.print("Enter size of your array:");
        n = keyboard.nextInt();
        while(n<=0) {
            System.out.print("Reenter size of your array.Cause n must be greater than 0:");
            n = keyboard.nextInt();
        }
        double arr[] = new double[n];
        for (int i=0;i<n;i++){
            System.out.print("arr[:"+i+"]:");
            arr[i] = keyboard.nextInt();
            sum=sum+arr[i];
        }
        Arrays.sort(arr);
        System.out.println("Modified arr[] : "+ Arrays.toString(arr));
        System.out.println("Sum of this array is : "+ sum);
        
        System.out.println("Average of array is : "+ sum/n);
    }
}