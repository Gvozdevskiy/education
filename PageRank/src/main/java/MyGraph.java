import java.util.Scanner;

/**
 * Created by Паша on 28.10.2015.
 */
public class MyGraph implements Graph{

    Vertex[] vertexes;
    int numberOfVertexes;

    MyGraph(int n, double[][] adjacencyMatrix){
        numberOfVertexes=n;
        vertexes=new Vertex[n];

        for (int i=0; i<n; i++){
            vertexes[i]=new MyVertex(n);
        }


        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(adjacencyMatrix[i][j]==1){
                    vertexes[i].connect(vertexes[j]);
                }
            }
        }
    }

    public void calculatePageRank(int numberOfIterations) {

        for (int i=0; i<numberOfIterations; i++){
            for (int j=0; j<numberOfVertexes; j++){
                vertexes[j].calculateNewPageRank();
            }
        }
    }

    public int getDegree(int i){
        return vertexes[i].getOutDegree();
    }


    public double getPageRank(int i) {
        return vertexes[i].getPageRank();
    }
}

