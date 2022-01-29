package com.company.ArraysAndStrings;

import java.util.Arrays;

public class RotateImage {     
    
    public static void rotate(int[][] matrix) {
            // To Rotate Matrix 90 Degree there are two Simple Steps
        /*
            STEP1 : FIND the TRANSPOSE (Ri --> Ci) of the Matrix
            STEP2 : FLIP the ELEMENTS 
        */

            // Step1: Transpose 
            for(int row = 0;row < matrix.length; row++){
                for(int column = 0 ; column <row; column++){
                    // INTERCHANGE the row ELEMENTS with COLUMN
                    int temp = matrix[row][column];
                    matrix[row][column] = matrix[column][row];
                    matrix[column][row] = temp;
                }
            }

//         for(int[] row: matrix){
//             System.out.println(" Transpose: "+ Arrays.toString(row));
//         }

            // At this point we have TRANSPOSE of the Matrix 
            // STEP2 : NOW Flip the ELEMENTS of ROW
        /* 
        
     Original Matrix          Transpose        Now FLIP THE ELEments of EACH ROw
     
                             start    end        
                                \     /                        
        1   2  3       0 -->    1  4  7     flip 1 with 7      7  4  1
        4   5  6       1 -->    2  5  8     flip 2 with 8      8  5  2
        7   8  9       2 -->    3  6  9     flip 3 with 9      9  6  3
          
        
        */

            int start = 0; // Take start pointer and points to 0
            int end   = matrix.length -1 ; // Take End pointer and points to n-1 index i.e Last Index of ROW

            // FLIP the Elements till START <= END
            while(start <= end){
                // Flip for EACH ROW 
                // Use For LOOP 
                for(int row = 0; row < matrix.length ; row++){
                    // Swap/ Flip the Elements of Start and End
                    int temp           = matrix[row][start];
                    matrix[row][start] = matrix[row][end];
                    matrix[row][end]   = temp;
                }

                // Now Increment the START 
                start ++;
                // And Decrement the END
                end--;
            }
        }
        public static void main(String []args){
            int [][]matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
            rotate(matrix);
            // Display the Resultant Matrix
            for(int []row : matrix){
                System.out.println(Arrays.toString(row));
            }
        }
}
