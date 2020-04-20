import java.util.Comparator;
/** 
 * EdgeComparator implments Comparator of MyEdges
 * Sorts from weight from least to greatest
 * @author Luis Gonzalez 
 */
public class EdgeComparator implements Comparator<MyEdge> {

    /**
     * Ctor of EdgeComparator
     */
    public EdgeComparator(){
    }

    /**
     * compares two MyEdge Objects
     * and returns the smallest graph weight
     */
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