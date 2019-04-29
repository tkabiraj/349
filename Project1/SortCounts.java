//Marine Cossoul(mcossoul@calpoly.edu) Tania Kabiraj( tkabiraj@calpoly.edu)
//csc 349 project 1

import java.lang.Math;

public class SortCounts {

   public static void main(String[] args) {
      int startTime, endTime;
      int N = 12800;
      int[] arr1 = new int[N];
      int[] arr2 = new int[N];
      int[] arr3 = new int[N];
      long T1, T2, T3;
      
      for(N= 100; N <= 12800; N*=2) {
         T1 = 0;
         T2 = 0;
         T3 = 0;
         for(int j = 0; j < 100; j++) {
            for (int i = 0; i < N; i++) {
               arr1[i] = (int)(Math.random()*N);
               arr2[i] = arr1[i];
               arr3[i] = arr1[i];
            }
            
            T1 += Sorts1.selectionSort(arr1,N);

            T2 += Sorts1.mergeSort(arr2,N);

            T3 += Sorts1.quickSort(arr3,N);
         }
         System.out.println("N=" + N + ": C_ss=" + T1/100 + ", C_ms=" + T2/100 + ", C_qs=" + T3/100);
      }
   }

}
