/**
 * Created by Паша on 07.10.2015.
 */
public interface Matrix {
    int getHeight();
    int getWidth();
    Matrix multiple(Matrix M);
    Matrix add(Matrix M);
    Vector getRow(int i);
    Vector getColumn(int j);
    double getCell(int i, int j);
}
