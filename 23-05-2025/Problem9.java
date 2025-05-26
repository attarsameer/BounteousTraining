//9. Rearrange a no to find min possible no in o(n) and constant space.
 
//for eg input 1. 324 -> output 234 2. 50221 - 01225


public class Problem9 {

    public static int getMinNumber(int num) {
        if (num == 0) return 0;

        int[] count = new int[10];
        int temp = num;
        while (temp > 0) {
            count[temp % 10]++;
            temp /= 10;
        }

        int result = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] > 0) {
                result = i;
                count[i]--;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            while (count[i]-- > 0) {
                result = result * 10 + i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMinNumber(324));
        System.out.println(getMinNumber(50221));
    }
}
