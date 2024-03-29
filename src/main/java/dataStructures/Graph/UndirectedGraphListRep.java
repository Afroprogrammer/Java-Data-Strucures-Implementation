package dataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraphListRep {
    private int V; // number of vertices;
    private int E; // number of edges;
    private LinkedList<Integer> [] adj;


  //creating a linked list for each node
    public UndirectedGraphListRep(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public void depthFirstSearch(int s){
        boolean [] visited = new boolean[V];
        Stack <Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u])
                {
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }

    //implementing breadth first search
    public void breadthFirstSearch( int s){
        boolean [] visited = new boolean[V];
        Queue<Integer>  q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

         //while loop you do the rest of the bfs
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int w : adj[u] )
            {
                if(!visited[w]){
                    visited[w] = true;
                    q.offer(w);
                }
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");

            }
            sb.append("\n");

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraphListRep g = new UndirectedGraphListRep(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);
//        g.breadthFirstSearch(0);
        g.depthFirstSearch(0);
//        System.out.println(g);
    }
}
