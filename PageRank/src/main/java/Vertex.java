/**
 * Created by Паша on 28.10.2015.
 */
public interface Vertex {
    double getPageRank();
    void calculateNewPageRank();
    int getInDegree();
    int getOutDegree();
    void connect(Vertex v);
    void addInEdge(Vertex v);
}
