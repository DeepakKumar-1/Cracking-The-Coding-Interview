package com.company.ArraysAndStrings;

public class PalindromicPermutation {


    public static int getCharNumber(char c){
        int  a = Character.getNumericValue('a');
        int  z = Character.getNumericValue('z');
        if(c >= a && c <= z){
            return c - a;
        }
        return -1;
    }

    public static boolean isPermutationOfPalindrome(String str){
         int countOdd = 0;
         int []charTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
         for(char c : str.toCharArray()){
             int x = getCharNumber(c);
             if(x != -1){
                 charTable[x]++;
                 if(charTable[x] % 2 == 1){
                     countOdd++;
                 }else{
                     countOdd--;
                 }
             }
         }
         return countOdd <= 1;
    }

    public static void main(String [] args){
        String str = "Tact Coa";
        System.out.println("IS Permutation of Palindrome: " + isPermutationOfPalindrome(str.toLowerCase()));
    }
}
