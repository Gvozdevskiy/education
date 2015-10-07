/**
 * Created by Паша on 07.10.2015.
 */
public class ColumnVector implements Vector{

    Matrix matrix;
    int index;

    ColumnVector(Matrix matrix, int index){
        if(index<0 || index>matrix.getWidth()){throw new ArrayIndexOutOfBoundsException();}

        this.matrix=matrix;
        this.index=index;
    }

    public double multiply (Vector v){
        if(matrix.getHeight()!=v.getLength()){throw new ArithmeticException();}

        double s=0;

        for (int i=0;i<matrix.getHeight();i++){
            s=s+matrix.getCell(i,index)*v.getCoordinate(i);
        }
        return s;
    }
    public Vector multiply (double l){
        Vector v=new RowVector(matrix.getHeight());

        for(int i=0; i<matrix.getHeight(); i++ ){
            v.set(i,l*matrix.getCell(i,index));
        }
        return v;
    }

    public Vector multiply (Matrix M){

        return new ColumnVector(M.multiple(matrix) ,index);
    }

    public Vector add(Vector v){
        if(matrix.getHeight()!=v.getLength()){throw new ArithmeticException();}

        Vector w=new RowVector(matrix.getHeight());

        for(int i=0; i<matrix.getHeight(); i++ ){
            w.set(i,v.getCoordinate(i)+matrix.getCell(i,index));
        }
        return w;
    }

    public int getLength(){
        return matrix.getHeight();
    }

    public double getCoordinate(int i){
        return matrix.getCell(i,index);
    }

    public void set(int i, double x){}
}
