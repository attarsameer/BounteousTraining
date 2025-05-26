//3. Next Greater Element
//Given a circular array, find the next greater number for every element. 

import java.util.*;

public class Problem3 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                result[stack.pop()] = current;
            }

            if (i < n) {
                stack.push(i);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
