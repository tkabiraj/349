import java.util.*;

public class DiGraphTest {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Input number of vertices");
      int vertices  = scanner.nextInt();
      int n, from, to;

      DiGraph graph = new DiGraph(vertices);
      System.out.println("\nChoose one of the following operations:");
      System.out.println("-add edge (enter a)");
      System.out.println("-delete edge (enter d)");
      System.out.println("-edge count (enter e)");
      System.out.println("-vertex count (enter v)");
      System.out.println("-print graph (enter p)");
      System.out.println("-print topological sort (enter t)");
      System.out.println("-Quit (enter q)");
      System.out.println();

      while((n = scanner.next().charAt(0)) != 'q') {
         switch (n) {
            case 'a':
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.addEdge(from, to);
               System.out.println("Edge (" + from + ", " + to + ") successfully added");
               break;
            case 'd':
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.deleteEdge(from, to);
               System.out.println("Edge (" + from + ", " + to + ") successfully removed");
               break;
            case 'e':
               System.out.println("Number of edges: " + graph.edgeCount());
               break;
            case 'v':
               System.out.println("Number of vertices: " + graph.vertexCount());
               break;
            case 'p':
               System.out.println();
               graph.print();
               break;
            case 't':
               System.out.print("Topological Sort: ");
               int[] A = graph.topSort();
               for(int i = 0; i < A.length - 1; i++) 
                  System.out.print(A[i] + ", ");
               System.out.println(A[A.length - 1]);
               break;
            default:
               System.out.println("Must be a valid operation");
               break;
         }
         System.out.println("\nChoose an operation");
      }
   System.out.println("Good bye.");
   }
}
