import java.util.HashSet;
import java.util.ArrayList;

public class dfs{

    static void addEdge(ArrayList<ArrayList<Integer>> adj,int from, int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }

    static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj, int from, int to){
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(adj,from,to,visited);
    }

    static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj, int from, int to, HashSet<Integer> visited){
        if(visited.contains(from)) return false;
        visited.add(from);
        if(from == to) return true;
        for(Integer child : adj.get(from)){
            if(hasPathDFS(adj, child, to,visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        int size = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(size);
        

        //making the graph
        for(int i =0;i<size;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        addEdge(adj,0, 1);
        addEdge(adj,1, 2);
        addEdge(adj,2, 3);
        addEdge(adj,3, 4);
        addEdge(adj,3, 5);
        addEdge(adj,4, 5);
        addEdge(adj,4, 6);
        addEdge(adj,5, 6);
        addEdge(adj,5, 7);
        addEdge(adj,6, 7);
        
        int from = 0;
        int to = 6;

        boolean exists = hasPathDFS(adj,from, to);
        System.out.println(exists);
    }
}