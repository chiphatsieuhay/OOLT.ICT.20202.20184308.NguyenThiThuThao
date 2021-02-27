import java.util.Scanner;
import java.util.Arrays;
public class Matrix{
    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many row in the matrix?");
        int row = keyboard.nextInt();
        System.out.print("How many column in the matrix:");
        int column = keyboard.nextInt();
        int arr[][] = new int[row][column];
        int arr1[][] = new int[row][column];
        System.out.println("Enter matrix A:");
        for (int i = 0; i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter matrix B:");
        for (int i = 0; i<row;i++){
            for(int j=0;j<column;j++){
                arr1[i][j] = keyboard.nextInt();
            }
        }
         for (int i = 0; i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(arr[i][j]+arr1[i][j]+"\t");
            }
            System.out.println();
        }
    }
}