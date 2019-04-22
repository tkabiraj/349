public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      if (A.length != B.length || A.length != A[0].length || B.length != B[0].length)
            throw new IllegalArgumentException();

      if ((A.length & (A.length-1)) != 0)
            throw new IllegalArgumentException();
   
      return DAC(A, 0, 0, B, 0, 0, A.length);
   }
   
   private static int[][] DAC(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[A.length][B.length];
      
      if (n == 1)
         C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
      else {
         n /= 2;
         int[][] C11 = addM( DAC(A, startRowA, startColA, B, startRowB, startColB, n),
                             DAC(A, startRowA, startColA + n, B, startRowB + n, startColB, n) );
         int[][] C12 = addM( DAC(A, startRowA, startColA, B, startRowB, startColA + n, n),
                             DAC(A, startRowA, startColA + n, B, startRowB + n, startColB + n, n) );
         int[][] C21 = addM( DAC(A, startRowA + n, startColA, B, startRowB, startColB, n),
                             DAC(A, startRowA + n, startColA + n, B, startRowB + n, startColB, n) );
         int[][] C22 = addM( DAC(A, startRowA + n, startColA, B, startRowB, startColB + n, n),
                             DAC(A, startRowA + n, startColA + n, B, startRowB + n, startColB + n, n) );
  
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               C[i][j] = C11[i][j];
               C[i][j + n] = C12[i][j];
               C[i + n][j] = C21[i][j];
               C[i + n][j + n] = C22[i][j];
            }
         }

      }
      return C;
   }

   private static int[][] addM(int[][] A, int[][] B) {
      int[][] C = new int[A.length][B.length];
      
      for (int i = 0; i < A.length; i++)
         for (int j = 0; j < B.length; j++)
            C[i][j] = A[i][j] + B[i][j];

       return C;
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      if (A.length != B.length || A.length != A[0].length || B.length != B[0].length)
         throw new IllegalArgumentException();

      if ((A.length & (A.length-1)) != 0)
         throw new IllegalArgumentException();
      
      int[][] C = new int[A.length][B.length];
      return C;
   }
}
