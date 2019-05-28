import java.util.LinkedList;

public class DiGraph {
   private static LinkedList<Integer>[] lists;

   public DiGraph(int N) {
      lists = new LinkedList[N];
      for (int i = 0; i < lists.length; i++) 
         lists[i] = new LinkedList<Integer>();
   }

   public static void addEdge(int from, int to) {
      if (!lists[from - 1].contains(to))
         lists[from - 1].add(to);
   }

   public static void deleteEdge(int from, int to) {
      if (lists[from - 1].contains(to)) {
         for (int i = 0; i < lists[from -1].size(); i++) {
            if (lists[from -1].get(i) == to)
               lists[from - 1].remove(i);
         }
      }
   }

   public static int edgeCount() {
      int count = 0;
      
      for (int i = 0; i < lists.length; i++)
         count += lists[i].size();

      return count;
   }

   public static int vertexCount() {
      return lists.length;
   }

   public static void print() {
      for (int i = 0; i < lists.length; i++) {
         System.out.print((i + 1) + " is connected to: " );
         for (int j = 0; j < lists[i].size() - 1; j++) 
            System.out.print(lists[i].get(j) + ", ");
         if (lists[i].size() > 0)
            System.out.print(lists[i].get(lists[i].size() - 1));
      System.out.println();
      }
   }

   private int[] indegrees() {
      int[] indegree = new int[lists.length];
      for (int i = 0; i < lists.length; i++) {
         for (int j = 0; j < list[i].size(); j++)
            indegree[lists[i].get(j) - 1]++;
      }
      return indegree;
   }

   public static int[] topSort() {
      
   }
}
