import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Паша on 07.10.2015.
 */
public class Tests {

    File file=new File("Matrix.txt");
    Scanner scanner;
    Matrix M;
    Matrix N;

    public void readMatrix(){
        try {
            scanner = new Scanner(file);

            M=new DenseMatrix(3,3,scanner);

        } catch (FileNotFoundException e) {}
        catch (IOException e){}
    }


    public void printN(){
      for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){
              System.out.print(N.getCell(i,j) + " ");
          }
          System.out.print("\n");
      }

    }
    @Test
    public void generateDenseMatrixTest() {
       readMatrix();
        assertTrue(M.getCell(1,1)==2);
    }

    @Test
      public void RowVectorTest(){
        readMatrix();
        Vector v=((M.getRow(0).multiply(4)).add(M.getRow(1))).add(M.getRow(2));
        assertTrue(v.getCoordinate(0)==4 & v.getCoordinate(1)==2 & v.getCoordinate(2)==3);
        assertTrue(v.multiply(M.getRow(0))==4);
    }

    @Test
    public void ColumnVectorTest(){
        readMatrix();
        Vector v=((M.getColumn(0).multiply(4)).add(M.getColumn(1))).add(M.getColumn(2));
        assertTrue(v.getCoordinate(0)==4 & v.getCoordinate(1)==2 & v.getCoordinate(2)==3);
        assertTrue(v.multiply(M.getColumn(0))==4);
    }

    @Test
    public void RowVectorByMatrixTest(){
        readMatrix();
        Vector v=M.getRow(0).multiply(M);
        assertTrue(v.getCoordinate(0)==1 & v.getCoordinate(1)==0 & v.getCoordinate(2)==0);
    }

    @Test
    public void ColumnVectorByMatrixTest(){
        readMatrix();
        Vector v=M.getColumn(0).multiply(M);
        assertTrue(v.getCoordinate(0)==1 & v.getCoordinate(1)==0 & v.getCoordinate(2)==0);
    }

    @Test
    public void MultiplyingByScalarMatricesTest(){
        readMatrix();
        N=M.multiple(new ScalarMatrix(3,-1));
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                assertTrue(i + " "+ j,N.getCell(i,j)==-M.getCell(i,j));
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                assertTrue(i + " "+ j,N.getCell(i,j)==-M.getCell(i,j));
            }
        }

    }

    @Test
    public void CubeTest(){
        readMatrix();
        N=M.multiple(M).multiple(M);
        printN();
         N=M.multiple(M.multiple(M));
        printN();
    }


    @Test
    public void testByCayleyHamiltonTheorem(){
        readMatrix();
        N=(new ScalarMatrix(3,-1).multiple(M).multiple(M).multiple(M)).add
                (new ScalarMatrix(3,6).multiple(M).multiple(M)).add
                (new ScalarMatrix(3,-11).multiple(M)).add
                (new ScalarMatrix(3,6));

        printN();
    }
}


