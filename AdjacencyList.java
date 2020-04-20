import java.util.ArrayList;
/** 
 * AdjacencyList Collects proper data to make an adjecency
 *  list of all the edges in the given undiredted graph
 * @author Luis Gonzalez 
 */
public class AdjacencyList {
    /** Number of vertices to make the adjacency list */
    public int vertices;
    /** Class list */
    public ArrayList<MyEdge>[] list;
   
    /** 
     * Ctor for ReadText Class 
     */
	public AdjacencyList() {
    }
    
    /**
     * Gets all of the params to create MyEdge Objects
     * MyEdge Objects are then added to the adjacency list
     * @param v1 Vertex to
     * @param v2 Vertex from
     * @param weight Weight between given vertices
     */
	public void addEdgeAdj(int v1, int v2, Double weight) {
        MyEdge edgeTo = new MyEdge(v1, v2, weight);
        MyEdge edgeFrom = new MyEdge(v2, v1, weight);
        list[v1].add(edgeTo);
        list[v2].add(edgeFrom);
    }

    /**
     * Makes a proper empty adjacency list
     * from the number of vertices given
     * @param vertices total number of vertices
     */
	void makeAdjList(int vertices) {
        this.vertices = vertices;
        list = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++) {
            list[i] = new ArrayList<>();
        }
    }
}
