import java.util.ArrayList;
import java.util.PriorityQueue;
/** 
 * MST Finds the the Minimun Spanning Tree 
 * using Prim's algorithm 
 * Priority Queue is implemented
 * @author Luis Gonzalez 
 */
public class MST {
    /** Class variable of number of Vertices */
    private int numVerts;
    /**  Class variable of number of total edges from file*/
    private int numEdges;
    /** Class to keep track of the adjacency list */
    private AdjacencyList adj;
    /**  Class varible to store an array of MyEdges connected to a given vertex*/ 
    public ArrayList<MyEdge> edges;
       
    /**
     * Ctor for ReadText
     * Collects data given from ReadText Class 
     * Sets the initials value for the Class attribute
     * @param numVerts2 Total number of vertices from file
     * @param numEdges Total number of vertices from file
     * @param adj2 A completed Adjacency list of edges
     */
    public MST(int numVerts2, int numEdges, AdjacencyList adj2) {
        this.numVerts = numVerts2;
        this.numEdges = numEdges;
        this.adj = adj2;
    }
    /**
     * Creates the min spanning tree using
     * Prim's alogorithm. First it initiates all the graph 
     * to the proper settings to run Prim's
     * Then does Prim's algorithm and sends proper data
     * to MyGraph to write to file
     */
    public void PrimMST() {
        MyEdge cmpEdge = new MyEdge(adj);
        MyGraph graph = new MyGraph();
        EdgeComparator cmp = new EdgeComparator();
        int[] edgeTo= new int [numVerts];
        double[] distTo= new double [numVerts];
        boolean[] marked= new boolean[numVerts];
        for (int v = 0; v < numVerts; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            edgeTo[v] = -1;
            marked[v] = false;
        }
        distTo[startVertx()] = 0;
        marked[startVertx()] = true;
        PriorityQueue<MyEdge> pq = new PriorityQueue<MyEdge>(adj.list[startVertx()].size(), cmp);
        pq.addAll(adj.list[startVertx()]);
        while( !pq.isEmpty()){
            MyEdge poll = pq.poll();
            int vert1 = poll.getVert1();
            int vert2 = poll.getVert2();
            marked[vert1] = true;
            edges = cmpEdge.edges(vert1, pq.size());
            for( MyEdge e : edges){
                int v2 = e.getVert2();
                if( !marked[v2] && e.getWeight() < distTo[v2]){
                    distTo[v2] = e.getWeight();
                    edgeTo[v2] = vert1;
                }
            }    
            int index = findmin(distTo, marked);
            pq.addAll(adj.list[index]);
            pq.removeIf( t -> ( (t.getVert1() == index && t.getVert2() == vert1 || t.getVert1() == vert1))); 
        }
        graph.createFile();
        graph.writeToFile(edgeTo, distTo, numEdges, numVerts);
    }

    /**
     * Finds the min of the updated distTo array that
     * has not already been visited
     * @param distTo updated list of distances 
     * @param marked updated list of known vertices
     * @return Returns the index of the min location
     */
    private int findmin(double[] distTo, boolean[] marked) {
        double min = distTo[0];
        int minIndex = 0;
        for( int i=0; i< numVerts-1; i++){
            if( i > 0){
                break;
            }
            for( int j=1; j< numVerts; j++){
                if( min == 0  && marked[i]){
                    if( !marked[j] &&  distTo[j] < Double.POSITIVE_INFINITY){
                            min = distTo[j];
                            minIndex = j;
                    }
                }
                else if ( !marked[j] && distTo[j] < Double.POSITIVE_INFINITY){
                    if (  min > distTo[j]){
                        min = distTo[j];
                        minIndex = j;
                        return minIndex;
                    }
                }
            }
        }
        return minIndex;
    }

    /**
     * asked the user for the 
     * start location of the graph
     * @return Returns a vertex 
     */
    private int startVertx() {
        return 0;
    }

}