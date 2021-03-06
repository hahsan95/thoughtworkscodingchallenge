
import java.util.LinkedList;
import java.util.HashMap;

public class WeightedGraph {
    static class Edge {
        char start;
        char destination;
        int weight;

        public Edge(int index, char start, char destination, int weight) {
            this.start = start;
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

        public void addEdge(int index, char start, char destination, int weight) {
            Edge edge = new Edge(index, start, destination, weight);
            adjacencylist[index].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i < vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size() ; j++) {
                    System.out.println("town " + list.get(j).start + " is connected to town " +
                            list.get(j).destination + " with distance " +  list.get(j).weight);
                }
            }
        }

        public int pathDistance(int index, char start, char destination){
            LinkedList<Edge> list = adjacencylist[index];
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).destination == destination){
                    return list.get(i).weight;
                }
            }
            return 0;
        }

        public int hasPath(String path){
            HashMap<Character, Integer> trainIndex = new HashMap<Character, Integer>();
            trainIndex.put('A', 0);
            trainIndex.put('B', 1);
            trainIndex.put('C', 2);
            trainIndex.put('D', 3);
            trainIndex.put('E', 4);
            int distance = 0;
            boolean noRoute = false;
            for(int i = 0; i <= path.length() - 3; i += 2){
                char beginning = path.charAt(i);
                char end = path.charAt(i+2);
                int addedDistance = pathDistance(trainIndex.get(beginning), beginning, end);
                if(addedDistance != 0){
                    distance += addedDistance;
                } else {
                    System.out.println("NO SUCH ROUTE");
                    noRoute = true;
                    break;
                }
            }
            if(!noRoute) System.out.println(distance);
            return distance;
        }

        public void numTrips(int maxStops, char start, char destination) {
            int numOfTrips = 0;
            numTripsHelper(maxStops, 0, start, destination);
        }
        public void numTripsHelper(int maxStops, int numStops, char start, char destination){
            int numOfStops = numStops;
            if(numOfStops < maxStops) {
                HashMap<Character, Integer> trainIndex = new HashMap<Character, Integer>();
                trainIndex.put('A', 0);
                trainIndex.put('B', 1);
                trainIndex.put('C', 2);
                trainIndex.put('D', 3);
                trainIndex.put('E', 4);
                LinkedList<Edge> list = adjacencylist[trainIndex.get(start)];

                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).destination == destination){
                        // numOfTrips++;
                        System.out.println(destination);
                    } else {
                        numStops += 1;
                        System.out.println(numStops);
                        numTripsHelper(maxStops, numStops, start, destination);
                    }
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
            // trainRoutes.hasPath("A-B-C");
            // trainRoutes.hasPath("A-D");
            // trainRoutes.hasPath("A-D-C");
            // trainRoutes.hasPath("A-E-B-C-D");
            // trainRoutes.hasPath("A-E-D");
            // trainRoutes.numTrips(2, 'A', 'C');
      }
}
