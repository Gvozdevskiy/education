
import java.util.Scanner;

/**
 * Created by Паша on 07.10.2015.
 */

public class DenseMatrix implements Matrix {
    int height;
    int width;
    Vector array[];
    DenseMatrix(int height, int width, Scanner scanner){
        this.height=height;
        this.width=width;

        array=new Vector[height];
        for(int i=0; i<height; i++){
            array[i]=new RowVector(width);
            for (int j=0; j<width; j++){
                array[i].set(j,scanner.nextDouble());
            }
        }
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Matrix multiple(Matrix M){
        return new LazyMultipliedMatrices(this, M);
    }

    public Matrix add(Matrix M){
        return new LazyAddedMatrices(this, M);
    }

    public Vector getRow(int i){
        return array[i];
    }

    public Vector getColumn(int j){
    return new ColumnVector(this, j);
    }

    public double getCell(int i, int j){
        return array[i].getCoordinate(j);
    }

    public  Matrix transpose(){ return new TransposedMatrix(this);}
}
