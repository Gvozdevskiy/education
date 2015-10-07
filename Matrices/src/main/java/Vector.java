/**
 * Created by Паша on 07.10.2015.
 */
public interface Vector {
    double multiply (Vector v);
    Vector multiply (double l);
    Vector multiply (Matrix M);
    Vector add(Vector v);
    int getLength();
    double getCoordinate(int i);
    void set(int i, double x);
}
