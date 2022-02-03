package com.company.BitManipulation;

import java.util.Scanner;

public class Conversion {
    public static int bitSwapRequired(int a, int b){
        int count = 0;
        for(int c = a^b; c != 0; c = c&(c-1))
            count++;
        return count;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();
        System.out.println("Conversion Count is: " + bitSwapRequired(a, b));
    }
}
