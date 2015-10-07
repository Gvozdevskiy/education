/**
 * Created by Паша on 07.10.2015.
 */
public class Cell {
    int i;
    int j;
    double value;
    Cell next;

    Cell(int i, int j, double value){
        this.i=i;
        this.j=j;
        this.value=value;
        next=null;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public double getValue() {
        return value;
    }

    public void setNext(Cell next) {
        this.next = next;
    }

    public Cell getNext() {
        return next;
    }
}
