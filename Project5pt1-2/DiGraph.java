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
      System.out.println("The graph is the following: ");
      for (int i = 0; i < lists.length; i++) {
         System.out.print((i + 1) + " is connected to: " );
         for (int j = 0; j < lists[i].size() - 1; j++) 
            System.out.print(lists[i].get(j) + ", ");
         if (lists[i].size() > 0)
            System.out.print(lists[i].get(lists[i].size() - 1));
      System.out.println();
      }
   }

   private static int[] indegrees() {
      int[] indegree = new int[lists.length];
      for (int i = 0; i < lists.length; i++) {
         for (int j = 0; j < lists[i].size(); j++)
            indegree[lists[i].get(j) - 1]++;
      }
      return indegree;
   }

   public static int[] topSort() {
      int[] indegree = indegrees();
      LinkedList<Integer> Q = new LinkedList<>();
      int[] A = new int[lists.length];
      int temp;

      for (int i = 0; i < indegree.length; i++) {
         if (indegree[i] == 0)
            Q.addLast(i + 1);
      }

      int i = 0;
     
      while(Q.size() != 0) {
         int u = Q.removeFirst();
         A[i] = u;
         i++;
         for(int j = 0; j < lists[u-1].size(); j++) {
            indegree[lists[u-1].get(j) - 1] = indegree[lists[u-1].get(j) - 1] - 1;
            temp = indegree[lists[u-1].get(j) - 1];
            if(temp == 0) {
               Q.addLast(lists[u-1].get(j));
            }
         }
      }
      if (i < lists.length)
         throw new IllegalArgumentException();
      return A;
   }
}
