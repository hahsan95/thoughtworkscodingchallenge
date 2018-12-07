
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        char source;
        char destination;
        int weight;

        public Edge(char source, char destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(char source, char destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i < vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }
      public static void main(String[] args) {
            int vertices = 5;
            Graph trainRoutes = new Graph(vertices);
            trainRoutes.addEdge('A', 'B', 5);
            trainRoutes.addEdge('B', 'C', 4);
            trainRoutes.addEdge('C', 'D', 8);
            trainRoutes.addEdge('D', 'C', 8);
            trainRoutes.addEdge('D', 'E', 6);
            trainRoutes.addEdge('A', 'D', 5);
            trainRoutes.addEdge('C', 'E', 2);
            trainRoutes.addEdge('E', 'B', 3);
            trainRoutes.addEdge('A', 'E', 7);
            trainRoutes.printGraph();
      }
}
