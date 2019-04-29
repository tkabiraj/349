//Marine Cossoul(mcossoul@calpoly.edu) Tania Kabiraj(tkabiraj@calpoly.edu)
//csc 349 project 1


import java.lang.Math;

public class SortTimes {

   public static void main(String[] args) {
      long startTime, endTime;
      int N = 160000;
      int[] arr1 = new int[N];
      int[] arr2 = new int[N];
      int[] arr3 = new int[N];
      Sorts sort = new Sorts();

      for(N= 5000; N <= 160000; N*=2) {
         for(int j = 0; j < 5; j++) {
            for (int i = 0; i < N; i++) {
               arr1[i] = (int)(Math.random()*N);
               arr2[i] = arr1[i];
               arr3[i] = arr1[i];
            }
            System.out.print("N = " + N + ": ");
            
            startTime = System.nanoTime();
            sort.selectionSort(arr1,N);
            endTime = System.nanoTime();
            System.out.print("T_ss=" + (int)((endTime - startTime)/1000000) + ", ");
          
            startTime = System.nanoTime();
            sort.mergeSort(arr2,N);
            endTime = System.nanoTime();
            System.out.print("T_ms=" + (int)((endTime - startTime)/1000000) + ", ");
          
            startTime = System.nanoTime();
            sort.quickSort(arr3,N);
            endTime = System.nanoTime();
            System.out.print("T_qs=" + (int)((endTime - startTime)/1000000) + "\n");
         }
         System.out.println();
      }
   }

}
