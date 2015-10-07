/**
 * Created by Паша on 07.10.2015.
 */
public class HashTableForLazyThings {
    Cell[] StartsOfLists;

    HashTableForLazyThings(int height){
        StartsOfLists=new Cell[height];

        for (int i=0; i<height; i++){
            StartsOfLists[i]=new Cell(0,0,0);
        }
    }

    public void setCell(Cell cell){
        cell.setNext(StartsOfLists[cell.getI()].getNext());
        StartsOfLists[cell.getI()].setNext(cell);
    }

    public double getCell(int i,int j){
        Cell c=StartsOfLists[i].getNext();

        while (c.getJ()!=j){
            c=c.getNext();
        }

        return c.getValue();
    }

}


