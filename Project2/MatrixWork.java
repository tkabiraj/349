public class MatrixWork {

   public static void main(String[] args) {

   }

   public static int[][] matrixProduct(int[][] A, int[][] B) {
      if (A[0].length != B.length)
         throw new IllegalArgumentException ("# of A columns must be equal to # of B rows");
      
      int rows = A.length;
      int cols = B[0].length;
      int[][] C = new int[rows][cols];
      
      for (int i = 0; i < rows; i++) {
         for (int j = 0; i < cols; j++) {
            
         }
      }
   }

}
