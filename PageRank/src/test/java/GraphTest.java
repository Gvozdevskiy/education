import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Jama.Matrix;

import static org.junit.Assert.*;

public class GraphTest {

    int n=100;

    public Matrix power(Matrix M, int k){
        if(k==1){

            return M;

        }

        if(k%2==0){
            Matrix N=power(M, k/2);
            return N.times(N);
        }
        else {
            Matrix N=power(M, (k-1)/2);
            return N.times(N).times(M);
        }
    }

    @Test

    public void pageRankTest() {

        double[][] adjacencyMatrix=new double[n][n];
        Scanner scanner;


        try {
            File file = new File("adjacencyMatrix.txt");
            scanner=new Scanner(file);


        for (int i = 0; i < n; i++) {

            for(int j=0; j < n; j++){

                adjacencyMatrix[i][j]=scanner.nextInt();

            }
        }
        } catch (FileNotFoundException e) {System.out.print('Ы');}



        Graph G=new MyGraph(n,adjacencyMatrix);

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                adjacencyMatrix[i][j]=adjacencyMatrix[i][j]/G.getDegree(i);
            }
        }


        Matrix M=new Matrix(adjacencyMatrix);

        M=power(M,100);

        double[][] power=M.getArray();
        G.calculatePageRank(100);



        assertTrue(G.getPageRank(42)-power[0][42]<0.005);

    }
}