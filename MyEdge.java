
public class MyEdge implements Edge210 {
    
    private int getVert1;
    private int getVert2;
    private double getWeight;

    MyEdge(int getVert1, int getVert2, double getWeight) {
        this.getVert1 = getVert1;
        this.getVert2 = getVert2;
        this.getWeight = getWeight;
    }

    @Override
    public int getVert1() {
        return getVert1;
    }

    @Override
    public int getVert2() {
        return getVert2;
    }

    @Override
    public double getWeight() {
        return getWeight;
    }

    @Override
    public int otherVert(int v) {
        return getVert2;
    }

    @Override
    public boolean hasVert(int v) {
        return false;
    }

}