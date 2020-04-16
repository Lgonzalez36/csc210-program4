import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    private int numVerts;
    private int[] edgeTo; // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo; // distTo[v] = weight of shortest such edge
    private boolean[] marked; // marked[v] = true if v on tree, false otherwise

    void PrimMST(MyGraph g) {
        PriorityQueue<ArrayList<Edge210>> pq = new PriorityQueue<>();
        edgeTo = new int [numVerts];
        distTo = new double[numVerts];
        marked = new boolean[numVerts];

        for (int v = 0; v < g.numVerts(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            edgeTo[v] = -1;
            marked[v] = false;
        }

        distTo[startVertx() ] = 0;
        pq.add(g.edges(startVertx()));
        

    }

    private int startVertx() {
        return 0;
    }
}