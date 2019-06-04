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
      System.out.println("-is there a path from __ to __ (enter i)");
      System.out.println("-length of the path from __ to __ (enter l)");
      System.out.println("-shortest path from __ to __ (enter s)");
      System.out.println("-print breadth-first-tree (enter s)");
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
               try {
                  int[] A = graph.topSort();
                  for(int i = 0; i < A.length - 1; i++)
                     System.out.print(A[i] + ", ");
                  System.out.println(A[A.length - 1]);
               }
               catch(IllegalArgumentException e) {
                  System.out.println("The graph is cyclic");
               }
               break;
            case "i":
               from = scanner.nextInt();
               to =  scanner.nextInt();
               if (graph.isTherePath(from, to))
                  System.out.println("There is a path from " + from + " to " + to); 
               else
                  System.out.println("There is NOT a path from " + from + " to " + to); 
               N = scanner.nextLine(); 
               break;
            case "l":
               from = scanner.nextInt();
               to =  scanner.nextInt();
               System.out.println("Length of path from " + from + " to " + to + "is: " + graph.lengthOfPath(from, to));
               N = scanner.nextLine();
               break;
             case "s":
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.printPath(from, to);
               N = scanner.nextLine();
               break;
            case "b":
               int s = scanner.nextInt();
               graph.printTree(s);
               N = scanner.nextLine();
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
