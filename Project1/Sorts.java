//Marine Cossoul(mcossoul@calpoly.edu) Tania Kabiraj(tkabiraj@calpoly.edu)
//csc 349 project 1

import java.util.Arrays;

public class Sorts {

    public static void selectionSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the selection sort algorithm.
      int minI;
         for (int i = 0; i < N - 1; i++) {
            minI = i;

            for (int j = i+1; j < N; j++) {
               if (arr[j] < arr[minI])
                  minI = j;
            }
   
            int temp = arr[i];
            arr[i] = arr[minI];
            arr[minI] = temp;
         }
   }
    
   public static void mergeSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the merge sort algorithm.
      sort(arr, 0, N - 1);
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
   
   public static void quickSort (int[] arr, int N) {
       //Sorts the list of N elements contained in arr[0..N-1] using the quick sort algorithm with
       //median-of-three pivot and rearrangement of the three elements (see the handout).
      quickSort(arr, 0, N-1);
   }

   private static void quickSort(int[] list, int first, int last) {
      if (first < last) {
         setPivotToEnd(list, first, last);
         int pivotIndex = splitList(list, first, last);
         quickSort(list, first, pivotIndex-1);
         quickSort(list, pivotIndex+1, last);
      }
   }

   private static void setPivotToEnd(int[] list, int first, int last) {
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
   }

   private static int splitList(int[] list, int first, int last) {
      int indexL = first;
      int indexR = last - 1;
      int pivot = last;
      int temp;

      while (indexL <= indexR) {
         while (list[indexL] < list[pivot])
            indexL++;
         while (indexL <= indexR && list[indexR] > list[pivot])
            indexR--;
         if (indexL <= indexR) {
            temp = list[indexL];
            list[indexL] = list[indexR];
            list[indexR] = temp;
            indexL++;
            indexR--;
         }
      }
      temp = list[indexL];
      list[indexL] = list[pivot];
      list[pivot] = temp;
      return indexL;
  }
   
}
