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
         change_DP(n, d);
         System.out.println("Input a value for n");
      }
   }

   public static int[] change_DP(int n, int[] d) {
      for(int i = 0; i < d.length; i++)
         System.out.println(d[i]);
      return d;
   }
}
