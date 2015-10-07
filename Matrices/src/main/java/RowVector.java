/**
 * Created by Паша on 07.10.2015.
 */
public class RowVector implements Vector {
    int length;
    double[] array;
    RowVector(int i){
        length=i;
        array=new double[i];
    }
    public double multiply (Vector v){
        if(length!=v.getLength()){throw new ArithmeticException();}

        double s=0;

        for (int i=0;i<length;i++){
        s=s+array[i]*v.getCoordinate(i);
     }
        return s;
    }


    public Vector multiply (double l){
        Vector v=new RowVector(length);

        for(int i=0; i<length; i++ ){
            v.set(i,l*array[i]);
        }
        return v;
    }

    public Vector multiply (Matrix M){
        if(length!=M.getWidth()){throw new ArithmeticException();}

        Vector v=new RowVector(M.getHeight());

        for(int i=0; i<M.getHeight(); i++){
        v.set(i,multiply(M.getRow(i)));
        }
    return (v);
    }

   public Vector add(Vector v){
       if(length!=v.getLength()){throw new ArithmeticException();}

       Vector w=new RowVector(length);

       for(int i=0; i<length; i++ ){
           w.set(i,v.getCoordinate(i)+array[i]);
       }
       return w;
   }

    public int getLength(){
        return length;
    }

    public double getCoordinate(int i){
        return array[i];
    }

    public void set(int i, double x){
        array[i]=x;
    }
}

