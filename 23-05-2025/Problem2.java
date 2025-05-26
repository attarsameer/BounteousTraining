// 2. Subarray Sum Equals K
// Given an array of integers and a target sum k, return the total number of continuous subarrays whose sum equals to k.
import java.util.*;
public class Problem2{
	public static void main(String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int target=sc.nextInt();
	    
		System.out.println(SubArraySum(n, arr, target));
		
	}
	
	public static int SubArraySum(int n, int[] arr, int target){
	    int sum=0;
	    int count=0;
	    HashMap<Integer, Integer> map=new HashMap<>();
	    

	    for(int i=0;i<n;i++){
	        sum+=arr[i];
	        if(sum==target){
	            count++;
	        }
	        if(map.containsKey(sum-target)) count+=map.get(sum-target);
	        map.put(sum, map.getOrDefault(sum, 0)+1);
	        
	        
	        
	    }
	    
	    return count;
	}
}