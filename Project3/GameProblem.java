//Marine Cossoul (mcossoul@calpoly.edu) Tania Kabiraj (tkabiraj@calpoly.edu)
//Project 3, 5/10/19

import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;

public class GameProblem {

   public static void main(String[] args) throws IOException{
      Scanner scan = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      Path filePath = Paths.get(str);
      Scanner scanner = new Scanner(filePath);
      
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int[][] A = new int[n][m];
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < A[0].length; j++)
            A[i][j] = scanner.nextInt();
      }
      game(n, m, A);
   }

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n+1][m+1];
      char[][] R = new char[n+1][m+1];
      int maxSum = A[n-1][m-1], maxI = n-1, maxJ = m-1;

      for(int i = S.length - 2; i >= 0; i --) {
         for(int j = S[0].length - 2; j >= 0; j--) {
            if(S[i + 1][j] >= S[i][j + 1]) {
               S[i][j] = A[i][j] + S[i + 1][j];
               R[i][j] = 'd';
            }else{
               S[i][j] = A[i][j] + S[i][j + 1];
               R[i][j] = 'r';
            }
            if(S[i][j] > maxSum) {
               maxSum = S[i][j];
               maxI = i;
               maxJ = j;
            }
         }
      }
      System.out.println("Best score: " + maxSum);
      System.out.print("Best route: ");
      printRoute(R, maxI, maxJ);
   }

   private static void printRoute(char[][] R, int i, int j) {
      if(i == R.length - 1 || j == R[0].length - 1)
         System.out.println("exit");
      else {
         System.out.print("[" + (i + 1) + "," + (j + 1) + "] to ");
         if(R[i][j] == 'r')
            printRoute(R, i, j + 1);
         else
            printRoute(R, i + 1, j);
      }
   }
}
