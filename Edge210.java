/**
 * This interface models an edge in a Graph210 for CSC 210, Spring 2020.
 * 
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.1
 */
public interface Edge210 {

	/**
     * Returns the first "from" vert on the edge.
     * @return Returns the first vert
     */
    public int getVert1();

    /**
     * Returns the second "to" vert on the edge.
     * @return Returns the second vert
     */
    public int getVert2();

    /**
     * Returns the edge weight, a positive number (greater than 0)
     * @return Returns the edge weight
     */
    public double getWeight();


}
