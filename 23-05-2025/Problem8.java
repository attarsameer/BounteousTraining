//8. Group Anagrams
// Given an array of strings, group the anagrams together.

import java.util.*;

public class Problem8 {
     public List<List<String>> gruopAnagrams(String[] strs){
        if(strs.length==0) return new ArrayList<>();
        Map<String, List<String>> map=new HashMap<>();
        
        for(String word:strs){
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
	public static void main(String[] args) {
	    
	    Problem8 solution=new Problem8();
	    
	    String[] str={"eat", "tea", "silent","listen"};
	    List<List<String>> result=solution.gruopAnagrams(str);
	    
		for(List<String> output:result){
		    System.out.println(output);
		}
	}
}
