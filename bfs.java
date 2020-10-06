import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class bfs{

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int from, int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }

    public static boolean hasPathBFS(ArrayList<ArrayList<Integer>> adj,int from, int to){
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(from);
        while(!queue.isEmpty()){
            int node = queue.remove();
            if(node == to) return true;
            if(visited.contains(node)) continue;
            visited.add(node);
            for(int child: adj.get(node)){
                queue.offer(child);
            }
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
        int to = 2;

        boolean exists = hasPathBFS(adj,from, to);
        System.out.println(exists);
    }
}