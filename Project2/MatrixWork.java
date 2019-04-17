import java.util.Scanner;

public class MatrixWork {

   public static void main(String[] args) {
      int[][] A = { {1, 2, 3, 10},
                    {4, 5, 6, 14} };
      int[][] B = { {1, 2},
                    {3, 4}, 
                    {5, 6},
                    {10, 14} }; 
      int[][] C = matrixProduct(A, B);
      Scanner in = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      File file = new File(str);

      try {
         int rows, cols;
         
   }

   public static int[][] matrixProduct(int[][] A, int[][] B) {
      if (A[0].length != B.length)
         throw new IllegalArgumentException ("# of A columns must be equal to # of B rows");
      
      int rows = A.length;
      int cols = B[0].length;
      int[][] C = new int[rows][cols];
     
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < rows; j++) {
            for (int k = 0; k < A[0].length; k++) {
               C[i][j] += A[i][k] * B[k][j];
            }
         }
      }
      printM(rows, cols, C);
      return C;
   }

   private static void printM(int rows, int cols, int[][] C) {
      for (int x = 0; x < rows; x++) {
         for (int y = 0; y < cols; y++) {
            System.out.print(C[x][y] + " ");
         }
         System.out.println();
      }
   }
}
