package com.company.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class ZeroMatrix {
    public static void setMatrixZero(int [][]matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String [] args){
        int [][]matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixZero(matrix);
        // Display the Resultant Matrix
        for(int []row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
