package com.company.BitManipulation;

import java.util.Scanner;

public class FlipBitToWin {
    
    public static int flipBit(int a){
        // If All 1s, this is already the Longest Sequence
        if(~a == 0)
            return Integer.BYTES * 8;
        
        int currentLength = 0;
        int prevLength = 0;
        int maxLength = 1;
        while(a != 0){
            if((a&1) == 1){
                currentLength++;
            } else if((a&1) == 0){
                prevLength = (a&2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(prevLength+currentLength+1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any Number: ");
        int x = sc.nextInt();
        System.out.println("Maximum Length is: " + flipBit(x));
    }
}
