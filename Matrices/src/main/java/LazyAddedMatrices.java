/**
 * Created by Паша on 07.10.2015.
 */
public class LazyAddedMatrices implements Matrix {

    Matrix leftMatrix;
    Matrix rightMatrix;

    HashTableForLazyThings hashTable;

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

        hashTable=new HashTableForLazyThings(height);
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
            return hashTable.getCell(i,j);
        }

        else {
            known[i][j]=true;
            hashTable.setCell(new Cell(i,j,leftMatrix.getCell(i,j)+rightMatrix.getCell(i,j)));
            return (leftMatrix.getCell(i,j)+rightMatrix.getCell(i,j));
        }

    }
}
