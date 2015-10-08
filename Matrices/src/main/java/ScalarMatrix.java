/**
 * Created by Паша on 07.10.2015.
 */
public class ScalarMatrix implements Matrix {
    int size;
    double scalar;

    ScalarMatrix(int size, double scalar){
        this.scalar=scalar;
        this.size=size;
    }
    public int getHeight(){
        return size;
    }

    public int getWidth(){
        return size;
    }

    public Matrix multiple(Matrix M){
        return new LazyMultipliedMatrices(this, M);
    }

    public Matrix add(Matrix M){
        return new LazyAddedMatrices(this, M);
    }

    public Vector getRow(int i){
        Vector v=new RowVector(size);
        for(int j=0;j<size;j++){
            v.set(j,0);
        }
        v.set(i,scalar);
        return v;
    }

    public Vector getColumn(int j){
        Vector v=new RowVector(size);
        for(int i=0;i<size;i++){
            v.set(i,0);
        }
        v.set(j,scalar);
        return v;
    }

    public double getCell(int i, int j){
        return i==j ? scalar : 0;
    }

    public  Matrix transpose(){ return this;}
}

