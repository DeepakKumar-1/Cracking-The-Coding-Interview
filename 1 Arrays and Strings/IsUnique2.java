package com.company.ArraysAndStrings;

public class IsUnique2 {
    public static boolean isUnique(String str){
        if(str.length() > 128){
            return false;
        }
        boolean []char_set = new boolean[128];
        for(int i=0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            } else{
                char_set[val] = true;
            }
        }
        return true;
    }

    public static void main(String []args){
        String str = "Deepak";
        System.out.println("Is Unique: " + isUnique(str));
    }
}
