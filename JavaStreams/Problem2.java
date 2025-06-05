package JavaStreams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        String s = "Hey Peeps This is Sameer";
        LinkedHashMap<String,Long> li = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(li);
    }
}
