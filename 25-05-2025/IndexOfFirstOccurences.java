//Problem 8
//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


import java.util.*;
public class IndexOfFirstOccurences {


    public static int indexoffirst(String str1, String str2){
        int index=str1.indexOf(str2);
        return index;
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String haystack=sc.nextLine();
        String needle=sc.nextLine();
        System.out.println(indexoffirst(haystack, needle));
    }
    
}
