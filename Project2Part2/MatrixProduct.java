

public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      try{
         if(A.length != B.length || A.length != A[0].length || B.length != B[0].length)
            throw new IllegalArgumentException;

      }
      int[][] C = new int[A.length][B.length];
      return C;
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      int[][] C = new int[A.length][B.length];
      return C;
   }
}
