import java.util.Scanner;
import java.io.*;

public class ChangeMaker {
   
   public static void main(String[] args) throws IOException{
      Scanner scanner = new Scanner(System.in);
      System.out.println("Input number of coins and their values in decreasing order");
      int k  = scanner.nextInt();
      int[] d = new int[k];
      for(int i = 0; i < k; i++)
         d[i] = scanner.nextInt();
      System.out.println("Input a value for n");
      int n;
      while((n= scanner.nextInt()) > 0) {
         int[] B = change_DP(n, d);
         printB(B, n, d);
         System.out.println("Input a value for n");
      }
      
   }
   private static void printB(int[] B, int n, int[] d) {
      System.out.println("DP algorithms results");
      System.out.println("Amount: " + n);
      System.out.println("Optimal distribution: ");

      int count = 0;
      int sum = 0;
      for (int i = 0; i < d.length; i++) {
         if (B[i] > 0) {
            sum += B[i] * d[i];
            if (sum == n) {
               System.out.println(B[i] + "*" + d[i] + "c");
               break;
            }
            System.out.print(B[i] + "*" + d[i] + "c + ");
            count += B[i];
         }
      }
      System.out.println("\nOptimal coin count: " + count);
   }
   public static int[] change_DP(int n, int[] d) {
      int[] C = new int[n+1];
      int minCoins;
      int[] A = new int[n+1];
      int[] B = new int[d.length];

      for (int j = 1; j <= n; j++) {
         minCoins = n;
         for (int i = 0; i < d.length; i++) {
            if (d[i] < j) {
               if (C[j-d[i]] < minCoins) {
                  minCoins = C[j-d[i]];
                  A[j] = i;
               }
            }
         }
         if (minCoins != n)
            C[j] = 1 + minCoins;
      }

      for(int k = n; k > 0; k -= d[A[k]]) {
         B[A[k]]++;
      }
       
      return B;
   }
}
