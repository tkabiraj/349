import java.util.Scanner;
import java.lang.Object;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;
public class runProducts {

   public static void main(String[] args) throws IOException{
      Scanner scan = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      Path filePath = Paths.get(str);
      Scanner scanner = new Scanner(filePath);
      //MatrixProduct matrix = new MatrixProduct();
      
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
         int[][] C = MatrixProduct.matrixProduct_DAC(A, B);
         printM(C.length, C[0].length, C);
     }
     catch(IllegalArgumentException e) {
        System.out.println("Does not satisfy input conditions.");
     }
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
