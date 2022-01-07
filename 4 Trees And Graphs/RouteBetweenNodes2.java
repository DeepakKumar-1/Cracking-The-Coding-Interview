import java.util.*;
public class RouteBetweenNodes2 {

    private static boolean search(int [][]adjMatrix, int currentVertex, int terminate, boolean [] visited){
        if(currentVertex == terminate){
            return true;
        }
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                // So, i is Neighbour of Current Vertex
                if(search(adjMatrix, i, terminate, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(int[][] adjMatrix, int source, int terminate) {
        if(source == terminate){
            return true;
        }
        boolean []visited = new boolean[adjMatrix.length];
        return search(adjMatrix, source, terminate, visited);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // Take Number of Vertices and Edges
        System.out.print("Enter Number of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter Number of Edges: ");
        int e = sc.nextInt();
        int[][] adjMatrix = new int[n][n];
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
        }

        for(int []row:  adjMatrix){
            System.out.println(Arrays.toString(row));
        }
        System.out.print("Enter Source and Terminating Vertex: ");
        int source = sc.nextInt();
        int terminate = sc.nextInt();
        boolean ans = search(adjMatrix, source, terminate);
        System.out.println(ans);
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
