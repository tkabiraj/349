public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      if (A.length != B.length || A.length != A[0].length || B.length != B[0].length)
            throw new IllegalArgumentException();

      if ((A.length & (A.length-1)) != 0)
            throw new IllegalArgumentException();
   
      return DAC(A, 0, 0, B, 0, 0, A.length);
   }
   
   private static int[][] DAC(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];
      
      if (n == 1)
         C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
      else {
         n /= 2;
         int[][] C11 = addM( DAC(A, startRowA, startColA, B, startRowB, startColB, n),
                             DAC(A, startRowA, startColA + n, B, startRowB + n, startColB, n) );
         int[][] C12 = addM( DAC(A, startRowA, startColA, B, startRowB, startColB + n, n),
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
      int[][] C = new int[A.length][A[0].length];
      
      for (int i = 0; i < C.length; i++) {
         for (int j = 0; j < C.length; j++) {
            C[i][j] = A[i][j] + B[i][j];
         }
      }

      return C;
   }
 
   private static int[][] subM(int[][] A, int[][] B) {
      int[][] C = new int[A.length][B.length];
      
      for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < B.length; j++)
            C[i][j] = A[i][j] - B[i][j];
      }

      return C;
   }
 
   private static int[][] addM(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++)
            C[i][j] = A[startRowA + i][startColA + j] + B[startRowB + i][startColB + j];
      }
      return C;
   }
   
   private static int[][] subM(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++)
            C[i][j] = A[startRowA + i][startColA + j] - B[startRowB + i][startColB + j];
      }
      return C;
   }
   
   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      if (A.length != B.length || A.length != A[0].length || B.length != B[0].length)
         throw new IllegalArgumentException();

      if ((A.length & (A.length-1)) != 0)
         throw new IllegalArgumentException();
      
      return Strassen(A, 0, 0, B, 0, 0, A.length);
   }

   private static int[][] Strassen(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];
      
      if (n == 1)
         C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
      else {
         n /= 2;
         int[][] S1 = subM (B, startRowB, startColB + n, B, startRowB + n, startColB + n, n);
         int[][] S2 = addM (A, startRowA, startColA, A, startRowA, startColA + n, n);
         int[][] S3 = addM (A, startRowA + n, startColA, A, startRowA + n, startRowA + n, n);
         int[][] S4 = subM (B, startRowB + n, startColB, B, startRowB, startRowB, n);
         int[][] S5 = addM (A, startRowA, startColA, A, startRowA + n, startRowA + n, n);
         int[][] S6 = addM (B, startRowB, startColB, B, startRowB + n, startRowB + n, n);
         int[][] S7 = subM (A, startRowA, startColA + n, A, startRowA + n, startRowA + n, n);
         int[][] S8 = addM (B, startRowB + n, startColB, B, startRowB + n, startRowB + n, n);
         int[][] S9 = subM (A, startRowA, startColA, A, startRowA + n, startRowA, n);
         int[][] S10 = addM (B, startRowB, startColB, B, startRowB, startRowB + n, n);

         int[][] P1 = Strassen(A, startRowA, startColA, S1, 0, 0, n);
         int[][] P2 = Strassen(S2, 0, 0, B, startRowB + n, startColB + n, n);
         int[][] P3 = Strassen(S3, 0, 0, B, startRowB, startColB, n);
         int[][] P4 = Strassen(A, startRowA + n, startColA + n, S4, 0, 0, n);
         int[][] P5 = Strassen(S5, 0, 0, S6, 0, 0, n);
         int[][] P6 = Strassen(S7, 0, 0, S8, 0, 0, n);
         int[][] P7 = Strassen(S9, 0, 0, S10, 0, 0, n);

         //int[][] C111 = addM(P5, P4);
         //int[][] C112 = addM(P2, P6);
         //int[][] C11 = subM(C111, C112);
         int[][] C11 = addM (addM(P5, P4), subM(P6, P2));
         int[][] C12 = addM (P1, P2);
         int[][] C21 = addM (P3, P4);
         int[][] C22 = subM (subM (addM(P5, P1), P3), P7);
         
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
}
