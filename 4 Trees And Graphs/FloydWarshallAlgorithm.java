package com.company.GraphTheory;
import java.util.*;
public class FloydWarshallAlgorithm {
    final static int INF = 99999;
//    final static int INF = Integer.MAX_VALUE;

    public static int [][] floyd_Warshall(int [][]graph) {
        int v = graph.length;
        int[][]dist = new int[v][v];
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                dist[i][j] = graph[i][j];
            }
        }
        // Phases, in kth phase we include vertices (1,2, .... k) as intermediate Vertex
        for (int k = 0; k < v; k++) {
            // Iterate over 2D distance Matrix
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    // if Vertex k is included, and we can minimize the dist?
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
//        for(int [] row: dist){
//            System.out.println(Arrays.toString(row));
//        }
        return dist;
    }

    public static void main(String [] args) {

//        int[][] dist = {{0, 2, 1, INF, 3},
//                        {INF, 0,INF, 4, INF},
//                        {INF, 1, 0, INF, 1},
//                        {1, INF, 3, 0,5},
//                        {INF, INF, INF,INF, 0}};
        int[][] dist = {{0, INF, -2, INF},
                        {4, 0, 3, INF},
                        {INF, INF, 0, 2},
                        {INF, -1, INF, 0}};
        int [][]shortestPaths =  floyd_Warshall(dist);
        for (int[] row : shortestPaths) {
            System.out.println(Arrays.toString(row));
        }

//        for(int i=0; i<shortestPaths.length; i++){
//            for(int j=0; j<shortestPaths.length; j++){
//                if(dist[i][j] == 99999){
//                    System.out.print("INF" + " ");
//                }else{
//                    System.out.print(dist[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
    }
}
