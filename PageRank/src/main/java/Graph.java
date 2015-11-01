/**
 * Created by Паша on 28.10.2015.
 */
public interface Graph {

    void calculatePageRank(int numberOfIterations);
    int getDegree(int i);
    double getPageRank(int i);

}
