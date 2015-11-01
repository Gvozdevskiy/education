/**
 * Created by Паша on 28.10.2015.
 */
public class MyVertex implements Vertex {
    double pageRank;
    int inDegree;
    int outDegree;
    Node InEdges;
    Node OutEdges;

    MyVertex(int n){
        pageRank=(double)1/n;
        inDegree=0;
        outDegree=0;
        InEdges=null;
        OutEdges=null;
    }

   public double getPageRank(){
       return pageRank;
   }

        public void calculateNewPageRank(){

        double newPageRank=0;
        Node p=InEdges;

        while (p!=null){
            newPageRank=newPageRank+(p.getVertex().getPageRank()/p.getVertex().getOutDegree());
            p=p.getNext();
        }

            pageRank=newPageRank;

    }

    public int getInDegree(){
        return inDegree;
    }

    public int getOutDegree(){
        return outDegree;
    }

    public void connect(Vertex v){
        outDegree++;
        OutEdges=new Node(v, OutEdges);
        v.addInEdge(this);
    }

    public void addInEdge(Vertex v){
        inDegree++;
        InEdges=new Node(v,InEdges);
    }
}
