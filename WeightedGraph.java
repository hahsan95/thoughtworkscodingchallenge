
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        char source;
        char destination;
        int weight;

        public Edge(int index, char source, char destination, int weight) {
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
            for (int i = 0; i < vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int index, char source, char destination, int weight) {
            Edge edge = new Edge(index, source, destination, weight);
            adjacencylist[index].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i < vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size() ; j++) {
                    System.out.println("town " + list.get(j).source + " is connected to town " +
                            list.get(j).destination + " with distance " +  list.get(j).weight);
                }
            }
        }
    }
      public static void main(String[] args) {
            int vertices = 5;
            Graph trainRoutes = new Graph(vertices);
            trainRoutes.addEdge(0, 'A', 'B', 5);
            trainRoutes.addEdge(1, 'B', 'C', 4);
            trainRoutes.addEdge(2, 'C', 'D', 8);
            trainRoutes.addEdge(3, 'D', 'C', 8);
            trainRoutes.addEdge(3, 'D', 'E', 6);
            trainRoutes.addEdge(0, 'A', 'D', 5);
            trainRoutes.addEdge(2, 'C', 'E', 2);
            trainRoutes.addEdge(4, 'E', 'B', 3);
            trainRoutes.addEdge(0, 'A', 'E', 7);
            trainRoutes.printGraph();
      }
}
