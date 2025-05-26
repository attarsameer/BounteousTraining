// 1. Two Sum II - Input array is sorted
//Given a sorted array of integers, return the indices of the two numbers such that they add up to a specific target.

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int target=sc.nextInt();
        
        
        twoSum(arr, n, target);
    }
    
    
    public static void twoSum(int[] arr, int n, int k){
        int start=0, end=n-1;
        while(start<end){
            if(arr[start]+arr[end]==k){
                System.out.println(start+" "+end);
            }
            
            if(arr[start]+arr[end]<k){
                start++;
            }else{
                end--;
            }
        }
    }
}