import java.util.Comparator;
/** 
 * AdjacencyList Collects proper data to make an adjecency
 *  list of all the edges in the given undiredted graph
 * @author Luis Gonzalez 
 */
public class EdgeComparator implements Comparator<MyEdge> {

    public EdgeComparator(){
    }

    @Override
    public int compare(MyEdge o1, MyEdge o2) {
         if ( o1.getWeight() > o2.getWeight()){
             return 1;
         }
         else if( o1.getWeight() < o2.getWeight()){
            return -1;
        }
        else{
            return 0;
        }
    }
}