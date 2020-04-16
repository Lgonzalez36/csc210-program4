import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    int vertices;
    LinkedList<MyEdge> [] list;
    ArrayList<Edge210> [] arrayList;

	public AdjacencyList(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public AdjacencyList() {
	}

	public MyEdge addEdgeAdj(int v1, int v2, Double weight) {

        MyEdge edge = new MyEdge(v1, v2, weight);
        list[v1].add(edge);
        list[v2].add(edge);
        return edge;
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<MyEdge> adjlist = list[i];
            for (int j = 0; j <adjlist.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " +
                adjlist.get(j).getVert2() + " with weight " +  adjlist.get(j).getWeight());
            }
        }
    }

	public ArrayList<Edge210> getEdges() {
        for (int i = 0; i <vertices ; i++) {
            LinkedList<MyEdge> adjlist = list[i];
            for (int j = 0; j <adjlist.size() ; j++) {
                
            }
        }
		return null;
	}
}
