package com.company.ArraysAndStrings;

import java.util.HashMap;

public class IsUnique {

    public static boolean isUnique(String str){
        HashMap<Character, Boolean> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(map.containsKey(ch)){
                return false;
            }else{
                map.put(ch, false);
            }
        }
        return true;
    }

    public static void main(String []args){
        String str = "Deepak";
        System.out.println("Is Unique: " + isUnique(str));
    }
}
