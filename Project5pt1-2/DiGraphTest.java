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
      System.out.println("-Quit (enter q)");
      System.out.println();

      while((n = scanner.next().charAt(0)) != 'q') {
         switch (n) {
            case 'a':
               System.out.println("Add edge from where to where?");
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.addEdge(from, to);
               break;
            case 'd':
               System.out.println("Remove edge from where to where?");
               from = scanner.nextInt();
               to =  scanner.nextInt();
               graph.deleteEdge(from, to);
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
            default:
               System.out.println("Must be a valid operation");
               break;
         }
         System.out.println("\nChoose an operation");
      }
   }
}