import java.util.HashMap;

/**
 * Created by Паша on 07.10.2015.
 */
public class LazyAddedMatrices implements Matrix {

    Matrix leftMatrix;
    Matrix rightMatrix;

    HashMap<Integer, Double> hashMap =new HashMap<Integer,Double>();

    int height;
    int width;

    boolean known[][];

    LazyAddedMatrices(Matrix leftMatrix, Matrix rightMatrix){

        if(leftMatrix.getHeight()!=rightMatrix.getHeight() || leftMatrix.getWidth()!=rightMatrix.getWidth()){
            throw new ArithmeticException();
        }

        this.leftMatrix=leftMatrix;
        this.rightMatrix=rightMatrix;

        height=leftMatrix.getHeight();
        width=leftMatrix.getWidth();

        known=new boolean[height][width];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                known[i][j]=false;
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
        return (leftMatrix.getRow(i).add(rightMatrix.getRow(i)));
    }

    public Vector getColumn(int j){
        return new ColumnVector(this, j);
    }

    public double getCell(int i, int j){
        if(known[i][j]){
            return hashMap.get(1000000007*i+j);
        }

        else {
            known[i][j]=true;
            double val=leftMatrix.getCell(i,j)+rightMatrix.getCell(i,j);
            hashMap.put(1000000007*i+j, val );
            return (val);
        }

    }

    public  Matrix transpose(){ return new TransposedMatrix(this);}
}
