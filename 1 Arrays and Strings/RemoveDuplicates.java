package com.company.ArraysAndStrings;
import java.util.*;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int []arr){
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : arr){
            if(!map.containsKey(element)){
                map.put(element, true);
                list.add(element);
            }
        }
        return list;
    }

    public static ArrayList<Integer> removeDuplicates2(int []arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : arr){
            if(!list.contains(element)){
                list.add(element);
            }
        }
        return list;
    }

    public static void main(String []args){
        int [] arr = {1, 2, 3, 4, 1, 2, 4, 5, 6};
        System.out.println("After Removing Duplicates Array is: " + removeDuplicates(arr));
        System.out.println("After Removing Duplicates Array is: " + removeDuplicates2(arr));
    }
}
