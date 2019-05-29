import java.util.*;

public class DiGraphTest {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Input number of vertices");
      int vertices  = scanner.nextInt();
      int n, from, to;
      String N;

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

      N = scanner.nextLine();
      while (scanner.hasNext()) {
         N = scanner.nextLine();
         if (N.charAt(0) == 'q')
            break;
         switch (N) {
            case "a":
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.addEdge(from, to);
               System.out.println("Edge (" + from + ", " + to + ") successfully added");
               N = scanner.nextLine(); 
               break;
            case "d":
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.deleteEdge(from, to);
               System.out.println("Edge (" + from + ", " + to + ") successfully removed");
               N = scanner.nextLine();
               break;
            case "e":
               System.out.println("Number of edges: " + graph.edgeCount());
               break;
            case "v":
               System.out.println("Number of vertices: " + graph.vertexCount());
               break;
            case "p":
               System.out.println();
               graph.print();
               break;
            case "t":
               System.out.print("Topological Sort: ");
               int[] A = graph.topSort();
               boolean cyclic = false;
               for(int i = 0; i < A.length - 1; i++) {
                  if(A[i] == 0)
                     cyclic = true;
                  System.out.print(A[i] + ", ");
               }
               System.out.println(A[A.length - 1]);
               if(cyclic)
                  System.out.println("The graph is cyclic");
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
