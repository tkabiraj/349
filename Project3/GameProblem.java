public class GameProblem {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      Path filePath = Paths.get(str);
      Scanner scanner = new Scanner(filePath);
      
      n = scanner.nextInt();
      m = scanner.nextInt();
      int[][] A = new int[n][m];
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < A[0].length; j++)
            A[i][j] = scanner.nextInt();
      }
      int[][] C = game(n, m, A);
   }

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n-1][m-1];

   }
}
