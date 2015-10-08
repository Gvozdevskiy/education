import java.util.HashMap;

/**
 * Created by Паша on 07.10.2015.
 */
public class LazyMultipliedMatrices implements Matrix {

    Matrix leftMatrix;
    Matrix rightMatrix;

    HashMap<Integer, Double> hashMap =new HashMap<Integer,Double>();

    int height;
    int width;

    boolean known[][];

    LazyMultipliedMatrices(Matrix leftMatrix, Matrix rightMatrix){

        if(rightMatrix.getHeight()!=leftMatrix.getWidth()){
            throw new ArithmeticException();
        }

        this.leftMatrix=leftMatrix;
        this.rightMatrix=rightMatrix;

        height=leftMatrix.getHeight();
        width=rightMatrix.getWidth();

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
       Vector v=rightMatrix.getRow(0).multiply(leftMatrix.getRow(i).getCoordinate(0));

        for (int j=1;j<width;j++){
            v=v.add(rightMatrix.getRow(j).multiply(leftMatrix.getRow(i).getCoordinate(j)));
        }

        return v;
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
            double val=leftMatrix.getRow(i).multiply(rightMatrix.getColumn(j));
            hashMap.put(1000000007*i+j, val);
            return (val);
        }

    }

    public  Matrix transpose(){ return new TransposedMatrix(this);}
}


