import java.util.Scanner;

public class GraphMatrix {
    public static void main(String[] args) {
        int vertices, edges = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vertices edges: ");
        vertices = sc.nextInt();
        edges = sc.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];

        for(int i=0; i<edges; i++) {
            System.out.println("Enter the vertices for edge: ");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjacencyMatrix[v1][v2] = 1;
            adjacencyMatrix[v2][v1] = 1;
        }

        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                 System.out.println(adjacencyMatrix[i][j]);
            }
        }
    }
}

/* 
 * other way : vertices to linked list.
 */