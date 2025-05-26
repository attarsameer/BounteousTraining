// 7. Strings
//Longest Substring Without Repeating Characters Given a string, find the length of the longest substring without repeating characters.

import java.util.*;

public class Problem7{

    public static int longestSubString(String str){

        int n=str.length();
        int p1=0, p2=0;
        int maxlength=0;
        int length=0;

        HashMap<Character, Integer> map=new HashMap<>();



        while(p2<n){

            if(map.containsKey(str.charAt(p2))){
                p1=Math.max(map.get(str.charAt(p2))+1, p1);
            }

            map.put(str.charAt(p2), p2);

            length=p2-p1+1;
            maxlength=Math.max(maxlength, length);
            p2++;
        }

        return maxlength;
    }






    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(longestSubString(str));
    }
}