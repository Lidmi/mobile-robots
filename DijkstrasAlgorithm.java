
import javax.swing.*;
import java.util.ArrayList;

class DijkstrasAlgorithm extends Thread{

    private static final int NO_PARENT = -1;
    static ArrayList<Integer> parents_array = new ArrayList<>();
    static int[][] adjacencyMatrix = { {0,0,0,0,1,0},
            {0,0,0,0,0,1},
            {0,0,0,3,4,5},
            {0,0,3,0,5,4},
            {1,0,4,5,0,3},
            {0,1,5,4,3,0}
    };
   static int start;
    static int end;
     int cathegory;
    OneRob_Painting onerob;
    int process;
    public DijkstrasAlgorithm(OneRob_Painting onerob1,int start1,int end1,int cathegory1,ArrayList<Integer> parents){
        this.onerob=onerob1;
        this.start=start1;
        this.end=end1;
        this.cathegory=cathegory1;
        this.parents_array=parents;

    }
    private void dijkstra(int[][] adjacencyMatrix,
                                 int startVertex, int endVertex)
    //в конструктор передаем матрицу смежности, начальную и конечную вершины пути
    {

        int nVertices = adjacencyMatrix[0].length;

        int[] shortestDistances = new int[nVertices]; //информация о кратчайших растояниях

        boolean[] added = new boolean[nVertices];

        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;

        int[] parents = new int[nVertices];//массив предков для восстановления кратчайшего пути

        parents[startVertex] = NO_PARENT;


        for (int i = 1; i < nVertices; i++)
        {

            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, endVertex, shortestDistances, parents);
    }

    private void printSolution(int startVertex,int endVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int vertexIndex=endVertex;
            if (vertexIndex != startVertex)
            {

                System.out.println("Робот ");
                printPath(vertexIndex, parents);
            }
        }

    private  void printPath(int currentVertex,
                                  int[] parents)
    {


        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        this.parents_array.add(currentVertex);

    }
    public void run(){
        dijkstra(adjacencyMatrix, start,end);
        process=onerob.paint(this.parents_array, cathegory,this);
        System.out.println("process "+process);
    }



}



