import java.util.ArrayList;
/** 
 * MyEdge implements Edge210 and Collects
 * the data to be used as Objects for 
 * the other Classes 
 * @author Luis Gonzalez 
 */
public class MyEdge implements Edge210{
    /** Class variable to get vertex1 */
    private int getVert1;
    /** Class variable to get vertex2 */
    private int getVert2;
    /** Class variable to get the weight */
    private double getWeight;
    /** Class reference of to use as an Object */
    private AdjacencyList adj;

    /**
     * Ctor for MyEdge
     * Collects data given from AdjacencyList Class
     * Sets the initials value for the Class attribute
     * @param getVert1 Vertex one
     * @param getVert2 Vertex two
     * @param getWeight The weight bewtween them
     */
    MyEdge(int getVert1, int getVert2, double getWeight) {
        this.getVert1 = getVert1;
        this.getVert2 = getVert2;
        this.getWeight = getWeight;
    }
    
    /**
     * Ctor for MST
     * Collects data given from MST Class
     * Sets the initial value for Class attribute
     * @param adj
     */
	public MyEdge( AdjacencyList adj) {
        this.adj = adj;
	}

	@Override
    public int getVert1() {
        return this.getVert1;
    }

    @Override
    public int getVert2() {
        return this.getVert2;
    }

    @Override
    public double getWeight() {
        return this.getWeight;
    }

    /**
     * Makes a full list of all the edges
     * the vertex is connected to from given values
     * @param v The vertex that is being compared to
     * @param k The size to initiate the arrayList
     * @return Returns a full list of every connection of v
     */
    public ArrayList<MyEdge> edges(int v, int k) {
        ArrayList<MyEdge> arrayList = new ArrayList<>(k);
        arrayList.addAll(adj.list[v]);
        return arrayList;
    }

}