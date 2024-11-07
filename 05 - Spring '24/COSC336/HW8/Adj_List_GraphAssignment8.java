import java.util.*;
import java.io.*;

  public class Adj_List_GraphAssignment8{
    int n;  // no of nodes
    ArrayList<ArrayList<Integer> > adj; 
    
    //constructor taking as the single parameter the number of nodes
    Adj_List_GraphAssignment8(int no_nodes) {
      n = no_nodes;
      adj =  new ArrayList<ArrayList<Integer> >(n);
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<Integer>());
      
    }
    
    // A utility function to add an edge in an
    // undirected graph; for directed graph remove the second line
    public void addEdge(int u, int v)
    {
      adj.get(u).add(v);
      adj.get(v).add(u);  //Un-commented for an undirected graph
    }
    
    public void BFS(int s, int dist[], int npath[]) {
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        dist[s] = 0;
        npath[s] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    dist[v] = dist[u] + 1;
                    npath[v] = npath[u];
                } else if (dist[v] == dist[u] + 1) {
                    npath[v] += npath[u];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int v = 7; 
        int s = 0; 

        Adj_List_GraphAssignment8 graph = new Adj_List_GraphAssignment8(v);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);

        int dist[] = new int[v];
        int npath[] = new int[v];

        graph.BFS(s, dist, npath);

        System.out.println("Shortest Path lengths from source vertex " + (s + 1) + " to all vertices:");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex " + (i + 1) + ": " + dist[i]);
        }
        
        System.out.println("Number of Shortest Paths from source vertex " + (s + 1) + " to all vertices:");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex " + (i + 1) + ": " + npath[i]);
        }
    }
  }