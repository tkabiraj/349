import java.util.Arrays;

public class TestSorts {

   public static void main(String[] args) {
      Sorts sort = new Sorts();
      
      int[] arr = {5, 4, 3, 2, 1}; 
      int[] arr1 = {10, 6, 9, 11, 14, 12, 14};
      int[] arr2 = {2, 1, 1, 1, 1, 1, 2};
      int[] arr3 = {};
      int[] arr4 = {-5, -3 , 7, -1, 4};
      int[] arr5 = {1, 2, 3, 4, 5, 6};
      /*
      System.out.println("Selection: ");
      sort.selectionSort(arr, arr.length);
      print(arr);
      sort.selectionSort(arr1, arr1.length);
      print(arr1);
      sort.selectionSort(arr2, arr2.length);
      print(arr2);
      sort.selectionSort(arr3, arr3.length);
      print(arr3);
      sort.selectionSort(arr4, arr4.length);
      print(arr4);
      

      System.out.println("Merge: ");
      sort.mergeSort(arr, arr.length);
      print(arr);
      sort.mergeSort(arr1, arr1.length);
      print(arr1);
      sort.mergeSort(arr2, arr2.length);
      print(arr2);
      sort.mergeSort(arr3, arr3.length);
      print(arr3);
      sort.mergeSort(arr4, arr4.length);
      print(arr4);
      */
      
      System.out.println("Quick: ");
      sort.quickSort(arr, arr.length);
      print(arr);
      sort.quickSort(arr1, arr1.length);
      print(arr1);
      sort.quickSort(arr2, arr2.length);
      print(arr2);
      sort.quickSort(arr3, arr3.length);
      print(arr3);
      sort.quickSort(arr4, arr4.length);
      print(arr4);
      sort.quickSort(arr5, arr5.length);
      print(arr5);
     

   }

   private static void print(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}
