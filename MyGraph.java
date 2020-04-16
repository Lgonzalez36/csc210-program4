import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyGraph implements Graph210 {
    ArrayList<Edge210> edgeList = new ArrayList<>();
    ArrayList<Edge210> allEdgeList = new ArrayList<>();
    AdjacencyList arrayAdj = new AdjacencyList();

    public MyEdge e;
    private int numVerts;
    private int numEdges;
    private AdjacencyList adj;

   MyGraph(int numVerts, int numEdges, AdjacencyList adj){
       this.numVerts = numVerts;
       this.numEdges = numEdges;
       this.adj = adj;
   }

    @Override
    public int numVerts() {
        return numVerts;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Edge210 addEdge(int v1, int v2, double weight) {
        e = new MyEdge(v1, v2, weight);
        edgeList.add(e);
        return e;
    }

    @Override
    public ArrayList<Edge210> edges(int v) {
        for (int i = 0; i <arrayAdj.list.length ; i++) {
            LinkedList<MyEdge> adjlist = arrayAdj.list[i];
            for (int j = 0; j <adjlist.size() ; j++) {
                
            }
        }
		return null;

    }

    @Override
    public List<Edge210> allEdges() {
        return allEdgeList;
    }
}