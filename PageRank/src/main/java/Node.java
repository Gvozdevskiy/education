/**
 * Created by Паша on 28.10.2015.
 */
public class Node {
    Vertex vertex;
    Node next;
    Node(Vertex vertex,Node next){
        this.vertex=vertex;
        this.next=next;
    }

    public Vertex getVertex(){
        return vertex;
    }

    public Node getNext() {
        return next;
    }
}
