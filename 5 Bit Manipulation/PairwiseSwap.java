package com.company.BitManipulation;

import java.util.Scanner;

public class PairwiseSwap {

    public static int swapOddEvenBits(int x){
        return (((x & 0xaaaaaaaa) >>> 1)| ((x & 0x55555555)<<1));
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any Number: ");
        int x = sc.nextInt();
        System.out.println("Final Answer is: " + swapOddEvenBits(x));
    }
}
