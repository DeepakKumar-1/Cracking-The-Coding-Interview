package com.company.ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {
    public static String sort(String str){
        char []content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));
    }
    public static void main(String []args){
        String str1 = "Deepak";
        String str2 = "kapeeD";
        System.out.println("Is Permutation: " + permutation(str1,str2));
    }
}
