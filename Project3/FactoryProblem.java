//Marine Cossoul (mcossoul@calpoly.edu) Tania Kabiraj (tkabiraj@calpoly.edu)
//Project 3, 5/10/19

import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;

public class FactoryProblem {

  public static void main(String[] args) throws IOException{
      Scanner scan = new Scanner(System.in);
      System.out.println("Input file name");
      String str = scan.nextLine();
      Path filePath = Paths.get(str);
      Scanner scanner = new Scanner(filePath);
      
      int n = scanner.nextInt();
      int e1 = scanner.nextInt();
      int e2 = scanner.nextInt();
      int x1 = scanner.nextInt();
      int x2 = scanner.nextInt();
      

      int[] a1 = new int[n];
      int[] a2 = new int[n];
      int[] t1 = new int[n-1];
      int[] t2 = new int[n-1];
      
      for(int i = 0; i < n; i++)
         a1[i] = scanner.nextInt();
      for(int i = 0; i < n; i++)
         a2[i] = scanner.nextInt();
      for(int i = 0; i < n-1; i++)
         t1[i] = scanner.nextInt();
      for(int i = 0; i < n-1; i++)
         t2[i] = scanner.nextInt();
      
      minRoute(a1, a2, t1, t2, e1, e2, x1, x2);
   } 

   private static void minRoute(int[] a1, int[] a2, int[] t1, int[] t2, int e1, int e2, int x1, int x2) {
      int[] f1 = new int[a1.length];
      int[] l1 = new int[a1.length - 1];
      int[] f2 = new int[a1.length];
      int[] l2 = new int[a1.length - 1];
      
      f1[0] = e1 + a1[0];
      f2[0] = e2 + a2[0];

      for (int i = 1; i < f1.length; i++) {
         if (f1[i-1] + a1[i] < f2[i-1] + t2[i-1] + a1[i]) {
            f1[i] = f1[i-1] + a1[i];
            l1[i-1] = 1;
         }
         else {
            f1[i] =  f2[i-1] + t2[i-1] + a1[i];
            l1[i-1] = 2;
         }

         if (f2[i-1] + a2[i] < f1[i-1] + t1[i-1] + a2[i]) {
            f2[i] = f2[i-1] + a2[i];
            l2[i-1] = 2;
         }
         else {
            f2[i] =  f1[i-1] + t1[i-1] + a2[i]; 
            l2[i-1] = 1;
         }
      }

      if (f1[f1.length-1] + x1 < f2[f1.length-1] + x2) {
         System.out.println("Fastest time is: " + (f1[f1.length-1] + x1));
         System.out.println("\nThe optimal route is: ");
         printRoute(l1, l2, 1, f1.length - 1);
      }
      else {
         System.out.println("Fastest time is: " + (f2[f1.length-1] + x2));
         System.out.println("\nThe optimal route is: ");
         printRoute(l1,l2, 2, f1.length - 1);
      }
   }

   private static void printRoute(int[] l1, int[] l2, int line, int station) {
      if(station > 0) {
         if(line == 1)
            printRoute(l1, l2, l1[station - 1], station - 1);
         else
            printRoute(l1, l2, l2[station - 1], station - 1);
      }
      System.out.println("station " + (station + 1) + ", line " + line);
   }
}
