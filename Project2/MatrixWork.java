import java.util.Scanner;
import java.lang.Object;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;
public class MatrixWork {

   public static void main(String[] args) throws IOException{
      Scanner scan = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      Path filePath = Paths.get(str);
      Scanner scanner = new Scanner(filePath);
      
      int[][] A = new int[scanner.nextInt()][scanner.nextInt()];
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < A[0].length; j++) {
            A[i][j] = scanner.nextInt();
         }
      }
      
      int[][] B = new int[scanner.nextInt()][scanner.nextInt()];
      for(int i = 0; i < B.length; i++) {
         for(int j = 0; j < B[0].length; j++) {
            B[i][j] = scanner.nextInt();
         }
      }
     try { 
      int[][] C = matrixProduct(A, B);
      printM(C.length, C[0].length, C);
     }
     catch(IllegalArgumentException e) {
        System.out.println("# of A columns must be equal to # of B rows");
     }
   }

   public static int[][] matrixProduct(int[][] A, int[][] B) {
      if (A[0].length != B.length) {
         throw new IllegalArgumentException();
      }
      int rows = A.length;
      int cols = B[0].length;
      int[][] C = new int[rows][cols];
     
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            for (int k = 0; k < A[0].length; k++) {
               C[i][j] += A[i][k] * B[k][j];
            }
         }
      }
      return C;
   }

   private static void printM(int rows, int cols, int[][] C) {
      System.out.println("\nProduct Matrix:");
      for (int x = 0; x < rows; x++) {
         for (int y = 0; y < cols; y++) {
            System.out.print(C[x][y] + " ");
         }
         System.out.println();
      }
   }
}
