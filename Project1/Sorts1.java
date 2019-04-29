//Marine Cossoul(mcossoul@calpoly.edu) Tania Kabiraj(tkabiraj@calpoly.edu)
//csc 349 project 1

import java.util.Arrays;

public class Sorts1 {
   private static int count = 0;
    public static long selectionSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the selection sort algorithm.
      int minI;
      long comps = 0;
         for (int i = 0; i < N - 1; i++) {
            minI = i;

            for (int j = i+1; j < N; j++) {
               if (arr[j] < arr[minI])
                  minI = j;
               comps++;
            }
   
            int temp = arr[i];
            arr[i] = arr[minI];
            arr[minI] = temp;
         }
         return comps;
   }
    
   public static long mergeSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the merge sort algorithm.
      count = 0;
      sort(arr, 0, N - 1);
      return count;
   }

   private static void sort(int[] arr, int l, int r) {
      if (l < r) {
         int m = (l+r)/2;
         sort(arr, l, m);
         sort(arr, m+1, r);
         merge(arr, l, m, r);
      }
   }

   private static void merge(int[] arr, int l, int m, int r) {
      int index1 = l;
      int index2 = (m+1);
      int index = 0;
      int[] temp = new int[r-l+1];

      while (index1 <= m && index2 <= r) {
         count++;
         if (arr[index1] <= arr[index2])
            temp[index] = arr[index1++];
         else
            temp[index] = arr[index2++];
         index++;
      }

      while (index1 <= m)
         temp[index++] = arr[index1++];
      while (index2 <= r) 
         temp[index++] = arr[index2++];

      for (int z = l; z < temp.length + l; z++)
        arr[z] = temp[z - l];
   }
   
   public static long quickSort (int[] arr, int N) {
       //Sorts the list of N elements contained in arr[0..N-1] using the quick sort algorithm with
       //median-of-three pivot and rearrangement of the three elements (see the handout).
      return quickSort(arr, 0, N-1);
   }

   private static long quickSort(int[] list, int first, int last) {
      long comp = 0;
      if (first < last) {
         comp += setPivotToEnd(list, first, last);
         long[] ret = splitList(list, first, last);
         int pivotIndex = (int)ret[0];
         comp += ret[1];
         comp += quickSort(list, first, pivotIndex-1);
         comp += quickSort(list, pivotIndex+1, last);
      }
      return comp;
   }

   private static long setPivotToEnd(int[] list, int first, int last) {
      int middle = (last+first)/2;
      int temp;
      
      if (list[first] > list[middle]) {
         temp = list[first];
         list[first] = list[middle];
         list[middle] = temp;
      }
      if (list[first] > list[last]) {
         temp = list[first];
         list[first] = list[last];
         list[last] = temp;
      }

      if (list[last] > list[middle]) {
         temp = list[last];
         list[last] = list[middle];
         list[middle] = temp;
      }
      return 3;
   }

   private static long[] splitList(int[] list, int first, int last) {
      int indexL = first;
      int indexR = last - 1;
      int pivot = last;
      int temp;
      long comp = 0;
      while (indexL <= indexR) {
         comp++;
         while (list[indexL] < list[pivot]) {
            indexL++;
            comp++;
         }
         while (indexL <= indexR && list[indexR] > list[pivot]) {
            indexR--;
            comp++;
         }
         if (indexL <= indexR) {
            comp++;
            temp = list[indexL];
            list[indexL++] = list[indexR];
            list[indexR--] = temp;
         }
      }
      temp = list[indexL];
      list[indexL] = list[pivot];
      list[pivot] = temp;
      long ret[] = {indexL, comp};
      return ret;
  }
   
}
