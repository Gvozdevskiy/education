/**
 * Created by Паша on 08.10.2015.
 */
public class TransposedMatrix implements Matrix  {

    Matrix matrix;

    TransposedMatrix(Matrix matrix){
        this.matrix=matrix;
    }

    public int getHeight(){
        return matrix.getWidth();
    }

    public int getWidth(){
        return matrix.getHeight();
    }

    public Matrix multiple(Matrix M){
        return new LazyMultipliedMatrices(this, M);
    }

    public Matrix add(Matrix M){
        return new LazyAddedMatrices(this, M);
    }

    public Vector getRow(int i){
        return matrix.getColumn(i);
    }

    public Vector getColumn(int j){
        return matrix.getRow(j);
    }

    public double getCell(int i, int j){
        return matrix.getCell(j,i);
    }

    public  Matrix transpose(){ return matrix;}
}
