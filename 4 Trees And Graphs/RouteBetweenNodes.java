import java.util.*;
public class RouteBetweenNodes {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // take Number of Vertices and Edges
        System.out.print("Enter Number of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter Number of Edges: ");
        int e = sc.nextInt();
        int [][] adjMatrix = new int[n][n];
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
        }
        // Displaying Graph
        for(int [] arr: adjMatrix){
            System.out.println(Arrays.toString(arr));
        }
        System.out.print("Enter Source and terminate vertex: ");
        int source = sc.nextInt();
        int terminate = sc.nextInt();
        boolean ans = search(adjMatrix, source, terminate);
        System.out.println(ans);
    }

    private static boolean search(int [][]adjMatrix, int source, int terminate) {
        if(source == terminate) return true;
        // Declare a Queue
        Queue<Integer> queue = new LinkedList<>();
        // Declare visited Array of type Boolean
        boolean [] visited = new boolean[adjMatrix.length];
        // Enqueue Source in the Queue and also mark it visited as well
        queue.add(source);
        visited[source] = true;
        // Now Repeat the Following Step While Queue is Not Empty
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            // Explore all the Unvisited Neighbour of CurrentVertex
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    // i is Unvisited Neighbour of currentVertex
                    // Add it into the Queue and mark it as visited
                    queue.add(i);
                    visited[i] = true;
                    if(i == terminate){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// OUTPUT
/*
    Enter Number of Vertices: 6
    Enter Number of Edges: 7
        0 1
        0 4
        2 1
        4 2
        4 3
        3 2
        3 5
        [0, 1, 0, 0, 1, 0]
        [0, 0, 0, 0, 0, 0]
        [0, 1, 0, 0, 0, 0]
        [0, 0, 1, 0, 0, 1]
        [0, 0, 1, 1, 0, 0]
        [0, 0, 0, 0, 0, 0]
        Enter Source and terminate vertex: 1 5
        false
*/
/*
    Enter Number of Vertices: 6
    Enter Number of Edges: 7
        0 1
        0 4
        2 1
        4 2
        4 3
        3 2
        3 5
        [0, 1, 0, 0, 1, 0]
        [0, 0, 0, 0, 0, 0]
        [0, 1, 0, 0, 0, 0]
        [0, 0, 1, 0, 0, 1]
        [0, 0, 1, 1, 0, 0]
        [0, 0, 0, 0, 0, 0]
        Enter Source and terminate vertex: 0 5
        true
*/
